package com.abdelhalim.egypt.clinics.api.user.service;

import com.abdelhalim.egypt.clinics.api.user.dto.AuthenticationRequest;
import com.abdelhalim.egypt.clinics.api.user.dto.AuthenticationResponse;
import com.abdelhalim.egypt.clinics.api.user.dto.RegisterRequestDto;
import com.abdelhalim.egypt.clinics.config.JwtService;
import com.abdelhalim.egypt.clinics.entities.patient.Patient;
import com.abdelhalim.egypt.clinics.entities.patient.PatientRepository;
import com.abdelhalim.egypt.clinics.entities.specialty.SpecialtyRepository;
import com.abdelhalim.egypt.clinics.entities.token.Token;
import com.abdelhalim.egypt.clinics.entities.token.TokenRepository;
import com.abdelhalim.egypt.clinics.entities.token.TokenSpecifications;
import com.abdelhalim.egypt.clinics.entities.token.TokenType;
import com.abdelhalim.egypt.clinics.utils.ImageUtils;
import com.abdelhalim.egypt.clinics.utils.RandomUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@Transactional
public class UserService {
    @Autowired
    private SpecialtyRepository specialtyRepository;
    @Autowired
    private PatientRepository repository;
    @Autowired
    private TokenRepository tokenRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequestDto request) {

        var user = new Patient();
        user.setName(request.getName());
        user.setPhone(request.getPhone());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setGender(request.getGender());
        user.setImageUrl(ImageUtils.saveImageBase64(request.getImage(), "user/" + RandomUtils.getRandomLong()));

        var savedUser = repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getPhone(),
                        request.getPassword()
                )
        );
        var user = repository.findByPhone(request.getPhone())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    private void saveUserToken(Patient patient, String jwtToken) {
        var token = Token.builder()
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .baseUser(patient)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(Patient patient) {
        var validUserTokens = tokenRepository.findAll(TokenSpecifications.validTokensByUserId(patient.getId()));
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        refreshToken = authHeader.substring(7);
        userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var user = this.repository.findByPhone(userEmail)
                    .orElseThrow();
            if (jwtService.isTokenValid(refreshToken, user)) {
                var accessToken = jwtService.generateToken(user);
                revokeAllUserTokens(user);
                saveUserToken(user, accessToken);
                var authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken(refreshToken)
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}
package com.abdelhalim.egypt.clinics.entities.token;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long>, JpaSpecificationExecutor<Token> {

    List<Token> findAllByBaseUserIdAndExpiredFalseAndRevokedFalse(Long id);

    List<Token> findAll(Specification<Token> specification);


    Optional<Token> findByToken(String token);
}

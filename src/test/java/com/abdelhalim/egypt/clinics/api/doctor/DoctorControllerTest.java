package com.abdelhalim.egypt.clinics.api.doctor;

import com.abdelhalim.egypt.clinics.api.CustomUtils;
import com.abdelhalim.egypt.clinics.api.doctor.controller.DoctorController;
import com.abdelhalim.egypt.clinics.api.doctor.dto.DoctorDto;
import com.abdelhalim.egypt.clinics.api.doctor.entity.Doctor;
import com.abdelhalim.egypt.clinics.api.doctor.service.DoctorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Transactional
class DoctorControllerTest {
    private static final String ENDPOINT_URL = "/api/doctor";
    @InjectMocks
    private DoctorController doctorController;
    @Mock
    private DoctorService doctorService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(doctorController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    void findAllByPage() throws Exception {
        Page<Doctor> page = new PageImpl<>(Collections.singletonList(new Doctor(1L, "Test")));

        Mockito.when(doctorService.findByCondition(ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/page-query")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(doctorService, Mockito.times(1)).findByCondition(ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(doctorService);

    }

    @Test
    void getById() throws Exception {
        Mockito.when(doctorService.findById(ArgumentMatchers.anyLong())).thenReturn(DoctorBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON));
        Mockito.verify(doctorService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(doctorService);
    }

    @Test
    void save() throws Exception {
//        Mockito.when(doctorService.save(ArgumentMatchers.any(DoctorDto.class))).thenReturn(DoctorBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(DoctorBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(doctorService, Mockito.times(1)).save(ArgumentMatchers.any(DoctorDto.class));
        Mockito.verifyNoMoreInteractions(doctorService);
    }

    @Test
    void update() throws Exception {
//        Mockito.when(governorateService.update(ArgumentMatchers.any())).thenReturn();

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new Doctor(1L, "t"))))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(doctorService, Mockito.times(1)).update(ArgumentMatchers.any(Doctor.class));
        Mockito.verifyNoMoreInteractions(doctorService);
    }

    @Test
    void delete() throws Exception {
        Mockito.doNothing().when(doctorService).deleteById(1L);
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(DoctorBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(doctorService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(doctorService);
    }
}
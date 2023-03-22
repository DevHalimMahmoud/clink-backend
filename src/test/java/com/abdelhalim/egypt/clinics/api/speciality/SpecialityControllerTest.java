package com.abdelhalim.egypt.clinics.api.speciality;

import com.abdelhalim.egypt.clinics.api.CustomUtils;
import com.abdelhalim.egypt.clinics.api.speciality.controller.SpecialityController;
import com.abdelhalim.egypt.clinics.api.speciality.dto.SpecialityDto;
import com.abdelhalim.egypt.clinics.api.speciality.entity.Specialty;
import com.abdelhalim.egypt.clinics.api.speciality.service.SpecialtyService;
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
class SpecialityControllerTest {
    private static final String ENDPOINT_URL = "/api/speciality";
    @InjectMocks
    private SpecialityController specialityController;
    @Mock
    private SpecialtyService specialtyService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(specialityController)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    void findAllByPage() throws Exception {
        Page<Specialty> page = new PageImpl<>(Collections.singletonList(new Specialty(1L, "Test", "test")));

        Mockito.when(specialtyService.findByCondition(ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/page-query")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(specialtyService, Mockito.times(1)).findByCondition(ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(specialtyService);

    }

    @Test
    void getById() throws Exception {
        Mockito.when(specialtyService.findById(ArgumentMatchers.anyLong())).thenReturn(SpecialityBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON));
        Mockito.verify(specialtyService, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(specialtyService);
    }

    @Test
    void save() throws Exception {
//        specialtyService.save(ArgumentMatchers.any(MultiLangSpecialityDto.class));

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(SpecialityBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(specialtyService, Mockito.times(1)).save(ArgumentMatchers.any(SpecialityDto.class));
        Mockito.verifyNoMoreInteractions(specialtyService);
    }

    @Test
    void update() throws Exception {
//        Mockito.when(specialtyService.update(ArgumentMatchers.any()));

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(new Specialty(1L, "t", "test"))))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(specialtyService, Mockito.times(1)).update(ArgumentMatchers.any(Specialty.class));
        Mockito.verifyNoMoreInteractions(specialtyService);
    }

    @Test
    void delete() throws Exception {
        Mockito.doNothing().when(specialtyService).deleteById(1L);
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(SpecialityBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(specialtyService, Mockito.times(1)).deleteById(Mockito.anyLong());
        Mockito.verifyNoMoreInteractions(specialtyService);
    }
}
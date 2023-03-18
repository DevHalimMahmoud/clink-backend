package com.abdelhalim.egypt.clinics.api.governorate.controller;

import com.abdelhalim.egypt.clinics.api.governorate.dto.GovernorateDto;
import com.abdelhalim.egypt.clinics.api.governorate.service.GovernorateService;
import org.hamcrest.Matchers;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
class GovernorateControllerTest {
    private static final String ENDPOINT_URL = "/api/governorate";
    @InjectMocks
    private GovernorateController governorateController;
    @Mock
    private GovernorateService governorateService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(governorateController)
                //.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                //.addFilter(CustomFilter::doFilter)
                .build();
    }

    @Test
    void findAllByPage() throws Exception {
        Page<GovernorateDto> page = new PageImpl<>(Collections.singletonList(GovernorateBuilder.getDto()));

        Mockito.when(governorateService.findByCondition(ArgumentMatchers.any())).thenReturn(page);

        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post(ENDPOINT_URL)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.content", Matchers.hasSize(1)));

        Mockito.verify(governorateService, Mockito.times(1)).findByCondition(ArgumentMatchers.any());
        Mockito.verifyNoMoreInteractions(governorateService);

    }

    @Test
    void getById() throws Exception {
        Mockito.when(governorateService.findById(ArgumentMatchers.anyInt())).thenReturn(GovernorateBuilder.getDto());

        mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT_URL + "/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Is.is(1)));
        Mockito.verify(governorateService, Mockito.times(1)).findById(1);
        Mockito.verifyNoMoreInteractions(governorateService);
    }

    @Test
    void save() throws Exception {
        Mockito.when(governorateService.save(ArgumentMatchers.any(GovernorateDto.class))).thenReturn(GovernorateBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.post(ENDPOINT_URL)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(GovernorateBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(governorateService, Mockito.times(1)).save(ArgumentMatchers.any(GovernorateDto.class));
        Mockito.verifyNoMoreInteractions(governorateService);
    }

    @Test
    void update() throws Exception {
        Mockito.when(governorateService.update(ArgumentMatchers.any(), ArgumentMatchers.anyInt())).thenReturn(GovernorateBuilder.getDto());

        mockMvc.perform(
                        MockMvcRequestBuilders.put(ENDPOINT_URL + "/1")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(CustomUtils.asJsonString(GovernorateBuilder.getDto())))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(governorateService, Mockito.times(1)).update(ArgumentMatchers.any(GovernorateDto.class), ArgumentMatchers.anyInt());
        Mockito.verifyNoMoreInteractions(governorateService);
    }

    @Test
    void delete() throws Exception {
        Mockito.doNothing().when(governorateService).deleteById(ArgumentMatchers.anyInt());
        mockMvc.perform(
                MockMvcRequestBuilders.delete(ENDPOINT_URL + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(CustomUtils.asJsonString(GovernorateBuilder.getIds()))).andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(governorateService, Mockito.times(1)).deleteById(Mockito.anyInt());
        Mockito.verifyNoMoreInteractions(governorateService);
    }
}
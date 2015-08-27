package com.dfostic.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * @author dfostic
 */
@RunWith(MockitoJUnitRunner.class)
public class TrainerControllerTest {
    
    @InjectMocks
    private TrainerController controller;
    
    @Test
    public void createTrainerPage() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/trainer/create"))
                .andExpect(view().name("createTrainer"));
    }
    @Test
    public void createTrainerSuccess() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("lastName", "Mourinho")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(redirectedUrl("/trainer/Jose/Mourinho"));

    }

    @Test
    public void trainerFailValidationFirstNameNull() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("lastName", "Mourinho")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "firstName"));
    }

    @Test
    public void trainerFailValidationFirstNameShort() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "A")
                .param("lastName", "Mourinho")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "firstName"));
    }

    @Test
    public void trainerFailValidationFirstNameLong() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName","ABCDEFGHIGKLMNOPQ") /* 17 chars */
                .param("lastName", "Mourinho")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "firstName"));
    }

    @Test
    public void trainerFailValidationFirstNameDigit() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose2")
                .param("lastName", "Mourinho")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "firstName"));
    }

    @Test
    public void trainerFailValidationLastNameNull() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "lastName"));
    }

    @Test
    public void trainerFailValidationLastNameShort() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("lastName", "A")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "lastName"));
    }

    @Test
    public void trainerFailValidationLastNameLong() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("lastName", "ABCDEFGHIGKLMNOPQ") /* 17 chars */
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "lastName"));
    }

    @Test
    public void trainerFailValidationLastNameDigit() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("lastName", "Mourinho2") /* digit */
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "lastName"));
    }

    @Test
    public void trainerFailValidationDateOfBirthTooYoung() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("lastName", "Mourinho") /* digit */
                .param("dateOfBirth", "2000-01-26")
                .param("salary", "19500000"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "dateOfBirth"));
    }

    @Test
    public void trainerFailValidationSalaryNull() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("lastName", "Mourinho")
                .param("dateOfBirth", "1963-01-26"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "salary"));
    }

    @Test
    public void trainerFailValidationSalaryWrong() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/trainer/create")
                .param("firstName", "Jose")
                .param("lastName", "Mourinho")
                .param("dateOfBirth", "1963-01-26")
                .param("salary", "24999"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("trainer", "salary"));
    }
}
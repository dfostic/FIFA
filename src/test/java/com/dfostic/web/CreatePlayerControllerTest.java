package com.dfostic.web;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.junit.runner.RunWith;
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
public class CreatePlayerControllerTest {

    @InjectMocks
    private CreatePlayerController controller;

    @Test
    public void createPlayerPage() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/player/create"))
                .andExpect(view().name("createPlayer"));
    }

    @Test
    public void createPlayerSuccess() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "Messi")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(redirectedUrl("/player/Lionel/Messi"));

    }

    @Test
    public void playerFailValidationFirstNameNull() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("lastName", "Messi")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "firstName"));
    }

    @Test
    public void playerFailValidationFirstNameShort() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("lastName", "A")
                .param("lastName", "Messi")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(2))
                .andExpect(model().attributeHasFieldErrors("player", "firstName"));
    }

    @Test
    public void playerFailValidationFirstNameLong() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("lastName", "ABCDEFGHIGKLMNOPQ") /* 17 chars */
                .param("lastName", "Messi")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(3))
                .andExpect(model().attributeHasFieldErrors("player", "firstName"));
    }

    @Test
    public void playerFailValidationFirstNameDigit() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("lastName", "Lionel2") /* digit */
                .param("lastName", "Messi")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(2))
                .andExpect(model().attributeHasFieldErrors("player", "firstName"));
    }

    @Test
    public void playerFailValidationLastNameNull() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "lastName"));
    }

    @Test
    public void playerFailValidationLastNameShort() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "A")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "lastName"));
    }

    @Test
    public void playerFailValidationLastNameLong() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "ABCDEFGHIGKLMNOPQ") /* 17 chars */
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "lastName"));
    }

    @Test
    public void playerFailValidationLastNameDigit() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "Messi2") /* digit */
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "lastName"));
    }

    @Test
    public void playerFailValidationDateOfBirthTooYoung() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "Messi")
                .param("dateOfBirth", "2015-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "dateOfBirth"));
    }

    @Test
    public void playerFailValidationDateOfBirthTooOld() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "Messi")
                .param("dateOfBirth", "1980-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "64700000")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "dateOfBirth"));
    }

    @Test
    public void playerFailValidationSalaryNull() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "Messi")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "salary"));
    }

    @Test
    public void playerFailValidationSalaryWrong() throws Exception {
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(post("/player/create")
                .param("firstName", "Lionel")
                .param("lastName", "Messi")
                .param("dateOfBirth", "1993-01-01")
                .param("country", "Argentina")
                .param("position", "FORWARD")
                .param("salary", "24999")
                .param("goals", "70")
                .param("bookings", "7"))
                .andExpect(model().errorCount(1))
                .andExpect(model().attributeHasFieldErrors("player", "salary"));
    }
}
package com.greenfox.rest.controllers;

import com.greenfox.rest.services.RestService;
import com.greenfox.rest.services.RestServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.nio.charset.Charset;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(RestControllerBackend.class)
public class RestControllerBackendTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private final RestService serv = new RestServiceImpl();

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    public void getDouble() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/doubling")
                .contentType(MediaType.APPLICATION_JSON)
                .content("4"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(content().string("8"));
    }

/*    @Test
    public void getGreeter() {
    }

    @Test
    public void getGreeter1() {
    }

    @Test
    public void doUntilGenarator() {
    }

    @Test
    public void arrays() {
    }*/
}
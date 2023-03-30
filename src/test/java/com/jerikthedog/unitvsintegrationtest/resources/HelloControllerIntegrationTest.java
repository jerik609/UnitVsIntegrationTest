package com.jerikthedog.unitvsintegrationtest.resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class) // unit JUnit5, JUnit4 is different uses @RunWith
@WebMvcTest(HelloController.class) // still loads Spring, but only the most relevant parts for testing
class HelloControllerIntegrationTest {

    // this is what we get with the @WebMvcTest annotation - a mock for the MVC called MockMvc
    // we can e.g. call a particular request on a particular path
    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception {
        RequestBuilder request = get("/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello, World", result.getResponse().getContentAsString());
    }

    @Test
    public void testHelloWithName() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello").param("name", "Cookie");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello, Cookie", result.getResponse().getContentAsString());
    }

    // another way to do this
    @Test
    public void testHelloWithName2() throws Exception {
        mvc.perform(get("/hello?name=Dan")).andExpect(
                MockMvcResultMatchers.content().string("Hello, Dan"));
    }

}
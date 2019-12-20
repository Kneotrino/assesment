package com.kneotrino.assesment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.kneotrino.assesment.request.TokenRequest;
import com.kneotrino.assesment.response.TokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.kneotrino.assesment.testUtil.ValueGenerator.asJsonString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Kneotrino
 * @date 20/12/19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductControllerTest {

  private static String token;
  @Autowired
  ObjectMapper mapper;
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void D_1_login() throws Exception {
    TokenRequest request = TokenRequest
        .builder()
        .email("admin@example.com")
        .password("admin")
        .build();

    MvcResult postResponse = mockMvc.perform(MockMvcRequestBuilders
        .post("/auth/login/")
        .content(asJsonString(request))
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andReturn();

    log.info(postResponse.toString());
    TokenResponse read = JsonPath.parse(postResponse.getResponse().getContentAsString()).read("$.result", TokenResponse.class);
    token = read.getAccess_token();
    log.info("read = " + read);
    log.info("token = " + token);
  }

  @Test
  public void D_2_listAll() throws Exception {
    log.info("token = " + token);
    MvcResult authentication = mockMvc.perform(
        get("v1/products/")
            .header("authentication", "Bearer " + token))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andReturn();
  }

}
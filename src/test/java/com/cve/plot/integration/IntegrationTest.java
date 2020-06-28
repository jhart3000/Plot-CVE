package com.cve.plot.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class IntegrationTest {

  @Autowired private MockMvc mvc;

  @Test
  void shouldReturnAnalysedCVE() throws Exception {
    mvc.perform(get("/analysedCVEData")).andExpect(status().isOk());
  }
}

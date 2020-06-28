package com.cve.plot.service;

import com.cve.plot.model.analysedobject.CVEYearlyDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CVEAnalysisServiceTest {

  private CVEAnalysisService service;

  @BeforeEach
  void setup() {
    service = new CVEAnalysisService();
  }

  @Test
  void shouldAnalyseCVEJson() throws Exception {
    List<CVEYearlyDetail> response = service.analyseCVEJson();
    assertThat(response).isNotNull();
    assertThat(response.size()).isEqualTo(6);
  }
}

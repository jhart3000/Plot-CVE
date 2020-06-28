package com.cve.plot.service;

import com.cve.plot.model.analysedobject.CVEYearlyDetail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CVEAnalysisServiceTest {

  private CVEAnalysisService service;

  @BeforeEach
  void setup() {
    service = new CVEAnalysisService();
  }

  @Test
  void shouldAnalyseCVEJson() throws IOException {
    List<CVEYearlyDetail> response = service.analyseCVEJson();
    assertThat(response).isNotNull();
    assertThat(response.size()).isEqualTo(6);
    assertThat(response.get(0)).isNotNull();
    assertThat(response.get(0).getMonthlyDetail().size()).isEqualTo(12);
  }
}

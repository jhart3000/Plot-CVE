package com.cve.plot.configuration;

import com.cve.plot.service.CVEAnalysisService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CVEAnalysisServiceConfiguration {

  @Bean
  CVEAnalysisService cveAnalysisService() {
    return new CVEAnalysisService();
  }
}

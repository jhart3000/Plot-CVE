package com.cve.plot.controller;

import com.cve.plot.model.analysedobject.CVEYearlyDetail;
import com.cve.plot.service.CVEAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAnalysedCVE {

  @Autowired private CVEAnalysisService service;

  @GetMapping("analysedCVEData")
  public List<CVEYearlyDetail> getAnalysedCVEData() throws Exception {
    return service.analyseCVEJson();
  }
}

package com.cve.plot.loadjson;

import com.cve.plot.model.jsonmappedobject.ResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class LoadJson {

  public static ResponseDTO loadCVEJsonFromClasspath() throws IOException {
    Resource resource = new ClassPathResource("cve.json");
    InputStream input = resource.getInputStream();
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(input, ResponseDTO.class);
  }
}

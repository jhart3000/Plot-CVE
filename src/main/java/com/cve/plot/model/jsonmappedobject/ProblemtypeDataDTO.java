package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
class ProblemtypeDataDTO {

  @JsonProperty("description")
  private List<DescriptionDTO> description;
}

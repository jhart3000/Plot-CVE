package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
class DescriptionListDTO {

  @JsonProperty("description_data")
  private List<DescriptionDTO> descriptionList;
}

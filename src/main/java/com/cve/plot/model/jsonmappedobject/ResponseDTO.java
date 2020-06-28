package com.cve.plot.model.jsonmappedobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponseDTO {

  @JsonProperty("CVE_data_type")
  private String cVEDataType;

  @JsonProperty("CVE_data_format")
  private String cVEDataFormat;

  @JsonProperty("CVE_data_version")
  private String cVEDataVersion;

  @JsonProperty("CVE_data_numberOfCVEs")
  private String cVEDataNumberOfCVEs;

  @JsonProperty("CVE_data_timestamp")
  private String cVEDataTimestamp;

  @JsonProperty("CVE_Items")
  private List<CVEItemsDTO> cVEItems;
}

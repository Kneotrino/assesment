package com.kneotrino.assesment.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class MessageResponse {

  private String message;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String WebRequest;

  public MessageResponse(String message) {
    this.message = message;
  }

  public MessageResponse(String message, String webRequest) {
    this.message = message;
    WebRequest = webRequest;
  }
}

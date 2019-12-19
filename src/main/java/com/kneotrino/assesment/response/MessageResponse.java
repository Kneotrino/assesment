package com.kneotrino.assesment.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MessageResponse<T> {

  public String message;

  public String WebRequest;

  public MessageResponse(String message) {
    this.message = message;
  }

  public MessageResponse(String message, String webRequest) {
    this.message = message;
    this.WebRequest = webRequest;
  }
}

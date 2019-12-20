package com.kneotrino.assesment.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MessageResponse<T> {

  public String message;

  public String phrase;

  public MessageResponse(String message) {
    this.message = message;
  }

  public MessageResponse(String message, String phrase) {
    this.message = message;
    this.phrase = phrase;
  }
}

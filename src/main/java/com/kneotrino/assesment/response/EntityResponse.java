package com.kneotrino.assesment.response;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EntityResponse<T> {
  public String status;
  public T result;
  public String error;

  public EntityResponse(String status, T result) {
    this.status = status;
    this.result = result;
  }
}

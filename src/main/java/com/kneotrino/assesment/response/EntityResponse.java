package com.kneotrino.assesment.response;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class EntityResponse<T> {
  public String status;
  public T result;
  public List<T> error;

  public EntityResponse(String status, T result) {
    this.status = status;
    this.result = result;
  }
}

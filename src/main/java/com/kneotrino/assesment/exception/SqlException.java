package com.kneotrino.assesment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class SqlException extends Exception {

  public SqlException(String message) {
    super(message);
  }

}

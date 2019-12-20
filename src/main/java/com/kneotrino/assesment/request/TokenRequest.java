package com.kneotrino.assesment.request;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder(toBuilder = true)
public class TokenRequest implements Serializable {

  private static final long serialVersionUID = 5926468583005150707L;

  private String email;

  private String password;

}
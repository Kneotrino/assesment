package com.kneotrino.assesment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Kneotrino
 * @date 20/12/19
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class TokenResponse {
  private String access_token;

}

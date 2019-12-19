package com.kneotrino.assesment.constant;

/**
 * @author Kneotrino
 * @date 17/10/19
 */
public enum EnabledStatusEnum {
  ENABLED("E"),
  DISABLED("D");

  public final String CODE;

  EnabledStatusEnum(String code) {
    this.CODE = code;
  }

  public String getCODE() {
    return CODE;
  }
}

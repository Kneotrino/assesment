package com.kneotrino.assesment.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ResponseStatusEnum {
  OK("OK"),
  CREATED("CREATED"),
  UPDATED("UPDATED"),
  DELETED("DELETED"),
  RESOURCE_NOT_FOUND("RESOURCE NOT FOUND"),
  ILLEGALS_ARGUMENTS("ARGUMENT NOT VALID"),
  DUPLICATE_ENTRY("DUPLICATE ENTRY"),
  PASSWORD_NOT_VALID("PASSWORD NOT VALID"),
  DATABASE_SQL_EXCEPTION("DATABASE EXCEPTION");

  private final String Info;
}

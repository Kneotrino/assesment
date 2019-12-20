package com.kneotrino.assesment.testUtil;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;

/**
 * @author Kneotrino
 * @date 14/11/19
 */
public class ValueGenerator {

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static String generateRandomString(int length) {
    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    StringBuilder salt = new StringBuilder();
    Random rnd = new Random();
    while (salt.length() < length) { // length of the random string.
      int index = (int) (rnd.nextFloat() * SALTCHARS.length());
      salt.append(SALTCHARS.charAt(index));
    }
    String saltStr = salt.toString();
    return saltStr;
  }

  public static String generateRandomPhone() {
    String mobileNum = "";
    Random objGenerator = new Random();
    for (int iCount = 0; iCount < 10; iCount++) {
      int randomNumber = objGenerator.nextInt(100);
      mobileNum += randomNumber;
    }
    return "+62" + mobileNum;
  }

  public static Random RandomFactory() {
    return new Random();
  }

}

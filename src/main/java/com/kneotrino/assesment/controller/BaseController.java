package com.kneotrino.assesment.controller;

import com.kneotrino.assesment.response.MessageResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

  @GetMapping("/v2/products")
  public MessageResponse greeting() {
    return new MessageResponse("Hello, World!");
  }
}

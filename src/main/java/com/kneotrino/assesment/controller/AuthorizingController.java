package com.kneotrino.assesment.controller;

import com.kneotrino.assesment.authentication.JwtTokenUtil;
import com.kneotrino.assesment.constant.ResponseStatusEnum;
import com.kneotrino.assesment.model.UserModel;
import com.kneotrino.assesment.request.TokenRequest;
import com.kneotrino.assesment.response.EntityResponse;
import com.kneotrino.assesment.response.TokenResponse;
import com.kneotrino.assesment.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author Kneotrino
 * @date 19/12/19
 */
@RestController
@RequestMapping("/auth")
public class AuthorizingController {

  // TODO: 19/12/19
  //  implemented login and created account
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private JwtUserDetailsService userDetailsService;

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public EntityResponse<TokenResponse> createAuthenticationToken(@RequestBody TokenRequest authenticationRequest) throws Exception {

    authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

    final UserDetails userDetails = userDetailsService
        .loadUserByUsername(authenticationRequest.getEmail());

    final String token = jwtTokenUtil.generateToken(userDetails);

    return new EntityResponse<>(ResponseStatusEnum.OK.name(), new TokenResponse(token));
  }

  private void authenticate(String username, String password) throws Exception {
    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
    } catch (DisabledException e) {
      throw new Exception("USER_DISABLED", e);
    } catch (BadCredentialsException e) {
      throw new Exception("INVALID_CREDENTIALS", e);
    }
  }

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/signup")
  public EntityResponse<UserModel> insertProduct(@Valid @RequestBody UserModel CreateUser) {
    return new EntityResponse<>(ResponseStatusEnum.OK.name(), userDetailsService.insertUser(CreateUser));
  }

}

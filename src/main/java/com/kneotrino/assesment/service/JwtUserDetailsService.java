package com.kneotrino.assesment.service;

import com.kneotrino.assesment.model.UserModel;
import com.kneotrino.assesment.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Kneotrino
 * @date 20/12/19
 */
@Slf4j
@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<UserModel> byEmail = Optional.ofNullable(userRepository.findByEmail(email));
    if (byEmail.isPresent())
      return new User(byEmail.get().getName(), byEmail.get().getPassword(), new ArrayList<>());
    else
      throw new UsernameNotFoundException("Email : " + email + " Not Exist");
  }

  public UserModel insertUser(UserModel userModel) {
    userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
    return userRepository.save(userModel);
  }
}
package com.kneotrino.assesment.repository;

import com.kneotrino.assesment.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
  UserModel findByEmail(String email);
}

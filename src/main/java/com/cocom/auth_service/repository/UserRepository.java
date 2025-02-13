package com.cocom.auth_service.repository;

import com.cocom.auth_service.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);

  User save(User user);

}

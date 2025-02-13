package com.cocom.auth_service.service;

import com.cocom.auth_service.controller.dto.UserRequestDto;
import com.cocom.auth_service.domain.User;
import com.cocom.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public Long signUp(UserRequestDto userRequestDto) {

    System.out.println("test1111");

    User newUser = new User(userRequestDto.getEmail(), bCryptPasswordEncoder.encode(userRequestDto.getPassword()));
    User savedUser = userRepository.save(newUser);

    System.out.println("test");

    return savedUser.getId();
  }

}

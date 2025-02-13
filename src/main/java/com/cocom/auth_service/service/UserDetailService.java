package com.cocom.auth_service.service;

import com.cocom.auth_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

  private final UserRepository userRepository;



  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    // 예외처리
    return userRepository.findByEmail(email).orElseThrow();
  }
}

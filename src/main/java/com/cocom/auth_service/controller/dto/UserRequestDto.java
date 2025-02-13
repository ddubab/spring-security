package com.cocom.auth_service.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequestDto {

  private String email;
  private String password;

}

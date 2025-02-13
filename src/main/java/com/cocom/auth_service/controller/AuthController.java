package com.cocom.auth_service.controller;

import com.cocom.auth_service.controller.dto.UserRequestDto;
import com.cocom.auth_service.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;

  @PostMapping("/user")
  public String signup(@ModelAttribute UserRequestDto request){
    System.out.println(request.getPassword());
    userService.signUp(request);
    return "redirect:/signup";
  }

  @GetMapping("/login")
  String login() {
    return "login";
  }

  @GetMapping("/signup")
  public String signup(){
    return "signup.html";
  }
  @GetMapping("/logout")
  public String logout(HttpServletRequest request, HttpServletResponse response) {
    new SecurityContextLogoutHandler().logout(request, response,
        SecurityContextHolder.getContext().getAuthentication());
    return "redirect:/login";
  }
}

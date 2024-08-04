package com.mj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class HomeController {

  @GetMapping("/")
  public String getTokenInfo(OAuth2AuthenticationToken authenticationToken) {
    // Access user details and token information
    String username = authenticationToken.getName();
    Map<String, Object> userAttributes = authenticationToken.getPrincipal().getAttributes();

    // For debugging or logging
    System.out.println("Username: " + username);
    // Extract specific attributes
    String login = (String) userAttributes.get("login");
    String avatarUrl = (String) userAttributes.get("avatar_url");
    String name = (String) userAttributes.get("name");
    String company = (String) userAttributes.get("company");
    String location = (String) userAttributes.get("location");

    // Log the user attributes
    log.info("User Details: Login={}, Avatar URL={}, Name={}, Company={}, Location={}",
            login, avatarUrl, name, company, location);

    // Return a response
    return String.format("Login: %s, Avatar URL: %s, Name: %s, Company: %s, Location: %s",
            login, avatarUrl, name, company, location);
  }


}

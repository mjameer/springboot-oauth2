package com.mj.controller;

import com.mj.jwt.JWTGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;

import java.util.Map;

@Slf4j
@RestController
public class HomeController {

  @Autowired
  private JWTGenerator jwtGenerator;


  // Pass the authentication Object to generate JWT Token and return back to Client
  @GetMapping("/")
  public ResponseEntity<String> authenticate(Authentication authentication) {
    // Access user details and token information
    String username = authentication.getName();
    log.info("Username: " + username);
    log.info("Principal  {} ", authentication.getPrincipal());

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtGenerator.generateToken(authentication);


    // Create a JSON object with the token
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("token", "Bearer " + token);
    String jsonResponse = jsonObject.toString();

    return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
  }



  @GetMapping("/legacyWay")
  public String getTokenInfo(OAuth2AuthenticationToken authenticationToken) {
    // Access user details and token information
    String username = authenticationToken.getName();
    log.info("Username: " + username);

    Map<String, Object> userAttributes = authenticationToken.getPrincipal().getAttributes();

    // Extract specific attributes
    String login = (String) userAttributes.get("login");
    String name = (String) userAttributes.get("name");
    String company = (String) userAttributes.get("company");
    String location = (String) userAttributes.get("location");

    // Log the user attributes
    log.info("User Details: Login={}, Name={}, Company={}, Location={}",
            login, name, company, location);

    log.info("Principal  {} ", authenticationToken.getPrincipal());
    log.info("authenticationToken.getPrincipal().getAttributes  {} ", authenticationToken.getPrincipal().getAttributes());
    // Return a response
    return String.format("Login: %s, Name: %s, Company: %s, Location: %s", login, name, company, location);
  }

}

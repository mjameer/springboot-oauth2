# About Project - Springboot-oauth2


This repository contains a Spring Boot 3 project that demonstrates how to secure an API with OAuth 2.0 done using GitHub, but one thing unique about this project is, that we dint use direct GitHub configurations provided by SpringBoot, instead, we tweaked and configured the code to consider GitHub as a custom Authentication/Authorization server. 


# More on OAuth2 

![image](https://github.com/user-attachments/assets/7cd57ff2-d981-40e9-a2b7-41afe1ab53f2)

OAuth 2.0 is an authorization framework that enables applications to access a user’s data on another service (like Facebook or GitHub) without sharing the user’s password.

Simply put, it aids in authorization between services.

It’s essentially a digital handshake between the app, service, and user, with everyone agreeing on what is shared. 

The process generally follows 6 steps with 4 components typically involved:

🔸 Client (app wanting access)

🔸 Resource owner (user)

🔸 Authorization server

🔸 Resource server

To understand the process, let’s take a look at how a game would connect to a player’s Facebook account.

Step 1) Request access:
Within the game (client), the player (user) clicks on a “connect with Facebook” button to link their profile and find friends.

Step 2) Redirect to service:
The game redirects the player to Facebook’s (service’s) login page.

Step 3) Permission request:
After logging in, the data that the game is requesting access to will be shown to the player which they can either allow or deny.

Step 4) Authorization code:
If the player gives their approval, Facebook redirects the player back to the game with an authorization code (from authorization server). The code is a temporary credential that proves the player’s consent.

Step 5) Exchange code for token:
The game now sends the authorization code along with its own identification to Facebook’s server in the background. Facebook identifies the authorization code and the game’s identity and returns an access token.

Step 6) Use the token:
The game can now use the access token to request the agreed-upon data from Facebook (from the resource server), like the player's friends list.

In this process, the player’s Facebook credentials were never shared, but the game was able to access the agreed-upon player data from Facebook. This is what OAuth 2.0 facilitates; allowing third-party applications to access data from services in a secure manner without sharing credentials.


## SpringBoot OAuth2 Implementation

Project to show how to implement OAuth2 login using GitHub/Google/Custom Resource server

### OAuth2.0 flow High level 

![oauth2 google](https://github.com/user-attachments/assets/e28622c1-51dc-49d6-838e-5d789bfc545c)

### OAuth2.0 flow (Under the hood)

![oauth2-flow](https://github.com/user-attachments/assets/f4e2fc66-ac60-4baa-9e9a-e5a511ab150a)

![oauth2-new-flow](https://github.com/user-attachments/assets/d9c76395-86ba-4a47-9b55-180354bb1bc2)

### Steps to create a GitHub application
* Go to [GitHub developer portal](https://github.com/settings/developers)
* Create a new application and provide the required information
  * Set the homepage URL to http://localhost:8080
  * Authorization callback URL to http://localhost:8080/login/oauth2/code/gitHubs. (should match the custom registrationId, which is gitHubs)

### Update the `application.yml` file

For App to work with InBuild GitHub configurations, use the following

```
spring:
  security:
    oauth2:
      client:
        registration:
          github:
            clientId: {{client-id-here}}
            clientSecret: {{client-secret-here}}
```

For App to work with Custom Build OAUTH2 configurations, use the following

```         
spring:
  security:
    oauth2:
      client:
        registration:
          gitHubs:
            clientId: {{client-id-here}}
            clientSecret: {{client-secret-here}}
            authorizationGrantType: authorization_code
            redirectUri: "http://localhost:8080/login/oauth2/code/gitHubs"
            scope: read:user, user:email
            clientAuthenticationScheme: form
        provider:
          gitHubs:
            authorizationUri: https://github.com/login/oauth/authorize
            tokenUri: https://github.com/login/oauth/access_token
            userInfoUri: https://api.github.com/user
            userNameAttribute: id
```

## How does it work

![image](https://github.com/user-attachments/assets/2d8db0e8-171a-4ab9-b96c-37854b00c3e4)

![image](https://github.com/user-attachments/assets/20264d94-6f88-4cac-b4db-11e427d03038)

![image](https://github.com/user-attachments/assets/0882f335-3707-44b5-99db-7e9d3c881f63)

Git Reference: 
- https://github.com/JianChoi-Kor/OAuth2.git
- https://github.com/caligula95/crud-app-example

Blog reference: 
- https://wildeveloperetrain.tistory.com/252

YouTube: 
- https://www.youtube.com/watch?v=2WNjmT2z7c4
- https://www.youtube.com/watch?v=npS9OLUE5rc
- https://www.youtube.com/watch?v=LyqeHAkxVyk
- https://www.youtube.com/watch?v=LyqeHAkxVyk
- https://www.youtube.com/watch?v=ouE3NuTzf20&t=137s

  

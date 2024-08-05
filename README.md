# SpringBoot OAuth2 Implementation

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

Git Reference: https://github.com/JianChoi-Kor/OAuth2.git

Blog reference: https://wildeveloperetrain.tistory.com/252

YouTube: https://www.youtube.com/watch?v=2WNjmT2z7c4 & https://www.youtube.com/watch?v=npS9OLUE5rc

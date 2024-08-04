# SpringBoot OAuth2 Implementation

Project to shows how to implement OAuth2 login using GitHub/Google/Custom Resource server

### OAuth2.0 flow High level 

![oauth2 google](https://github.com/user-attachments/assets/e28622c1-51dc-49d6-838e-5d789bfc545c)

### OAuth2.0 flow (Under the hood)

![oauth2-flow](https://github.com/user-attachments/assets/f4e2fc66-ac60-4baa-9e9a-e5a511ab150a)

### Steps to create a gitHub application
* Go to [GitHub developer portal](https://github.com/settings/developers)
* Create a new application and provide the required information
  * Set the homepage URL to http://localhost:8080
  * Authorization callback URL to http://localhost:8080/login/oauth2/code/gitHubs. (should match the registrationID)

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


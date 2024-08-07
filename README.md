# OAuth2

![image](https://github.com/user-attachments/assets/fc56803d-4380-4d4c-8fa2-ed49ef883ce7)

## Notes

![image](https://github.com/user-attachments/assets/6a46ba74-ec2e-4d5a-bcc5-e3eb200fe308)


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

  

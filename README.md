# TH-Passport-Backend

# 接入TH-Passport
- 注册客户端
- 配置SpringSecurityClient
```yaml
spring:
  security:
    oauth2:
      client:
        registration:
          messaging-client-oidc:
            provider: thpassport
            client-id: { client-id } # 客户端Id
            client-secret: {client-secret} # 客户端密钥
            redirect-uri: { Client Host }/login/oauth2/code/messaging-client-oidc # 重定向uri(使用缺省配置)
            authorization-grant-type: authorization_code # 验证模式
            scope: # 作用域
              - message.read
              - message.write
            client-authentication-method: client_secret_basic
        provider:
          thpassport:
            user-info-uri: { AuthorizationServer Host }/user # 用户数据uri
            issuer-uri: { AuthorizationServer Host } # 认证签发uri

```
在验证流程结束后，验证完的用户数据将被存放在SecurityContext中，使用
`OAuth2User principal = (OAuth2User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();` 获取

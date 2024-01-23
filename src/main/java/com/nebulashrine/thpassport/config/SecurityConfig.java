package com.nebulashrine.thpassport.config;

import com.nebulashrine.thpassport.common.authority.Authority;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authorize) -> {
            authorize.requestMatchers("/webjars/**", "/login", "register", "assets/**").permitAll()
                    .requestMatchers("/changePassword", "/changeIntroduction").hasAuthority(Authority.USER.getAuthority())
                    .anyRequest().authenticated();
        })
//                配置登陆页面
                .formLogin(formLogin -> {
                    formLogin.loginPage("/login");
                });
        http.oauth2ResourceServer(resourceServer -> resourceServer.jwt(Customizer.withDefaults()));

        return http.build();
    }

//    密码解析器
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

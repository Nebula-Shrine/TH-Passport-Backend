package com.nebulashrine.thpassport.entity.custom;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.nebulashrine.thpassport.entity.mysqlEntity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public class OAuth2UserDetails implements UserDetails {


    public OAuth2UserDetails(User user){
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.isBanned = user.isBanned();
        this.isDeleted = user.isDeleted();
        this.isAuthorized = user.isAuthorized();
        this.uuid = user.getUuid();
//        setAuthorities(user.getAuthority());
//        this.authorities = user.getAuthority();
    }

    private int id;

    private String uuid;

    private String username;

    private String password;

    private boolean isDeleted;

    private boolean isBanned;

    private boolean isAuthorized;

    @JsonIgnore
    private Collection<? extends GrantedAuthority> authorities = new ArrayList<>(){{add(new SimpleGrantedAuthority("ADMIN"));}};

    private void setAuthorities(String authorities){
        ObjectMapper mapper = new ObjectMapper();

        try {
            String[] strings = authorities.split(",");
            ArrayList<GrantedAuthority> list = new ArrayList<>();
            for (String string : strings) {
                list.add(new SimpleGrantedAuthority(string));
            }
            this.authorities = list;
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<GrantedAuthority> list = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            list.add(authority);
        }
        return list;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.isBanned;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.isBanned;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !this.isAuthorized;
    }

    @Override
    public boolean isEnabled() {
        return !this.isDeleted;
    }
}

package com.nebulashrine.thpassport.entity.custom;

import com.nebulashrine.thpassport.entity.mysqlEntity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

public class OAuth2UserDetails implements UserDetails {


    public OAuth2UserDetails(User user){
        this.id = user.getId();
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.isBanned = user.isBanned();
        this.isDeleted = user.isDeleted();
        this.isAuthorized = user.isAuthorized();
        this.uuid = user.getUuid();
    }

    private int id;

    private String uuid;

    private String username;

    private String password;

    private boolean isDeleted;

    private boolean isBanned;

    private boolean isAuthorized;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
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

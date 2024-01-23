package com.nebulashrine.thpassport.service;

import com.nebulashrine.thpassport.entity.custom.OAuth2UserDetails;
import com.nebulashrine.thpassport.entity.mysqlEntity.User;
import com.nebulashrine.thpassport.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepo userRepo;

    @Autowired
    public UserDetailServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String uuid) throws UsernameNotFoundException {
        User user = userRepo.findAllByUuid(uuid);
        if (user == null){
            return null;
        }

        return new OAuth2UserDetails(user);

    }


}

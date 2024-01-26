package com.nebulashrine.thpassport.service;

import com.nebulashrine.thpassport.entity.mysqlEntity.User;
import com.nebulashrine.thpassport.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public boolean isUserExistsByPhone(String phone){
        User user = userRepo.findAllByPhoneNumber(phone);
        System.out.println(ObjectUtils.isEmpty(user));
        return !ObjectUtils.isEmpty(user);
    }
	
    public boolean isUserExistsByUsername(String username){
        User user = userRepo.findAllByUsername(username);
        return !ObjectUtils.isEmpty(user);
    }
    
    public
}

package com.nebulashrine.thpassport.repository;

import com.nebulashrine.thpassport.entity.mysqlEntity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findAllByUuid(String uuid);

    User findAllByPhoneNumber(String phoneNumber);
}

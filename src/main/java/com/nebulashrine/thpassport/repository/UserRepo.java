package com.nebulashrine.thpassport.repository;

import com.nebulashrine.thpassport.entity.mysqlEntity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends CrudRepository<User, Integer> {

    User findAllByUuid(String uuid);

    User findAllByPhoneNumber(String phoneNumber);

    User findAllByUsername(String username);

    @Query("update User user set user.clientUUID = :clientUUID where user.uuid = :uuid")
    @Modifying
    int addRegisteredClient(@Param("uuid") String uuid, @Param("clientUUID") String clientUUID);
}

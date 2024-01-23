package com.nebulashrine.thpassport.entity.mysqlEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uuid;

    private String username;

    private String password;

    private String gender;

    private String email;

    private String phoneNumber;

    private String authority;

    private Date registerDate;

    private Date lastLoginDate;

    private String lastLoginIp;

    private Date birthday;

    private String avatarURL;

    private String signature;

    private String description;

    private String personalWebsite;

    private String location;

    private String qqNumber;

    private boolean isDeleted;

    private boolean isBanned;

    private boolean isAuthorized;

    private String userRank;

    private String clientUUID;
}

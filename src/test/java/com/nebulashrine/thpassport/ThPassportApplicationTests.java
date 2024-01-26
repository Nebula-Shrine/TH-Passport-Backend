package com.nebulashrine.thpassport;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nebulashrine.thpassport.entity.DTO.ClientDTO;
import com.nebulashrine.thpassport.entity.mysqlEntity.User;
import com.nebulashrine.thpassport.repository.UserRepo;
import com.nebulashrine.thpassport.service.ClientServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.UUID;

@SpringBootTest
class ThPassportApplicationTests {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ClientServiceImpl clientService;

    @Test
    void contextLoads() throws Exception{
        User user = new User();
        user.setUsername("Midsummra");
        user.setPassword(passwordEncoder.encode("123456"));
        user.setUuid(UUID.randomUUID().toString());

        ObjectMapper mapper = new ObjectMapper();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("ADMIN");
        strings.add("USER");
        user.setAuthority("ADMIN,USER");

        userRepo.save(user);
    }

    @Test
    void addRegisteredClient(){
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setClientID("123456");
        clientDTO.setClientSecret("123456");
        clientDTO.setRedirectURI("http://127.0.0.1:8080/index");
        clientDTO.setClientName("testClient");
        clientService.registerClient(clientDTO, "0f36f9b9-eef9-455e-b1d8-5aac5d726bb5");
    }

}

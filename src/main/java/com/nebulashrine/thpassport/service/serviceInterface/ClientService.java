package com.nebulashrine.thpassport.service.serviceInterface;

import com.nebulashrine.thpassport.entity.DTO.ClientDTO;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

public interface ClientService {
    RegisteredClient registerClient(ClientDTO clientDTO);
}

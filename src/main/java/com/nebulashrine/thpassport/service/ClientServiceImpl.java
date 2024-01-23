package com.nebulashrine.thpassport.service;

import com.nebulashrine.thpassport.entity.DTO.ClientDTO;
import com.nebulashrine.thpassport.service.serviceInterface.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.settings.ClientSettings;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    @Qualifier("CustomRegisteredClientRepository")
    private RegisteredClientRepository registeredClientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     *
     * @param clientDTO
     * @return RegisteredClient如果为null，则表示此ClientID被注册过
     * @see ClientDTO
     * @see RegisteredClient
     */
    @Override
    public RegisteredClient registerClient(ClientDTO clientDTO) {
        RegisteredClient findByID = registeredClientRepository.findByClientId(clientDTO.getClientID());
        if (!ObjectUtils.isEmpty(findByID)){
            return null;
        }
        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
                .clientId(clientDTO.getClientID())
                .clientName(clientDTO.getClientName())
                .clientSecret(passwordEncoder.encode(clientDTO.getClientSecret()))
                .redirectUri(clientDTO.getRedirectURI())
                .scope("message.read")
                .scope("message.write")
                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
                .build();

        registeredClientRepository.save(registeredClient);

        return registeredClient;
    }
}

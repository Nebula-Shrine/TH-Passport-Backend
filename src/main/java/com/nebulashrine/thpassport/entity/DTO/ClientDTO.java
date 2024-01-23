package com.nebulashrine.thpassport.entity.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String clientID;

    private String clientSecret;

    private String clientName;

    private String redirectURI;

    private ArrayList<String> scopes;
}

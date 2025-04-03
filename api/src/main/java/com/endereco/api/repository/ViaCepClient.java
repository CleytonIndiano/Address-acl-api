package com.endereco.api.repository;

import com.endereco.api.model.Address;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ViaCepClient {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String URL = "https://viacep.com.br/ws/{cep}/json/";
    public Address searchCep(String cep) {
        ResponseEntity<Address> response = restTemplate.getForEntity(URL, Address.class, cep);
        return response.getBody();
    }
}

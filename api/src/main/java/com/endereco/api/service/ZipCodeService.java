package com.endereco.api.service;


import com.endereco.api.model.Address;
import com.endereco.api.repository.ViaCepClient;
import org.springframework.stereotype.Service;

@Service
public class ZipCodeService {
    private final ViaCepClient viaCepClient;
    public ZipCodeService(ViaCepClient viaCepClient) {
        this.viaCepClient = viaCepClient;
    }
    public Address searchAddressByCep(String cep) {
        return viaCepClient.searchCep(cep);
    }
}

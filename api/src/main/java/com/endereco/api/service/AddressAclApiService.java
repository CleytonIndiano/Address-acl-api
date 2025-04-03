package com.endereco.api.service;

import com.endereco.api.dto.AddressDto;
import com.endereco.api.repository.ViaCepClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddressAclApiService {
    private final ViaCepClient viaCepClient;

    public AddressDto getAddressByZipCode(String cep) {
        var address = viaCepClient.searchCep(cep);

        AddressDto addressDto = new AddressDto();
        addressDto.setZipCode(address.getCep());
        addressDto.setCity(address.getLocalidade());
        addressDto.setState(address.getUf());
        addressDto.setNeighborhood(address.getBairro());
        addressDto.setStreet(address.getLogradouro());
        addressDto.setRegion(address.getRegiao());

        return addressDto;
    }
}

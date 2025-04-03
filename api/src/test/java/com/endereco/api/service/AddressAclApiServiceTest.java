package com.endereco.api.service;

import com.endereco.api.dto.AddressDto;
import com.endereco.api.model.Address;
import com.endereco.api.repository.ViaCepClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressAclApiServiceTest {
    @Mock
    private ViaCepClient viaCepClient;

    @InjectMocks
    private AddressAclApiService addressAclApiService;


    @Test
    void gettingAddressByZipCode() {
        String cep = "88308-665";
        Address mockAddress = new Address();
        mockAddress.setCep(cep);
        mockAddress.setLogradouro("Rua Francisco Delvan");
        mockAddress.setBairro("Cidade Nova");
        mockAddress.setLocalidade("Itajaí");
        mockAddress.setUf("SC");
        mockAddress.setRegiao("Sul");

        when(viaCepClient.searchCep(cep)).thenReturn(mockAddress);

        AddressDto result = addressAclApiService.getAddressByZipCode(cep);

        assertNotNull(result);
        assertEquals(cep, result.getZipCode());
        assertEquals("Rua Francisco Delvan", result.getStreet());
        assertEquals("Cidade Nova", result.getNeighborhood());
        assertEquals("Itajaí", result.getCity());
        assertEquals("SC", result.getState());
        assertEquals("Sul", result.getRegion());
    }
}

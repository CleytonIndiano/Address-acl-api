package com.endereco.api.service;

import com.endereco.api.model.Address;
import com.endereco.api.repository.ViaCepClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ZipCodeServiceTest {

    @Mock
    private ViaCepClient viaCepClient;

    @InjectMocks
    private ZipCodeService zipCodeService;


    @Test
    void searchingaddressbycep() {
        String cep = "88308-665";
        Address mockAddress = new Address();
        mockAddress.setCep(cep);
        mockAddress.setLogradouro("Rua Francisco Delvan");
        mockAddress.setBairro("Cidade Nova");
        mockAddress.setLocalidade("Itajaí");
        mockAddress.setUf("SC");

        when(viaCepClient.searchCep(cep)).thenReturn(mockAddress);

        Address result = zipCodeService.searchAddressByCep(cep);

        assertNotNull(result);
        assertEquals(cep, result.getCep());
        assertEquals("Rua Francisco Delvan", result.getLogradouro());
        assertEquals("Cidade Nova", result.getBairro());
        assertEquals("Itajaí", result.getLocalidade());
        assertEquals("SC", result.getUf());
    }
}
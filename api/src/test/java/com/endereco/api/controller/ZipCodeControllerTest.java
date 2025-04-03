package com.endereco.api.controller;

import com.endereco.api.model.Address;
import com.endereco.api.service.ZipCodeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ZipCodeControllerTest {

    @Mock
    private ZipCodeService zipCodeService;

    @InjectMocks
    private ZipCodeController zipCodeController;


    @Test
    void shouldReturnAddressWhenValidCepIsProvided() {
        String cep = "88308-665";
        Address mockAddress = new Address();
        mockAddress.setCep(cep);
        mockAddress.setLogradouro("Rua Francisco Delvan");
        mockAddress.setBairro("Cidade Nova");
        mockAddress.setLocalidade("Itajaí");
        mockAddress.setUf("SC");

        when(zipCodeService.searchAddressByCep(cep)).thenReturn(mockAddress);

        ResponseEntity<Address> response = zipCodeController.searchCep(cep);


        assertEquals(200, response.getStatusCodeValue());
        assertEquals(mockAddress, response.getBody());

        verify(zipCodeService, times(1)).searchAddressByCep(cep);

    }
}
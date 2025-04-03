package com.endereco.api.controller;

import com.endereco.api.dto.AddressDto;
import com.endereco.api.service.AddressAclApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddressAclApiControllerTest {
    @Mock
    private AddressAclApiService addressAclApiService;

    @InjectMocks
    private AddressAclApiController addressAclApiController;


@Test
void testingsearchCep() {
    String zipCode = "88308665";
    AddressDto mockAddress = new AddressDto();
    mockAddress.setZipCode(zipCode);
    mockAddress.setStreet("Rua Francisco Delvan");
    mockAddress.setNeighborhood("Cidade Nova");
    mockAddress.setCity("Itajaí");
    mockAddress.setState("SC");

    when(addressAclApiService.getAddressByZipCode(zipCode)).thenReturn(mockAddress);

    ResponseEntity<AddressDto> response = addressAclApiController.searchCep(zipCode);

    assertEquals(200, response.getStatusCodeValue());
    assertEquals(mockAddress, response.getBody());

    verify(addressAclApiService, times(1)).getAddressByZipCode(zipCode);

    }
}

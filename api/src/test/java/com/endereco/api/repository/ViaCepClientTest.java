package com.endereco.api.repository;

import com.endereco.api.model.Address;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class ViaCepClientTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ViaCepClient viaCepClient;
    private static final String URL = "https://viacep.com.br/ws/{cep}/json/";

    @Test
    void testingsearchCep() {
        String cep = "88308-665";
        Address mockAddress = new Address();
        mockAddress.setCep(cep);
        mockAddress.setLogradouro("Rua Francisco Delvan");
        mockAddress.setBairro("Cidade Nova");
        mockAddress.setLocalidade("Itajaí");
        mockAddress.setUf("SC");

        Address result = viaCepClient.searchCep(cep);

        assertNotNull(result);
        assertEquals(cep, result.getCep());
        assertEquals("Rua Francisco Delvan", result.getLogradouro());
        assertEquals("Cidade Nova", result.getBairro());
        assertEquals("Itajaí", result.getLocalidade());
        assertEquals("SC", result.getUf());

    }
}
package com.endereco.api.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {
    private Address address;


    @BeforeEach
    void setUp() {
        address = new Address();
    }

    @Test
    void testingGetandSetCep() {
        address.setCep("88308-665");
        assertEquals("88308-665", address.getCep());
    }

    @Test
    void testingGetAndSetLogradouro() {
        address.setLogradouro("Rua Francisco Delvan");
        assertEquals("Rua Francisco Delvan", address.getLogradouro());
    }

    @Test
    void testingGetAndSetComplemento() {
        address.setComplemento(" ");
        assertEquals(" ", address.getComplemento());
    }

    @Test
    void testingGetAndSetBairro() {
        address.setBairro("Cidade Nova");
        assertEquals("Cidade Nova", address.getBairro());
    }

    @Test
    void testingGetAndSetLocalidade() {
        address.setLocalidade("Itajaí");
        assertEquals("Itajaí", address.getLocalidade());
    }

    @Test
    void testingGetAndSetUf() {
        address.setUf("SC");
        assertEquals("SC", address.getUf());
    }

    @Test
    void testingGetAndSetRegiao() {
        address.setRegiao("Sul");
        assertEquals("Sul", address.getRegiao());
    }
}
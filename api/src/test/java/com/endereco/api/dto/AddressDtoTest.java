package com.endereco.api.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddressDtoTest {
    private AddressDto address;

    @BeforeEach
    void setUp() {
        address = new AddressDto();

    }

    @Test
    void testingGetAndSetZipCode() {
        address.setZipCode("88308-665");
        assertEquals("88308-665", address.getZipCode());
    }

    @Test
    void testingGetAndSetStreet() {
        address.setStreet("Rua Francisco Delvan");
        assertEquals("Rua Francisco Delvan", address.getStreet());
    }

    @Test
    void testingGetAndSetComplement() {
        address.setComplement(" ");
        assertEquals(" ", address.getComplement());
    }

    @Test
    void testingGetAndSetNeighborhood() {
        address.setNeighborhood("Cidade Nova");
        assertEquals("Cidade Nova", address.getNeighborhood());
    }

    @Test
    void testingGetAndSetCity() {
        address.setCity("Itajaí");
        assertEquals("Itajaí", address.getCity());
    }

    @Test
    void testingGetAndSetState() {
        address.setState("SC");
        assertEquals("SC", address.getState());
    }

    @Test
    void testingGetAndSetRegion() {
        address.setRegion("Sul");
        assertEquals("Sul", address.getRegion());
    }
}
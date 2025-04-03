package com.endereco.api.controller;

import com.endereco.api.model.Address;
import com.endereco.api.service.ZipCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ZipCodeController {

    private final ZipCodeService zipCodeService;

    @GetMapping("/{cep}")
    public ResponseEntity<Address> searchCep(@PathVariable String cep) {
        Address address = zipCodeService.searchAddressByCep(cep);
        return ResponseEntity.ok(address);
    }
}

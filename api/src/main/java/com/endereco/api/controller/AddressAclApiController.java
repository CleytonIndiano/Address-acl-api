package com.endereco.api.controller;


import com.endereco.api.dto.AddressDto;
import com.endereco.api.service.AddressAclApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api")
public class AddressAclApiController {

    @Autowired
    private AddressAclApiService addressAclApiService;

    @GetMapping("address/{zipcode}")
    public ResponseEntity<AddressDto> searchCep(@PathVariable String zipcode){
        AddressDto address = addressAclApiService.getAddressByZipCode(zipcode);
        return ResponseEntity.ok(address);
    }
}

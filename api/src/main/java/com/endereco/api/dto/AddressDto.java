package com.endereco.api.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto {

    @JsonProperty(value = "zipCode")
    private String zipCode;
    @JsonProperty(value = "street")
    private String street;
    @JsonProperty(value = "complement")
    private String complement;
    @JsonProperty(value = "neighborhood")
    private String neighborhood;
    @JsonProperty(value = "city")
    private String city;
    @JsonProperty(value = "state")
    private String state;
    @JsonProperty(value = "region")
    private String region;
}


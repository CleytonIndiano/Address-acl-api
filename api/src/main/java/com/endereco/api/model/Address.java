package com.endereco.api.model;

import lombok.Data;

@Data
public class Address {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String regiao;
}

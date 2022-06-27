package com.example.enderecoapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Endereco {
    private Integer id;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;

    private String uf;


    public Endereco(String cep) {
        this.cep = cep;
    }
    
}

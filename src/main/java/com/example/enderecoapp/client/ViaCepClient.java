package com.example.enderecoapp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.enderecoapp.model.Endereco;

@FeignClient(url = "${viacep-api.url}", name = "viaCepClient")
public interface ViaCepClient {
    @GetMapping(value = "/{cep}/json/")
    Endereco obterPorCep(@PathVariable String cep);
}

package com.example.enderecoapp.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.enderecoapp.model.Endereco;

@FeignClient(url = "${endereco-api.url}", name = "enderecoClient")
public interface EnderecoClient {
    @GetMapping(value = "/endereco")
    List<Endereco> obterLista();

    @PostMapping(value = "/endereco")
    void incluir(@RequestBody Endereco endereco);

    @DeleteMapping(value = "/endereco/{id}")
    void excluir(@PathVariable Integer id);

    @GetMapping(value = "/endereco/{cep}")
    Endereco obterPorCep(@PathVariable String cep);
}

package com.enderecoapp.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enderecoapp.client.EnderecoClient;
import com.enderecoapp.client.ViaCepClient;
import com.enderecoapp.model.Endereco;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoClient enderecoClient;

    @Autowired
    private ViaCepClient viaCepClient;

    public List<Endereco> obterLista() {
        return enderecoClient.obterLista();
    }

    public Endereco obterPorCep(String cep) {
        var endereco = viaCepClient.obterPorCep(cep);

        return Objects.requireNonNullElseGet(endereco, () -> new Endereco(cep));
    }

    public void incluir(Endereco endereco) {
        enderecoClient.incluir(endereco);
    }

    public void excluir(Integer id) {
        enderecoClient.excluir(id);
    }
    
}

package com.example.enderecoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enderecoapp.client.EstadoClient;
import com.example.enderecoapp.model.Estado;

@Service
public class EstadoService {
    @Autowired
    EstadoClient estadoClient;

    public List<Estado> obterLista() {
        return estadoClient.obterEstados();
    }
}

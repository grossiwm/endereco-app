package com.enderecoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enderecoapp.client.EstadoClient;
import com.enderecoapp.model.Estado;

@Service
public class EstadoService {
    @Autowired
    EstadoClient estadoClient;

    public List<Estado> obterLista() {
        return estadoClient.obterEstados();
    }
}

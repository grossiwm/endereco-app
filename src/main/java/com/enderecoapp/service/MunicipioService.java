package com.enderecoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enderecoapp.client.MunicipioClient;
import com.enderecoapp.model.Municipio;

@Service
public class MunicipioService {
    @Autowired
    MunicipioClient municipioClient;

    public List<Municipio> obterLista(String estadoSigla) {
        return municipioClient.obterMunicipios(estadoSigla);
    }
}

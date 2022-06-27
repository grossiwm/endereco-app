package com.example.enderecoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.enderecoapp.client.MunicipioClient;
import com.example.enderecoapp.model.Municipio;

@Service
public class MunicipioService {
    @Autowired
    MunicipioClient municipioClient;

    public List<Municipio> obterLista(Integer id) {
        return municipioClient.obterMunicipios(id);
    }
}

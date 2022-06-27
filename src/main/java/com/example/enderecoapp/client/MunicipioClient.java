package com.example.enderecoapp.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.enderecoapp.model.Municipio;

@FeignClient(url = "${ibge-api.url}", name = "municipioClient")
public interface MunicipioClient {
	
    @GetMapping(value = "/{id}/municipios")
    List<Municipio> obterMunicipios(@PathVariable Integer id);
    
}

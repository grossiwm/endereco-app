package com.example.enderecoapp.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.enderecoapp.model.Municipio;

@FeignClient(url = "${ibge-api.url}", name = "municipioClient")
public interface MunicipioClient {
	
    @GetMapping(value = "/estados/{UF}/municipios")
    List<Municipio> obterMunicipios(@PathVariable(name = "UF") String siglaEstado);
    
}

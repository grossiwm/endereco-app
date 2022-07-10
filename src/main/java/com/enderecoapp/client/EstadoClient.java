package com.enderecoapp.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.enderecoapp.model.Estado;

@FeignClient(url = "${ibge-api.url}", name = "estadoClient")
public interface EstadoClient {
	
	@GetMapping(value = "estados")
	List<Estado> obterEstados();
}

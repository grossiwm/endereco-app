package com.example.enderecoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.enderecoapp.service.MunicipioService;

@Controller
public class MunicipioController {
	
	@Autowired
	private MunicipioService municipioService;
	
    @GetMapping(value = "/municipios/{UF}")
    public String telaLista(Model model, @PathVariable(name = "UF") String estadoSigla) {
        model.addAttribute("lista", municipioService.obterLista(estadoSigla));
        return "municipio/lista";
    }

}

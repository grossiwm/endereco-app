package com.enderecoapp.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.enderecoapp.model.Endereco;
import com.enderecoapp.model.Role;
import com.enderecoapp.model.Usuario;
import com.enderecoapp.service.RoleService;
import com.enderecoapp.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private RoleService roleService;
	
	@GetMapping(value="/usuario")
	public String telaCadastro(Model model) {
		
		model.addAttribute("roles", roleService.obterLista());
		
		return "usuario/cadastro";
	}
	
	@PostMapping(value="/usuario/incluir")
	public String incluir(Usuario usuario, Endereco endereco, @RequestParam Integer acesso) {
		
		usuario.setEndereco(endereco);
		usuario.setRoles(Arrays.asList(new Role(acesso)));
		usuarioService.incluir(usuario);
		
		return "redirect:/";
	}

}

package com.enderecoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.enderecoapp.model.Usuario;
import com.enderecoapp.repository.UsuarioRepository;



@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void incluir(Usuario usuario) {
		usuario.setSenha(bCryptPasswordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
	
	public void excluir(Usuario usuario) {
		usuarioRepository.deleteById(usuario.getId());
	}
	
	public void excluirTudo() {
		usuarioRepository.deleteAll();
	}
	
	public Usuario autenticar(String email, String senha) {
		
		Usuario usuarioRetornado = usuarioRepository.findByEmail(email);
		
		if(usuarioRetornado != null && usuarioRetornado.getSenha().equals(senha)){
			return usuarioRetornado;
		}
		
		return null;
	}

}

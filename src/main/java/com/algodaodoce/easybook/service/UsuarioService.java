package com.algodaodoce.easybook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algodaodoce.easybook.entity.Usuario;
import com.algodaodoce.easybook.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired UsuarioRepository usuarioRepository;
	
	public Usuario salvar(Usuario usuario){
		return this.usuarioRepository.save(usuario);
	}
	
	public Usuario buscar(Long id){
		return this.usuarioRepository.getOne(id);
	}
	
	public List<Usuario> listar(){
		return this.usuarioRepository.findAll();
	}
	
	public Usuario deletar(Long id){
		Usuario usuario = this.buscar(id);
		if(usuario != null) this.usuarioRepository.delete(usuario);
		return usuario;
	}

	public Usuario findByEmail(String email) {
		
		return this.usuarioRepository.findByEmail(email);
	}
}

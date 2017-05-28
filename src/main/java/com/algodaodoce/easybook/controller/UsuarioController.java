package com.algodaodoce.easybook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algodaodoce.easybook.entity.Usuario;
import com.algodaodoce.easybook.service.UsuarioService;
import com.algodaodoce.easybook.utils.Map;
import com.algodaodoce.easybook.utils.Path;

@Controller
@RequestMapping(path=Path.USUARIO_PATH)
public class UsuarioController implements Map{

	@Autowired UsuarioService usuarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String livro(Model model){
		
		model.addAttribute("usuarios", usuarioService.listar());
		return "usuario/listar_usuario";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> salvar(Usuario usuario){
		
		return new ResponseEntity<Usuario>(this.usuarioService.salvar(usuario),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@PathVariable Long id){
		
		return new ResponseEntity<Usuario>(this.usuarioService.buscar(id),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<Usuario> deletar(@PathVariable Long id){
		
		return new ResponseEntity<Usuario>(this.usuarioService.deletar(id),HttpStatus.OK);
	}
}

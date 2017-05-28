package com.algodaodoce.easybook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algodaodoce.easybook.entity.Usuario;
import com.algodaodoce.easybook.service.CadastroService;
import com.algodaodoce.easybook.utils.Map;
import com.algodaodoce.easybook.utils.Path;

@Controller
@RequestMapping(path = Path.CADASTRO_PATH)
public class CadastroController implements Map{

	@Autowired
	CadastroService cadastrarService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario) {

		return new ResponseEntity<Usuario>(this.cadastrarService.salvar(usuario), HttpStatus.CREATED);
	}
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> chamar() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
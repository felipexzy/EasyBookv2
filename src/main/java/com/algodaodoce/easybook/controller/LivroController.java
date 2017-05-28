package com.algodaodoce.easybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algodaodoce.easybook.entity.Livro;
import com.algodaodoce.easybook.service.LivroService;
import com.algodaodoce.easybook.utils.Map;
import com.algodaodoce.easybook.utils.Path;

@Controller
@RequestMapping(path=Path.LIVRO_PATH)
public class LivroController implements Map{

	@Autowired LivroService livroService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> livro(){
		
		return new ResponseEntity<List<Livro>>(livroService.listarPorLogado(),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Livro> salvar(@RequestBody Livro livro) {
		
		return new ResponseEntity<Livro>(this.livroService.salvar(livro),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public ResponseEntity<Livro> buscar(@PathVariable Long id){
		
		return new ResponseEntity<Livro>(this.livroService.buscar(id),HttpStatus.OK);
	}
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Livro> deletar(@RequestBody Livro livro){
		
		return new ResponseEntity<Livro>(this.livroService.deletar(livro),HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/list")
	public ResponseEntity<Page<Livro>> getPagination(Pageable pageable) {

		return new ResponseEntity<Page<Livro>>(livroService.getBookPagination(pageable), HttpStatus.OK);
	}
}

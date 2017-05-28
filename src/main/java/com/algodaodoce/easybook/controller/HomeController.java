package com.algodaodoce.easybook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.algodaodoce.easybook.entity.Livro;
import com.algodaodoce.easybook.service.LivroService;
import com.algodaodoce.easybook.utils.Map;
import com.algodaodoce.easybook.utils.Path;

@Controller
@RequestMapping(path=Path.HOME_PATH)
public class HomeController implements Map{
	@Autowired
	LivroService livroServices;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Livro>> livros() {
		return new ResponseEntity<>(livroServices.listar(), HttpStatus.OK);

	}
	@RequestMapping(value = "/buscar/{nome}")
	public ResponseEntity<List<Livro>> buscar(@PathVariable String nome) {
		return new ResponseEntity<>(livroServices.listarPorNome(nome), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/list")
	public ResponseEntity<Page<Livro>> getPagination(Pageable pageable) {

		return new ResponseEntity<Page<Livro>>(livroServices.getBookPagination(pageable), HttpStatus.OK);
	}
}

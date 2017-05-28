package com.algodaodoce.easybook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.algodaodoce.easybook.entity.Livro;
import com.algodaodoce.easybook.entity.Usuario;
import com.algodaodoce.easybook.repository.LivroRepository;
import com.algodaodoce.easybook.security.CurrentUser;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepository;

	@Autowired
	UsuarioService ususarioService;

	@Autowired
	private CurrentUser currentUser;

	public Livro salvar(Livro livro) {
		Usuario usuario = this.ususarioService.findByEmail(currentUser.getActiveUser().getEmail());

		livro.setUsuario(usuario);

		return this.livroRepository.save(livro);
	}

	public Livro buscar(Long id) {

		return this.livroRepository.getOne(id);
	}

	public List<Livro> listar() {

		List<Livro> livros = livroRepository.findAll();

		return livros;
	}

	public List<Livro> listarPorLogado() {

		Usuario usuario = this.ususarioService.findByEmail(currentUser.getActiveUser().getEmail());

		List<Livro> livros = this.livroRepository.findAllByUsuario(usuario);

		return livros;
	}

	public List<Livro> listarPorNome(String nome) {
		return this.livroRepository.listarPorNome(nome);
	}

	public Livro deletar(Livro l) {
		Livro livro = this.buscar(l.getId());
		if (livro != null)
			this.livroRepository.delete(livro);
		return livro;
	}

	public Page<Livro> getBookPagination(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.livroRepository.findAll(pageable);
	}
}

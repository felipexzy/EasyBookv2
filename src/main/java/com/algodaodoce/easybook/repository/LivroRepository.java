package com.algodaodoce.easybook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.algodaodoce.easybook.entity.Livro;
import com.algodaodoce.easybook.entity.Usuario;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
@Query("select l from Livro l where nome like %:nome%")
public List<Livro> listarPorNome(@Param("nome") String nome);

public List<Livro> findAllByUsuario(Usuario usuario); 
	
	
}

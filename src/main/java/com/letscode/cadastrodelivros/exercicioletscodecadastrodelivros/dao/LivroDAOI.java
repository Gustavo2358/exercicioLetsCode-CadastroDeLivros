package com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.dao;

import com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.model.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroDAOI {

    Livro save(Livro livro);

    List<Livro> findAll();

    Livro delete(long id);

    Optional<Livro> getById(String idLivro);

    Optional<Livro> update(Livro livro);
}

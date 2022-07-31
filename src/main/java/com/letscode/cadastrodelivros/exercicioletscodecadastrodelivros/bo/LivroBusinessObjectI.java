package com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.bo;

import com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.model.Livro;

import java.util.List;

public interface LivroBusinessObjectI {

    Livro save(Livro livro);

    List<Livro> findAll();

    Livro delete(long id);

    Livro getById(String idLivro);

    Livro update(Livro livro);
}

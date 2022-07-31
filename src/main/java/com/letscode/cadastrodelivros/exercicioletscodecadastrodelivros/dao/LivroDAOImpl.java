package com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.dao;

import com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroDAOImpl implements LivroDAOI{
    private static List<Livro> livros = new ArrayList<>();
    private static long countLivros;

    @Override
    public Livro save(Livro livro){
        countLivros++;
        livro.setId(countLivros);
        livros.add(livro);
        return livro;
    }

    @Override
    public List<Livro> findAll(){
        return livros;
    }

    @Override
    public Livro delete(long id) {
        Livro livro = livros.stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .get();
        livros.remove(livro);
        countLivros--;
        return livro;


    }

    @Override
    public Optional<Livro> getById(String idLivro) {
        return livros.stream()
                .filter(l -> l.getId().equals(Long.parseLong(idLivro)))
                .findFirst();
    }

    @Override
    public Optional<Livro> update(Livro livroAlterado) {

        Livro livro = livros.stream()
                .filter(l -> l.getId().equals(livroAlterado.getId()))
                .findFirst()
                .get();
        livro.setId(livroAlterado.getId());
        livro.setNome(livroAlterado.getNome());
        livro.setAutor(livroAlterado.getAutor());
        return Optional.of(livro);
    }
}

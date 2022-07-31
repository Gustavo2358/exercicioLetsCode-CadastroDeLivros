package com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.bo;

import com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.dao.LivroDAOI;
import com.letscode.cadastrodelivros.exercicioletscodecadastrodelivros.model.Livro;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class LivroBusinessObjectImpl implements LivroBusinessObjectI{

    private LivroDAOI livroDAOI;

    @Inject
    public LivroBusinessObjectImpl(LivroDAOI livroDAOI){
        this.livroDAOI = livroDAOI;
    }

    @Override
    public Livro save(Livro livro) {
        valida(livro);
        return livroDAOI.save(livro);
    }

    @Override
    public List<Livro> findAll() {
        return livroDAOI.findAll();
    }

    @Override
    public Livro delete(long id) {
        return livroDAOI.delete(id);
    }

    @Override
    public Livro getById(String idLivro) {
        Optional<Livro> optionalLivro = livroDAOI.getById(idLivro);
        if (optionalLivro.isPresent()){
            return optionalLivro.get();
        }else{
            throw new IllegalArgumentException("Livro não encontrado para o id: ".concat(idLivro));
        }
    }

    @Override
    public Livro update(Livro livro) {
        Optional<Livro> optionalLivro = livroDAOI.update(livro);
        return optionalLivro.get();
    }

    private void valida(Livro livro) {
        if(livro.getNome().equals("")){
            throw new IllegalArgumentException("Nome inválido");
        }
    }
}

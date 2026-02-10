package org.drogo.service;

import org.drogo.exceptions.BodyVazioException;
import org.drogo.exceptions.LivroJaExisteException;
import org.drogo.model.LivroModel;
import org.drogo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<LivroModel> getTodosLivros(){
        return repository.findAll();
    }

    public LivroModel addLivro(LivroModel livroModel){
        if(repository.findByTitulo(livroModel.getTitulo()) != null){
            throw new LivroJaExisteException("Esse livro já existe");
        }else if(livroModel.isEmpty()){
            throw new BodyVazioException("Erro: foi enviado uma requisição vazia. \n" +
                    "Favor informar: ISBN, Titulo, Autor, Editora, Data de Lançamento e Numero de paginas.");
        }

        return repository.save(livroModel);
    }

    public void deleteLivroPeloTitulo(String titulo){
        repository.deleteByTitulo(titulo);
    }

    public LivroModel updateLivro(LivroModel livroModelCorrecao){
        LivroModel livroModel = repository.findByTitulo(livroModelCorrecao.getTitulo());
        if(livroModel.isEmpty()){
            throw new RuntimeException("Erro: Livro não localizado");
        }else{
            livroModel.setIsbn(livroModelCorrecao.getIsbn());
            livroModel.setTitulo(livroModelCorrecao.getTitulo());
            livroModel.setAutor(livroModelCorrecao.getAutor());
            livroModel.setEditora(livroModelCorrecao.getEditora());
            livroModel.setLancamento(livroModelCorrecao.getLancamento());
            livroModel.setPaginas(livroModelCorrecao.getPaginas());
            return repository.save(livroModelCorrecao);
        }
    }
}

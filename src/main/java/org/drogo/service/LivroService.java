package org.drogo.service;

import org.drogo.exceptions.BodyVazioException;
import org.drogo.exceptions.FutureDateException;
import org.drogo.exceptions.LivroJaExisteException;
import org.drogo.model.LivroModel;
import org.drogo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;
    private LocalDate localDate;

    public List<LivroModel> getTodosLivros(){
        return repository.findAll();
    }

    public LivroModel addLivro(LivroModel livroModel){
        if(repository.findByTitulo(livroModel.getTitulo()) != null){
            throw new LivroJaExisteException("Esse livro já existe");
        }else if(livroModel.isAllEmpty()){
            throw new BodyVazioException("Foi enviado uma requisição vazia. \n" +
                    "Favor informar: ISBN, Titulo, Autor, Editora, Data de Lançamento e Numero de paginas.");
        }else if((livroModel.getLancamento()).isAfter(LocalDate.now())){
            throw new FutureDateException("Foi passado uma data no futuro");
        }

        return repository.save(livroModel);
    }

    public void deleteLivroPeloTitulo(String titulo){
        repository.deleteByTitulo(titulo);
    }

    public LivroModel updateLivro(LivroModel livroModelCorrecao){
        LivroModel livroModel = repository.findByIsbn(livroModelCorrecao.getIsbn());
        if(livroModel.isAllEmpty()){
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

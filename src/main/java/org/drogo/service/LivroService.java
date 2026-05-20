package org.drogo.service;

import org.drogo.exceptions.BodyVazioException;
import org.drogo.exceptions.FutureDateException;
import org.drogo.exceptions.LivroJaExisteException;
import org.drogo.exceptions.NotNullException;
import org.drogo.model.LivroModel;
import org.drogo.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repository;

    public List<LivroModel> getTodosLivros(){
        return repository.findAll();
    }
    public Page<LivroModel> getTodosLivrosPage(Pageable pageable){return repository.findAll(pageable);}

    public LivroModel getLivrosPorIsbn(String isbn){return repository.findByIsbn(isbn);}

    public LivroModel addLivro(LivroModel livroModel){
        if(repository.findByTitulo(livroModel.getTitulo()) != null){
            throw new LivroJaExisteException("Esse livro já existe");
        }else if(livroModel.isAllEmpty()){
            throw new BodyVazioException("Foi enviado uma requisição vazia.\n" +
                    "Favor informar: ISBN, Titulo, Autor, Editora, Data de Lançamento e Numero de paginas.");
        }else if((livroModel.getLancamento()).isAfter(LocalDate.now())){
            throw new FutureDateException("Foi passado uma data no futuro.");
        }else if((livroModel.getTitulo()).isEmpty() || (livroModel.getTitulo()).isBlank()){
            throw new NotNullException("Título é obrigatório.");
        }else if((livroModel.getIsbn()).isEmpty() || (livroModel.getIsbn()).isBlank()){
            throw new NotNullException("ISBN é obrigatório.");
        }

        if (livroModel.getCreatedAt() == null) {
            livroModel.setCreatedAt(LocalDateTime.now());
        }

        return repository.save(livroModel);
    }

        public List<LivroModel> getUltimos3Livros() {
            return repository.findTop3ByOrderByCreatedAtDesc();
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

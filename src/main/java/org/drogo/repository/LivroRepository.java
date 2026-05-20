package org.drogo.repository;

import org.drogo.model.LivroModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<LivroModel, String> {
    LivroModel findByTitulo(String titulo);
    void deleteByTitulo(String titulo);
    LivroModel findByIsbn(String isbn);
    Page<LivroModel> findAll(Pageable pageable);

    // Buscar os 3 últimos livros adicionados
    java.util.List<LivroModel> findTop3ByOrderByCreatedAtDesc();
}

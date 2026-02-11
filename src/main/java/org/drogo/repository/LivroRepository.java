package org.drogo.repository;

import org.drogo.model.LivroModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends MongoRepository<LivroModel, String> {
    LivroModel findByTitulo(String titulo);
    void deleteByTitulo(String titulo);
    LivroModel findByIsbn(String isbn);
}

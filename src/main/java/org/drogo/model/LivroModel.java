package org.drogo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Livros")
public class LivroModel {

    @Id
    private String isbn;
    private String titulo;
    private String autor;
    private String editora;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate lancamento;
    private String paginas;

    @CreatedDate
    private LocalDateTime createdAt;


    public boolean isAllEmpty(){
        return ((titulo == null || titulo.isEmpty())
                && (isbn == null || isbn.isEmpty())
                && (autor == null || autor.isEmpty())
                && (editora == null || editora.isEmpty())
                && (lancamento == null)
                && (paginas == null || paginas.isEmpty()));
    }



}

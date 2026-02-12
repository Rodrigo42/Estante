package org.drogo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Livros")
public class LivroModel {

    @Id
    @NotNull
    private String isbn;
    @NotNull
    private String titulo;
    private String autor;
    private String editora;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate lancamento;
    private String paginas;


    public boolean isAllEmpty(){
        return ((titulo == null || titulo.isEmpty())
                && (isbn == null || isbn.isEmpty())
                && (autor == null || autor.isEmpty())
                && (editora == null || editora.isEmpty())
                && (lancamento == null)
                && (paginas == null || paginas.isEmpty()));
    }

}

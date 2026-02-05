package org.drogo.controller;

import org.drogo.model.LivroModel;
import org.drogo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel createLivro(@RequestBody LivroModel livroModel){
        return livroService.addLivro(livroModel);
    }

    @GetMapping
    public List<LivroModel> getTodosLivros(){
        return livroService.getTodosLivros();
    }

    @DeleteMapping("/delete")
    public void deleteLivro(String titulo){
        livroService.deleteLivro(titulo);
    }
}

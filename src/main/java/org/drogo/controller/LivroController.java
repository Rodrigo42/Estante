package org.drogo.controller;

import jakarta.validation.Valid;
import org.drogo.model.LivroModel;
import org.drogo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public LivroModel createLivro(@Valid @RequestBody LivroModel livroModel){
        return livroService.addLivro(livroModel);
    }

    @GetMapping
    public List<LivroModel> getTodosLivros(){
        return livroService.getTodosLivros();
    }

    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivro(@RequestBody Map<String, String> body){
        livroService.deleteLivroPeloTitulo(body.get("titulo"));
    }

    @PutMapping("/update")
    public void updateLivro(@RequestBody LivroModel livroModel){
        livroService.updateLivro(livroModel);
    }
}

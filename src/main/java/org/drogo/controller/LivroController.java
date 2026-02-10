package org.drogo.controller;

import org.drogo.model.LivroModel;
import org.drogo.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public LivroModel createLivro(@RequestBody LivroModel livroModel){
        return livroService.addLivro(livroModel);
    }

    @GetMapping
    public List<LivroModel> getTodosLivros(){
        return livroService.getTodosLivros();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteLivro(@RequestBody Map<String, String> body){
        livroService.deleteLivroPeloTitulo(body.get("titulo"));
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public void putLivro(@RequestBody LivroModel livroModel){
        livroService.updateLivro(livroModel);
    }
}

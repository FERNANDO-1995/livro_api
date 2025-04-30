package com.example.Livro.controller;

import com.example.Livro.dto.LivroDto;
import com.example.Livro.model.Livro;
import com.example.Livro.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("livros")
public class LivroController {
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public List<LivroDto> index(){
        return livroService.findAll();
        }

    @GetMapping("{id}")
    public LivroDto index(@PathVariable("id")UUID id){
        return livroService.findById(id);
    }

    @GetMapping("/listar")
    public List<Livro> listar(){
        return livroService.findByLivroAndAutor();
    }
    @PostMapping
    public ResponseEntity<LivroDto> store(@RequestBody Livro livro){

        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.store(livro));
    }

    @PutMapping
    public ResponseEntity<LivroDto> update(@RequestBody Livro livro){
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.update(livro));
    }

    @DeleteMapping("{id}")
    public void destroy(@PathVariable("id") UUID id){
        livroService.destroy(id);
    }

}

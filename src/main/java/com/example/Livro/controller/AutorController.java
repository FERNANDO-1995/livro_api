package com.example.Livro.controller;

import com.example.Livro.dto.autor.AutorDtoRequest;
import com.example.Livro.dto.autor.AutorDtoResponse;
import com.example.Livro.model.Autor;
import com.example.Livro.service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/autores")
public class AutorController {
  private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public List<AutorDtoResponse> index(){
        return autorService.findAll();
    }
    @GetMapping("{id}")
    public AutorDtoResponse index(@PathVariable("id") UUID id){
        return autorService.findById(id);
    }

    @GetMapping("findAutorBooksById/{id}")
    public AutorDtoResponse findAutorBooksById(@PathVariable("id") UUID id){
        return autorService.findAutorBooksById(id);
    }

    @PostMapping
    public ResponseEntity<AutorDtoRequest> store(@RequestBody AutorDtoRequest autor){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.store(autor));
    }

    @PutMapping
    public ResponseEntity<AutorDtoRequest> update(@RequestBody AutorDtoRequest autor){
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.store(autor));
    }
    @DeleteMapping("{id}")
    public void destroy(@PathVariable("id") UUID id){
        autorService.destroy(id);
    }
}

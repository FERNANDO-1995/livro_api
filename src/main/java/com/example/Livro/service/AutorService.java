package com.example.Livro.service;

import com.example.Livro.dto.autor.AutorDtoRequest;
import com.example.Livro.dto.autor.AutorDtoResponse;
import com.example.Livro.model.Autor;

import java.util.List;
import java.util.UUID;

public interface AutorService {
    List<AutorDtoResponse> findAll();
    AutorDtoResponse findById(UUID id);
    AutorDtoResponse findAutorBooksById(UUID id);
    AutorDtoRequest store(AutorDtoRequest autor);
    AutorDtoRequest update(Autor autor);
    void destroy(UUID uuid);

}

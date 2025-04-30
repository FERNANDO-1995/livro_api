package com.example.Livro.service;

import com.example.Livro.dto.AutorDto;
import com.example.Livro.model.Autor;

import java.util.List;
import java.util.UUID;

public interface AutorService {
    List<AutorDto> findAll();
    AutorDto findById(UUID id);
    AutorDto store(Autor autor);
    AutorDto update(Autor autor);
    void destroy(UUID uuid);

}

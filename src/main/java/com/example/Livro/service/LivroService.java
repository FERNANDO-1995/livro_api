package com.example.Livro.service;
import com.example.Livro.dto.LivroDto;
import com.example.Livro.model.Livro;

import java.util.List;
import java.util.UUID;


public interface LivroService {

    List<LivroDto> findAll();
    LivroDto findById(UUID id);
    LivroDto store(Livro livro);
    LivroDto update(Livro livro);
    List<Livro> findByLivroAndAutor();
    void destroy(UUID id);
}

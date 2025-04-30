package com.example.Livro.service;
import com.example.Livro.dto.livro.LivroDtoRequest;
import com.example.Livro.model.Livro;

import java.util.List;
import java.util.UUID;


public interface LivroService {

    List<LivroDtoRequest> findAll();
    LivroDtoRequest findById(UUID id);
    LivroDtoRequest store(LivroDtoRequest livro);
    LivroDtoRequest update(LivroDtoRequest livro);
    List<Livro> findByLivroAndAutor();
    void destroy(UUID id);
}

package com.example.Livro.service.impl;

import com.example.Livro.dto.autor.AutorDtoRequest;
import com.example.Livro.dto.livro.LivroDtoRequest;
import com.example.Livro.dto.livro.LivroDtoResponse;
import com.example.Livro.model.Livro;
import com.example.Livro.repository.LivroRepository;
import com.example.Livro.service.LivroService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LivroServiceImp implements LivroService {
    private LivroRepository livroRepository;

    public LivroServiceImp(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public List<LivroDtoRequest> findAll() {
        return LivroDtoRequest.converter(livroRepository.findAll());
    }

    @Override
    public LivroDtoRequest findById(UUID id) {
        Optional<Livro> livro = livroRepository.findById(id);
        Livro livro1 = livro.orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        return new LivroDtoRequest(livro1);
    }

    @Override
    public LivroDtoRequest store(LivroDtoRequest livro) {
       
        return new LivroDtoRequest(livroRepository.save(new Livro(livro)));
    }

    @Override
    public LivroDtoRequest update(LivroDtoRequest livro) {
        return new LivroDtoRequest(livroRepository.save(new Livro(livro)));
    }

    @Override
    public List<Livro> findByLivroAndAutor() {
        List<Livro> livro = livroRepository.findAll();
        livro.stream().map(livro1 -> livro1.getAutor().getNome()).forEach(autor ->
                System.out.println(autor));
        return livro;
    }

    @Override
    public void destroy(UUID id) {
        findById(id);
        livroRepository.deleteById(id);

    }


}

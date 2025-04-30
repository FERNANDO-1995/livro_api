package com.example.Livro.service.impl;

import com.example.Livro.dto.LivroDto;
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
    public List<LivroDto> findAll() {
        return LivroDto.converter(livroRepository.findAll());
    }

    @Override
    public LivroDto findById(UUID id) {
        Optional<Livro> livro = livroRepository.findById(id);
        Livro livro1 = livro.orElseThrow(() -> new IllegalArgumentException("Livro não encontrado"));
        return new LivroDto(livro1);
    }

    @Override
    public LivroDto store(Livro livro) {
        return new LivroDto(livroRepository.save(livro));
    }

    @Override
    public LivroDto update(Livro livro) {
        return new LivroDto(livroRepository.save(livro));
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

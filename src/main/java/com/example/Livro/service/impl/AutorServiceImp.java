package com.example.Livro.service.impl;

import com.example.Livro.dto.AutorDto;
import com.example.Livro.model.Autor;
import com.example.Livro.repository.AutorRepository;
import com.example.Livro.service.AutorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AutorServiceImp implements AutorService {
    private AutorRepository autorRepository;

    public AutorServiceImp(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<AutorDto> findAll() {
        List<Autor> autors =autorRepository.findAll();
        return AutorDto.converter(autors);
    }

    @Override
    public AutorDto findById(UUID id) {
        Optional<Autor> autor = autorRepository.findById(id);
        Autor autorConverter = autor.orElseThrow(()-> new IllegalArgumentException("dados não encontrado"));
        return new AutorDto(autorConverter);

    }

    @Override
    public AutorDto store(Autor autor) {
        return new AutorDto(autorRepository.save(autor));
    }

    @Override
    public AutorDto update(Autor autor) {
        return new AutorDto(autorRepository.save(autor));
    }

    @Override
    public void destroy(UUID id) {
        autorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Livro não encontrado com este id"));

        autorRepository.deleteById(id);
    }
}

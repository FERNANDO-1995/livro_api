package com.example.Livro.service.impl;

import com.example.Livro.dto.autor.AutorDtoRequest;
import com.example.Livro.dto.autor.AutorDtoResponse;
import com.example.Livro.dto.livro.LivroDto;
import com.example.Livro.model.Autor;
import com.example.Livro.model.Livro;
import com.example.Livro.repository.AutorRepository;
import com.example.Livro.repository.LivroRepository;
import com.example.Livro.service.AutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class AutorServiceImp implements AutorService {
    private AutorRepository autorRepository;
    @Autowired
    private LivroRepository livroRepository;

    public AutorServiceImp(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<AutorDtoResponse> findAll() {
        List<Autor> autors =autorRepository.findAll();
        return AutorDtoResponse.converter(autors);
    }

    @Override
    public AutorDtoResponse findById(UUID id) {
        Optional<Autor> autor = autorRepository.findById(id);
        Autor autorConverter = autor.orElseThrow(()-> new IllegalArgumentException("dados não encontrado"));
        return new AutorDtoResponse(autorConverter);

    }
    public AutorDtoResponse findAutorBooksById(UUID id) {
        Autor autor = autorRepository.findById(id).get();
        List<Livro> livros = livroRepository.findByAutor(autor);        
       /*AutorDto autorDto=new AutorDto();
       autorDto.setLivros(LivroDto.converter(livros));
       autorDto.setDataNascimento(autor.getDataNascimento());
       autorDto.setNome(autor.getNome());*/
       autor.setLivros(livros);
        return new AutorDtoResponse(autor);

    }

    @Override
    public AutorDtoRequest store(AutorDtoRequest autorDto) {
        Autor autor = new Autor();
        autor.setNacionalidade(autorDto.getNacionalidade());
        autor.setDataNascimento(autorDto.getDataNascimento());
        autor.setNome(autorDto.getNome());

        return new AutorDtoRequest(autorRepository.save(autor));
    }

    @Override
    public AutorDtoRequest update(Autor autor) {
        return new AutorDtoRequest(autorRepository.save(autor));
    }

    @Override
    public void destroy(UUID id) {
        autorRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Livro não encontrado com este id"));

        autorRepository.deleteById(id);
    }
}

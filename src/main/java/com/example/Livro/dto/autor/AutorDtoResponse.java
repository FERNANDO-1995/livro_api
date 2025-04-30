package com.example.Livro.dto.autor;

import com.example.Livro.dto.livro.LivroDtoResponse;
import com.example.Livro.model.Autor;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class AutorDtoResponse {
    private UUID id;
    private String nome;
    private LocalDate dataNascimento;
    private String nacionalidade;
    private List<LivroDtoResponse> livros;
    


    public AutorDtoResponse() {
    }


    public AutorDtoResponse(Autor autor) {
        this.id = autor.getId();
        this.nome = autor.getNome();
        this.dataNascimento = autor.getDataNascimento();
        this.nacionalidade = autor.getNacionalidade();
        this.livros = LivroDtoResponse.converter(autor.getLivros());
    }
    
    



    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public static List<AutorDtoResponse> converter(List<Autor> autors) {
        return autors.stream().map(AutorDtoResponse::new).collect(Collectors.toList());
    }


    public List<LivroDtoResponse> getLivros() {
        return livros;
    }


    public void setLivros(List<LivroDtoResponse> livros) {
        this.livros = livros;
    }

}

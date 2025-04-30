package com.example.Livro.dto.livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import com.example.Livro.dto.autor.AutorDtoRequest;
import com.example.Livro.model.Livro;
import com.example.Livro.model.emum.GeneroLivro;
import java.util.List;
import java.util.stream.Collectors;

public class LivroDtoRequest {
    private UUID id;
    private String isbn;
    private String titulo;
    private LocalDate dataPublicacao;
    private BigDecimal preco;
    private GeneroLivro generoLivro;
    private AutorDtoRequest autorDto;

    

    public LivroDtoRequest() {
    }

    public LivroDtoRequest(Livro livro) {
        this.id = livro.getId();
        this.isbn = livro.getIsbn();
        this.titulo = livro.getTitulo();
        this.dataPublicacao = livro.getDataPublicacao();
        this.preco = livro.getPreco();
        this.generoLivro = livro.getGeneroLivro();
        this.autorDto = new AutorDtoRequest( livro.getAutor());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public GeneroLivro getGeneroLivro() {
        return generoLivro;
    }

    public void setGeneroLivro(GeneroLivro generoLivro) {
        this.generoLivro = generoLivro;
    }

    public AutorDtoRequest getAutorDto() {
        return autorDto;
    }

    public void setAutorDto(AutorDtoRequest autorDto) {
        this.autorDto = autorDto;
    }

    public static List<LivroDtoRequest> converter(List<Livro> livros) {
        return livros.stream().map(LivroDtoRequest::new).collect(Collectors.toList());
    }
}

package com.example.Livro.model;

import com.example.Livro.dto.autor.AutorDtoRequest;
import com.example.Livro.dto.livro.LivroDtoRequest;
import com.example.Livro.dto.livro.LivroDtoResponse;
import com.example.Livro.model.emum.GeneroLivro;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "ISBN", length = 20, nullable = false)
    private String isbn;
    @Column(name = "TITULO", length = 150, nullable = false)
    private String titulo;
@Column(name = "DATA_PUBLICACAO")
    private LocalDate dataPublicacao;
    @Column(name = "PRECO", precision = 18, scale = 2)
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    private GeneroLivro generoLivro;

    @ManyToOne//(cascade = CascadeType.ALL,)
    @JoinColumn(name = "autor_id")
    private Autor autor;


    public Livro() {
    }

    public Livro(LivroDtoRequest dto) {
        this.id =dto.getId();
        this.isbn = dto.getIsbn();
        this.titulo = dto.getTitulo();
        this.dataPublicacao = dto.getDataPublicacao();
        this.preco = dto.getPreco();
        this.generoLivro = dto.getGeneroLivro();
        this.autor = new Autor(dto.getAutorDto());
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

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }

    
}

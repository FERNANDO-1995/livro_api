package com.example.Livro.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.example.Livro.dto.autor.AutorDtoRequest;

@Entity
@Table(name = "TB_AUTOR")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID")
    private UUID id;
    @Column(name = "NOME", length = 80, nullable = false)
    private String nome;
    @Column(name = "DATA_NASCIMENTO", nullable = false)
    private LocalDate dataNascimento;
    @Column(name = "NACIONALIDADE", length = 50, nullable = false)
    private String nacionalidade;
    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

  
    public Autor() {
    }

    public Autor(AutorDtoRequest autorDtoRequest) {
        this.id = autorDtoRequest.getId();
        this.nome =autorDtoRequest.getNome();
        this.dataNascimento =autorDtoRequest.getDataNascimento();
        this.nacionalidade = autorDtoRequest.getNacionalidade();
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

    

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(id, autor.id) && Objects.equals(nome, autor.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}

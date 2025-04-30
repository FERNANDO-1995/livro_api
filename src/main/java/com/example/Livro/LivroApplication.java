package com.example.Livro;

import com.example.Livro.model.Livro;
import com.example.Livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class LivroApplication {
 @Autowired
 private LivroService livroService;
	public static void main(String[] args) {
		SpringApplication.run(LivroApplication.class, args);
//		ApplicationContext context = SpringApplication.run(LivroApplication.class, args);
//		LivroService bean = context.getBean(LivroService.class);
//		System.out.println(bean.findByLivroAndAutor());

	}
//	public void run(String... args) throws Exception {
//		List<Livro> livros = livroService.findByLivroAndAutor();
//
//		livros.forEach(livro -> System.out.println(livro.getTitulo() + " - " + livro.getAutor()));
//	}

}

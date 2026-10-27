package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class LivroService {

    private final LivroRepository repository;

    public LivroService(LivroRepository repository) {
        this.repository = repository;
    }

    // CADASTRAR
    public Livro cadastrar(Livro livro) {
        livro.setId(null);
        return repository.save(livro);
    }

    // LISTAR
    public List<Livro> listar() {
        return repository.findAll();
    }

    // CONSULTAR POR ID
    public Livro consultar(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Livro não encontrado"
                        ));
    }

    // ATUALIZAR
    public Livro atualizar(Long id, Livro dados) {

        Livro livro = consultar(id);

        livro.setTitulo(dados.getTitulo());
        livro.setAutor(dados.getAutor());
        livro.setGenero(dados.getGenero());
        livro.setAnoPublicacao(dados.getAnoPublicacao());
        livro.setStatusLeitura(dados.getStatusLeitura());

        return repository.save(livro);
    }

    // EXCLUIR
    public void excluir(Long id) {
        Livro livro = consultar(id);
        repository.delete(livro);
    }
}
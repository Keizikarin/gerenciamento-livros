package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.service.LivroService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService service) {
        this.service = service;
    }

    // CADASTRAR
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Livro cadastrar(@RequestBody Livro livro) {
        return service.cadastrar(livro);
    }

    // LISTAR
    @GetMapping
    public List<Livro> listar() {
        return service.listar();
    }

    // CONSULTAR POR ID
    @GetMapping("/{id}")
    public Livro consultar(@PathVariable Long id) {
        return service.consultar(id);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public Livro atualizar(
            @PathVariable Long id,
            @RequestBody Livro livro) {
        return service.atualizar(id, livro);
    }

    // EXCLUIR
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}
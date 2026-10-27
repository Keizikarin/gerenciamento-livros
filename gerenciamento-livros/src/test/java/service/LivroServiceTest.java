package com.biblioteca.service;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LivroServiceTest {

    @Mock
    private LivroRepository repository;

    @InjectMocks
    private LivroService service;

    private Livro livro;

    @BeforeEach
    void configurar() {
        MockitoAnnotations.openMocks(this);

        livro = new Livro(
                "Dom Casmurro",
                "Machado de Assis",
                "Romance",
                1899,
                "Lido"
        );
    }

    @Test
    void deveCadastrarLivro() {
        when(repository.save(any(Livro.class)))
                .thenReturn(livro);

        Livro resultado = service.cadastrar(livro);

        assertEquals("Dom Casmurro", resultado.getTitulo());
        verify(repository).save(livro);
    }

    @Test
    void deveListarLivros() {
        when(repository.findAll())
                .thenReturn(List.of(livro));

        List<Livro> resultado = service.listar();

        assertEquals(1, resultado.size());
        assertEquals("Dom Casmurro", resultado.get(0).getTitulo());
    }

    @Test
    void deveConsultarLivro() {
        when(repository.findById(1L))
                .thenReturn(Optional.of(livro));

        Livro resultado = service.consultar(1L);

        assertEquals("Machado de Assis", resultado.getAutor());
    }

    @Test
    void deveAtualizarLivro() {
        Livro novosDados = new Livro(
                "Dom Casmurro",
                "Machado de Assis",
                "Literatura Brasileira",
                1899,
                "Lendo"
        );

        when(repository.findById(1L))
                .thenReturn(Optional.of(livro));

        when(repository.save(any(Livro.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Livro resultado = service.atualizar(1L, novosDados);

        assertEquals("Lendo", resultado.getStatusLeitura());
        assertEquals("Literatura Brasileira", resultado.getGenero());
    }

    @Test
    void deveExcluirLivro() {
        when(repository.findById(1L))
                .thenReturn(Optional.of(livro));

        service.excluir(1L);

        verify(repository).delete(livro);
    }
}

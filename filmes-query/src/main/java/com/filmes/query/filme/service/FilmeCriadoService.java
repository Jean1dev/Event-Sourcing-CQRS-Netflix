package com.filmes.query.filme.service;

import com.filmes.query.ator.domain.Ator;
import com.filmes.query.ator.domain.repository.AtorRepository;
import com.filmes.query.filme.amqp.events.FilmeCriadoEvent;
import com.filmes.query.filme.domain.Filme;
import com.filmes.query.filme.domain.repository.FilmeRepository;
import com.filmes.query.genero.domain.Genero;
import com.filmes.query.genero.domain.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class FilmeCriadoService {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    private AtorRepository atorRepository;

    @Autowired
    private GeneroRepository generoRepository;

    public void executar(FilmeCriadoEvent event) {
        repository.save(Filme.builder()
                .id(event.getId())
                .atores(event.getElenco().stream().map(this::getAtor).collect(Collectors.toSet()))
                .dataLancamento(event.getDataLancamento())
                .duracao(event.getDuracao())
                .filmeURL(event.getFilmeURL())
                .generos(event.getGeneros().stream().map(this::getGenero).collect(Collectors.toSet()))
                .isLike(event.getLike())
                .subtitulo(event.getSubtitulo())
                .titulo(event.getTitulo())
                .build());
    }

    private Ator getAtor(String id) {
        return atorRepository.findById(id).orElseThrow();
    }

    private Genero getGenero(String id) {
        return generoRepository.findById(id).orElseThrow();
    }
}

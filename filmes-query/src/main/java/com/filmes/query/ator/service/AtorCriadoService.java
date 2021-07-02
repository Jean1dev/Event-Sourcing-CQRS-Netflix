package com.filmes.query.ator.service;

import com.filmes.query.ator.amqp.event.AtorCriadoEvent.AtorCriadoEvent;
import com.filmes.query.ator.domain.Ator;
import com.filmes.query.ator.domain.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtorCriadoService {

    @Autowired
    private AtorRepository repository;

    public void executar(AtorCriadoEvent event) {
        repository.save(Ator.builder()
                .id(event.getId())
                .nome(event.getNome())
                .build());
    }
}

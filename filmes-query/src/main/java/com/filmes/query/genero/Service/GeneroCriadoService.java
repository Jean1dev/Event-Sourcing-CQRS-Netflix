package com.filmes.query.genero.Service;

import com.filmes.query.genero.amqp.events.GeneroCriadoEvent;
import com.filmes.query.genero.domain.Genero;
import com.filmes.query.genero.domain.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroCriadoService {

    @Autowired
    private GeneroRepository repository;

    public void executar(GeneroCriadoEvent event) {
        repository.save(Genero.builder()
                .id(event.getId())
                .titulo(event.getTitulo())
                .build());
    }
}

package com.filmes.core.filme.application;

import com.filmes.core.filme.application.commands.AdicionarUrlCommand;
import com.filmes.core.filme.application.commands.CriarFilmeCommand;
import com.filmes.core.filme.domain.Filme;
import com.filmes.core.filme.domain.repository.FilmeRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.filmes.core.config.AMQPConstants.FILME_QUEUE;

@Service
public class FilmeApplicationService {

    @Autowired
    private FilmeRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String criarFilme(CriarFilmeCommand command) {
        Filme filme = repository.save(Filme.builder()
                .dataLancamento(command.getDataLancamento())
                .duracao(command.getDuracao())
                .elenco(command.getElenco())
                .generos(command.getGeneros())
                .like(command.getLike())
                .subtitulo(command.getSubtitulo())
                .titulo(command.getTitulo())
                .build());

        rabbitTemplate.convertAndSend(FILME_QUEUE, filme);
        return filme.getId();
    }

    public void adicionarUrlDoFilme(AdicionarUrlCommand command) {
        Filme filme = repository.findById(command.getFilmeId()).orElseThrow();
        filme.setFilmeURL(command.getURL());
        repository.save(filme);

        rabbitTemplate.convertAndSend(FILME_QUEUE, filme);
    }
}

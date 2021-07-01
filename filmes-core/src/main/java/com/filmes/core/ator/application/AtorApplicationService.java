package com.filmes.core.ator.application;

import com.filmes.core.ator.application.commands.CriarAtorCommand;
import com.filmes.core.ator.domain.Ator;
import com.filmes.core.ator.domain.repository.AtorRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.filmes.core.config.AMQPConstants.ATOR_QUEUE;

@Service
public class AtorApplicationService {

    @Autowired
    private AtorRepository repository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String criarAtor(CriarAtorCommand command) {
        Ator ator = repository.save(Ator.builder()
                .nome(command.getNome())
                .build());

        rabbitTemplate.convertAndSend(ATOR_QUEUE, ator);
        return ator.getId();
    }
}

package com.filmes.query.filme.amqp;

import com.filmes.query.filme.amqp.events.FilmeCriadoEvent;
import com.filmes.query.filme.service.FilmeCriadoService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilmeListener {

    @Autowired
    private FilmeCriadoService filmeCriadoService;

    @RabbitListener(queues = "filme_qu")
    public void onListener(FilmeCriadoEvent message) {
        try {
            filmeCriadoService.executar(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}

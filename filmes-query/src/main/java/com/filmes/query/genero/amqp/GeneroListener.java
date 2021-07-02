package com.filmes.query.genero.amqp;

import com.filmes.query.genero.Service.GeneroCriadoService;
import com.filmes.query.genero.amqp.events.GeneroCriadoEvent;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GeneroListener {

    @Autowired
    private GeneroCriadoService generoCriadoService;

    @RabbitListener(queues = "genero_qu")
    public void onListener(GeneroCriadoEvent message) {
        try {
            generoCriadoService.executar(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}

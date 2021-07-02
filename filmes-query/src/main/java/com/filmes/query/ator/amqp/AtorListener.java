package com.filmes.query.ator.amqp;

import com.filmes.query.ator.amqp.event.AtorCriadoEvent.AtorCriadoEvent;
import com.filmes.query.ator.service.AtorCriadoService;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtorListener {

    @Autowired
    private AtorCriadoService atorCriadoService;

    @RabbitListener(queues = "ator_qu")
    public void onListener(AtorCriadoEvent message) {
        try {
            atorCriadoService.executar(message);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AmqpRejectAndDontRequeueException(e);
        }
    }
}

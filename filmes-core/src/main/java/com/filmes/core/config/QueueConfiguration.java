package com.filmes.core.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.filmes.core.config.AMQPConstants.*;

@Configuration
public class QueueConfiguration {

    private static final String EXCHANGE_NAME = "NETFLIX_EXCHANGE";

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue atorQ() {
        return new Queue(ATOR_QUEUE, true, false, false);
    }

    @Bean
    public Queue generoQ() {
        return new Queue(GENERO_QUEUE, true, false, false);
    }

    @Bean
    public Queue filmeQ() {
        return new Queue(FILME_QUEUE, true, false, false);
    }

    @Bean
    public Binding ator(DirectExchange exchange) {
        return BindingBuilder.bind(atorQ())
                .to(exchange)
                .with(ATOR_QUEUE);
    }

    @Bean
    public Binding genero(DirectExchange exchange) {
        return BindingBuilder.bind(generoQ())
                .to(exchange)
                .with(GENERO_QUEUE);
    }

    @Bean
    public Binding filme(DirectExchange exchange) {
        return BindingBuilder.bind(filmeQ())
                .to(exchange)
                .with(FILME_QUEUE);
    }
}

package com.filmes.query.genero.amqp.events;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GeneroCriadoEvent {

    private String id;

    private String titulo;
}

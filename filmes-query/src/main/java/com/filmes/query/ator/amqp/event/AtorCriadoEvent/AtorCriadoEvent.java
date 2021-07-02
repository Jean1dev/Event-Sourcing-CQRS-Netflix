package com.filmes.query.ator.amqp.event.AtorCriadoEvent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AtorCriadoEvent {

    private String id;

    private String nome;
}

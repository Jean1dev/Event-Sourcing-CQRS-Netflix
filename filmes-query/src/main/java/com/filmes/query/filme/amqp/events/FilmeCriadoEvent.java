package com.filmes.query.filme.amqp.events;

import com.filmes.query.ator.domain.Ator;
import com.filmes.query.genero.domain.Genero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeCriadoEvent {

    private String id;

    private String titulo;

    private String subtitulo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;

    private Duration duracao;

    private Boolean like;

    private String filmeURL;

    private Collection<String> generos;

    private Collection<String> elenco;
}

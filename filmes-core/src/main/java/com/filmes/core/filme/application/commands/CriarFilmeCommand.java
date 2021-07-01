package com.filmes.core.filme.application.commands;

import lombok.Builder;
import lombok.Getter;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;

@Builder
@Getter
public class CriarFilmeCommand {

    private String titulo;

    private String subtitulo;

    private LocalDate dataLancamento;

    private Duration duracao;

    private Collection<String> generos;

    private Collection<String> elenco;

    private Boolean like;
}

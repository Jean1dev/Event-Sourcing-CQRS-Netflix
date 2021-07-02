package com.filmes.query.filme.api.dto;

import com.filmes.query.ator.domain.Ator;
import com.filmes.query.filme.domain.Filme;
import com.filmes.query.genero.domain.Genero;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Getter
public class FilmeDto {

    private String id;

    private String titulo;

    private String subtitulo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataLancamento;

    private Duration duracao;

    private Boolean isLike;

    private Set<String> generos;

    private Set<String> atores;

    public static Page<FilmeDto> pageToDto(Page<Filme> filmesPage) {
        List<FilmeDto> filmeDtos = listToDto(filmesPage.getContent());
        return new PageImpl<>(filmeDtos, filmesPage.getPageable(), filmeDtos.size());
    }

    public static List<FilmeDto> listToDto(List<Filme> filmes) {
        return filmes.stream().map(FilmeDto::toDto).collect(Collectors.toList());
    }

    public static FilmeDto toDto(Filme filme) {
        return FilmeDto.builder()
                .id(filme.getId())
                .titulo(filme.getTitulo())
                .subtitulo(filme.getSubtitulo())
                .dataLancamento(filme.getDataLancamento())
                .duracao(filme.getDuracao())
                .isLike(filme.getIsLike())
                .generos(filme.getGeneros().stream().map(Genero::getTitulo).collect(Collectors.toSet()))
                .atores(filme.getAtores().stream().map(Ator::getNome).collect(Collectors.toSet()))
                .build();
    }
}

package com.filmes.query.filme.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filmes.query.ator.domain.Ator;
import com.filmes.query.genero.domain.Genero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "filme")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    private String id;

    private String titulo;

    private String subtitulo;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "data_lancamento")
    private LocalDate dataLancamento;

    private Duration duracao;

    @Column(name = "is_like")
    private Boolean isLike;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filme", cascade = CascadeType.ALL)
    private Set<Genero> generos;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "filme", cascade = CascadeType.ALL)
    private Set<Ator> atores;
}

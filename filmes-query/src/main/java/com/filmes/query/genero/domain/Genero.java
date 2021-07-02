package com.filmes.query.genero.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filmes.query.filme.domain.Filme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "genero")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Genero {

    @Id
    private String id;

    @NotEmpty
    private String titulo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filme_id", referencedColumnName = "id")
    private Filme filme;
}

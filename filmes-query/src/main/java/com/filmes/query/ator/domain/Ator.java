package com.filmes.query.ator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filmes.query.filme.domain.Filme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ator")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ator {

    @Id
    private String id;

    private String nome;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filme_id", referencedColumnName = "id")
    private Filme filme;
}

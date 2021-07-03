package com.filmes.core.filme.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;

@Document(collation = "filmes")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    @Id
    private String id;

    @NotEmpty
    private String titulo;

    private String subtitulo;

    @NotNull
    private LocalDate dataLancamento;

    private Duration duracao;

    private String filmeURL;

    private Collection<String> generos;

    private Collection<String> elenco;

    private Boolean like;
}

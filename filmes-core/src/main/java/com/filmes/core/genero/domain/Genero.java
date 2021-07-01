package com.filmes.core.genero.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Document(collation = "generos")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Genero {

    @Id
    private String id;

    @NotEmpty
    private String titulo;
}

package com.filmes.core.filme.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AdicionarUrlDto {

    private String filmeId;

    private String url;
}

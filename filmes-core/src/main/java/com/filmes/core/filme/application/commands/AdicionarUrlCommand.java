package com.filmes.core.filme.application.commands;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AdicionarUrlCommand {

    private String filmeId;

    private String URL;
}

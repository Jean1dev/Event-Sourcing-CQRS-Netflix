CREATE TABLE public.ator (
    id VARCHAR(36) NOT NULL,
    nome VARCHAR NOT NULL,
    filme_id VARCHAR(36) NULL,
    CONSTRAINT "PK_ATOR_TABLE" PRIMARY KEY (id)
);

CREATE TABLE public.genero (
    id VARCHAR(36) NOT NULL,
    titulo VARCHAR NOT NULL,
    filme_id VARCHAR(36) NULL,
    CONSTRAINT "PK_GENERO_TABLE" PRIMARY KEY (id)
);

CREATE TABLE public.filme (
    id VARCHAR(36) NOT NULL,
    titulo VARCHAR NOT NULL,
    subtitulo VARCHAR NULL,
    data_lancamento DATE NOT NULL,
    duracao bigint NULL,
    is_like BOOL NULL,
    CONSTRAINT "PK_FILME_TABLE" PRIMARY KEY (id)
);

ALTER TABLE public.ator ADD CONSTRAINT fk_filme_id_ator FOREIGN KEY (filme_id) REFERENCES filme(id) ON UPDATE CASCADE ON DELETE SET NULL;
ALTER TABLE public.genero ADD CONSTRAINT fk_filme_id_genero FOREIGN KEY (filme_id) REFERENCES filme(id) ON UPDATE CASCADE ON DELETE SET NULL;
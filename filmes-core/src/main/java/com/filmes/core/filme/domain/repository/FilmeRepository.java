package com.filmes.core.filme.domain.repository;

import com.filmes.core.filme.domain.Filme;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilmeRepository extends MongoRepository<Filme, String> {
}

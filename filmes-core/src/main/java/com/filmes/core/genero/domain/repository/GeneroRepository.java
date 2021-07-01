package com.filmes.core.genero.domain.repository;

import com.filmes.core.genero.domain.Genero;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GeneroRepository extends MongoRepository<Genero, String> {
}

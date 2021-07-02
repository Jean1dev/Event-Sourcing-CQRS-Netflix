package com.filmes.query.genero.domain.repository;

import com.filmes.query.genero.domain.Genero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneroRepository extends JpaRepository<Genero, String> {
}

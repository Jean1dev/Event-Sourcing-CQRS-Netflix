package com.filmes.query.filme.domain.repository;

import com.filmes.query.filme.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepository extends JpaRepository<Filme, String> {
}

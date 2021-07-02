package com.filmes.query.filme.domain.repository;

import com.filmes.query.filme.domain.Filme;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FilmeRepository extends PagingAndSortingRepository<Filme, String>, JpaSpecificationExecutor<Filme> {
}

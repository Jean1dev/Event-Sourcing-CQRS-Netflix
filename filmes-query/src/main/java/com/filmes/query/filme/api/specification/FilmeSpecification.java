package com.filmes.query.filme.api.specification;

import com.filmes.query.filme.domain.Filme;
import org.springframework.data.jpa.domain.Specification;

public class FilmeSpecification {

    public static Specification<Filme> titulo(String titulo) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("titulo"), "%" + titulo + "%");
    }
}

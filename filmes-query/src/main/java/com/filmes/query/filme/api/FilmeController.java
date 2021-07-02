package com.filmes.query.filme.api;

import com.filmes.query.filme.api.dto.FilmeDto;
import com.filmes.query.filme.domain.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import static com.filmes.query.filme.api.dto.FilmeDto.pageToDto;
import static com.filmes.query.filme.api.dto.FilmeDto.toDto;
import static com.filmes.query.filme.api.specification.FilmeSpecification.titulo;

@RestController
@RequestMapping(path = "filme")
public class FilmeController {

    @Autowired
    private FilmeRepository repository;

    @GetMapping(path = "{id}")
    public FilmeDto findById(@PathVariable("id") String idFilme) {
        return toDto(repository.findById(idFilme).orElseThrow());
    }

    @GetMapping
    public Page<FilmeDto> findAll(@RequestParam(value = "page", defaultValue = "0", required = false) int page,
                                  @RequestParam(value = "size", defaultValue = "10", required = false) int size,
                                  @RequestParam(value = "titulo", defaultValue = "", required = false) String titulo) {
        return pageToDto(repository.findAll(Specification.where(titulo(titulo)), PageRequest.of(page, size)));
    }
}

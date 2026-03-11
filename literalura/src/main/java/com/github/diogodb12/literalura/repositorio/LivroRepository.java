package com.github.diogodb12.literalura.repositorio;

import com.github.diogodb12.literalura.modelo.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livro, Long> {

    Optional<Livro> findByTituloIgnoreCase(String titulo);

    List<Livro> findByIdioma(String idioma);

    long countByIdioma(String idioma);
}
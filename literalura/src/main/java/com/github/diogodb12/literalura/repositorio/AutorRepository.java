package com.github.diogodb12.literalura.repositorio;

import com.github.diogodb12.literalura.modelo.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(
            Integer ano1,
            Integer ano2
    );
}
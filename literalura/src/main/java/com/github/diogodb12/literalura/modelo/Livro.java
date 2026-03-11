package com.github.diogodb12.literalura.modelo;

import com.github.diogodb12.literalura.dto.DadosAutor;
import com.github.diogodb12.literalura.dto.DadosLivro;
import jakarta.persistence.*;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;
    private String idioma;
    private Integer downloads;

    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;

    public Livro() {}

    public Livro(DadosLivro dados) {

        this.titulo = dados.getTitulo();
        this.idioma = dados.getIdiomas().get(0);
        this.downloads = dados.getDownloads();

        if (!dados.getAutores().isEmpty()) {

            DadosAutor dadosAutor = dados.getAutores().get(0);

            this.autor = new Autor(
                    dadosAutor.getNome(),
                    dadosAutor.getAnoNascimento(),
                    dadosAutor.getAnoFalecimento()
            );
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIdioma() {
        return idioma;
    }

    public Integer getDownloads() {
        return downloads;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {

        String nomeAutor = (autor != null) ? autor.getNome() : "Autor desconhecido";

        return """
               -------- LIVRO --------
               Título: %s
               Autor: %s
               Idioma: %s
               Downloads: %d
               """.formatted(
                titulo,
                nomeAutor,
                idioma,
                downloads
        );
    }
}
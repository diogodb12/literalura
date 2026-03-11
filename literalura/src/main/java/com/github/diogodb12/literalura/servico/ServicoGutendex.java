package com.github.diogodb12.literalura.servico;

import com.github.diogodb12.literalura.cliente.ClienteHttp;
import com.github.diogodb12.literalura.dto.DadosLivro;
import com.github.diogodb12.literalura.dto.DadosResposta;
import org.springframework.stereotype.Service;

@Service
public class ServicoGutendex {

    private final String URL_BASE = "https://gutendex.com/books/?search=";

    private ClienteHttp clienteHttp = new ClienteHttp();
    private ConversorDados conversor = new ConversorDados();

    public DadosLivro buscarLivro(String titulo) {

        try {

            String endereco = URL_BASE + titulo.replace(" ", "%20");

            String json = clienteHttp.buscarDados(endereco);

            DadosResposta resposta =
                    conversor.obterDados(json, DadosResposta.class);

            if (resposta.getResultados().isEmpty()) {
                return null;
            }

            return resposta.getResultados().get(0);

        } catch (Exception e) {
            System.out.println("Erro ao buscar livro na API.");
            return null;
        }
    }
}
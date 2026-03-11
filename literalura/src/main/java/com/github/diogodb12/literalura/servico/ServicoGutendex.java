package com.github.diogodb12.literalura.servico;

import com.github.diogodb12.literalura.cliente.ClienteHttp;
import com.github.diogodb12.literalura.modelo.DadosResposta;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ServicoGutendex {

    private final ClienteHttp clienteHttp;
    private final ConversorDados conversor = new ConversorDados();

    public ServicoGutendex() {
        this.clienteHttp = new ClienteHttp();
    }

    public DadosResposta buscarLivro(String titulo) throws Exception {

        String endereco = "https://gutendex.com/books/?search=" + titulo.replace(" ", "%20");

        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .GET()
                .build();

        HttpResponse<String> resposta = clienteHttp
                .getCliente()
                .send(requisicao, HttpResponse.BodyHandlers.ofString());

        return conversor.obterDados(resposta.body(), DadosResposta.class);
    }
}
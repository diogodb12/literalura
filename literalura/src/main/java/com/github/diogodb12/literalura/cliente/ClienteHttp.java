package com.github.diogodb12.literalura.cliente;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteHttp {

    private HttpClient cliente;

    public ClienteHttp() {
        this.cliente = HttpClient.newHttpClient();
    }

    public String buscarDados(String endereco) throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .GET()
                .build();

        HttpResponse<String> response =
                cliente.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
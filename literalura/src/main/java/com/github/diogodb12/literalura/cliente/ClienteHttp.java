package com.github.diogodb12.literalura.cliente;

import java.net.http.HttpClient;

public class ClienteHttp {
    private final HttpClient cliente;

    public ClienteHttp() {
        this.cliente = HttpClient.newHttpClient();
    }

    public HttpClient obterCliente() {
        return cliente;
    }

    public HttpClient getCliente() {
        return null;
    }
}

package com.github.diogodb12.literalura.servico;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConversorDados {

    private final ObjectMapper mapper = new ObjectMapper();

    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
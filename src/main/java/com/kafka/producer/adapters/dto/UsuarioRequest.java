package com.kafka.producer.adapters.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class UsuarioRequest {

    @NotBlank
    @Size(max = 100)
    private String nome;
    @Positive
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public Integer getIdade() {
        return idade;
    }
}

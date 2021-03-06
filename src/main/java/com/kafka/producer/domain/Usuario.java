package com.kafka.producer.domain;

import java.util.UUID;

public class Usuario {

    private String id;
    private String nome;
    private Integer idade;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public void gerarId(){
        this.id = UUID.randomUUID().toString();
    }

}

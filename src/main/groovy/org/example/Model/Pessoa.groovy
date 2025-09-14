package org.example.Model

abstract class Pessoa {
    int id
    String nome
    String email
    String cep
    String estado
    String descricao


    Pessoa(String nome, String email, String cep, String estado, String descricao) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.descricao = descricao
    }
    def curtidas(){}
}

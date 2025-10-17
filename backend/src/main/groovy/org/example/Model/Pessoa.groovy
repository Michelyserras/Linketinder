package org.example.Model

abstract class Pessoa {
    int id
    String nome
    String email
    String cep
    String estado
    String descricao
    String senha

    Pessoa(){}
    Pessoa(String nome, String email, String cep, String estado, String descricao, String senha) {
        this.nome = nome
        this.email = email
        this.cep = cep
        this.estado = estado
        this.descricao = descricao
        this.senha = senha
    }

    def curtidas(){}


}

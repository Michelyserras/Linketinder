package org.example.Model

class Competencia {
    Integer id
    String nome

    Competencia(String nome){
        if (!validacao(nome)) {
            throw new IllegalArgumentException("Nome inválido para Competência")
        }
        this.nome = nome.trim()
    }

    boolean validacao(String nome) {
        def n = nome?.trim() ?: ''
        if (n.isEmpty() || n.length() > 50 || n.length() < 2) {
            System.out.println("O campo nome deve ter entre 2 e 50 caracteres.");
            return false
        }
        return true
    }


    @Override
    String toString() {
        return "\t ${id} - ${nome}"
    }
}

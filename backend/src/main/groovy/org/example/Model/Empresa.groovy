package org.example.Model

class Empresa extends Pessoa {
    static int count = 0
    String cnpj
    String pais
    List<Vaga> vagas = []

    Empresa(String nome, String cnpj, String estado, String cep, String pais, String descricao, String email, String senha,List<Vaga> vagas) {
        super(nome, email, cep, estado, descricao, senha)
        this.cnpj = cnpj
        this.pais = pais
        this.vagas = vagas
    }

    Empresa() {}

    @Override
    def curtidas(){
        return 0
    }

    @Override
    String toString() {
        return """Empresa:\t
                Id: $id  
                Nome: $nome 
                Email: $email 
                Cep: $cep 
                Estado: $estado
                Descricao: $descricao 
                CNPJ: $cnpj 
                Pais: $pais
                Competencias: $competencias"""
    }
}

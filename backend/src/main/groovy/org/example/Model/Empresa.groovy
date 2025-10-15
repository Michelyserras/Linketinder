package org.example.Model

class Empresa extends Pessoa {
    static int count = 0
    String cnpj
    String pais
    List<Vaga> vagas = new ArrayList<>()

    Empresa(String nome, String email, String cep, String estado, String descricao, String senha,  String cnpj, String pais, List<Vaga> vagas) {
        super(nome, email, cep, estado, descricao, senha)
        this.setId(count += 1);
        this.cnpj = cnpj
        this.pais = pais
        this.vagas = vagas
    }

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

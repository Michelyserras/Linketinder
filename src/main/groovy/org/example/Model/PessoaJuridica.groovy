package org.example.Model

class PessoaJuridica extends Pessoa {
    static int count = 0
    String cnpj
    String pais
    List<String> competencias = new ArrayList<>()

    PessoaJuridica(String nome, String email, String cep, String estado, String descricao, String cnpj, String pais, List<String> competencias) {
        super(nome, email, cep, estado, descricao)
        this.setId(count += 1);
        this.cnpj = cnpj
        this.pais = pais
        this.competencias = competencias
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

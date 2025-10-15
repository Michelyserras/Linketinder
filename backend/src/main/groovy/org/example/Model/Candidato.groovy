package org.example.Model

class Candidato extends Pessoa{
    static int count = 0
    String sobrenome
    String cpf
    String pais
    int idade
    List<Competencia> competencias = new ArrayList<>()


    Candidato(String nome, String sobrenome, String cpf, int idade, String estado, String cep, String pais, String descricao, String email, String senha, List<String> competencias) {
        super(nome, email, cep, estado, descricao, senha)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.idade = idade
        this.competencias = competencias
    }

    Candidato() {}


    @Override
    def curtidas(){
        return 0
    }

    @Override
    String toString() {
        return """Candidato: \t
                Id: $id 
                Nome: $nome
                Email: $email
                Cep: $cep 
                Estado: $estado
                Descricao: $descricao
                CPF: $cpf
                Idade: $idade
                Competencias: $competencias"""

    }
}

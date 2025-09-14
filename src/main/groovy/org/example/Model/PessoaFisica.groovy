package org.example.Model

class PessoaFisica extends Pessoa{
    static int count = 0
    String cpf
    int idade
    List<String> competencias = new ArrayList<>()


    PessoaFisica(String nome, String email, String cep, String estado, String descricao, String cpf, int idade, List<String> competencias) {
        super(nome, email, cep, estado, descricao)
        this.setId(count += 1);
        this.cpf = cpf
        this.idade = idade
        this.competencias = competencias
    }



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

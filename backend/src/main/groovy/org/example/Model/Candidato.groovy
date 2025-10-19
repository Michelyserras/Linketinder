package org.example.Model

class Candidato extends Pessoa{
    String sobrenome
    String cpf
    String pais
    int idade
    List<Competencia> competencias = new ArrayList<>()


    Candidato(String nome, String sobrenome, String cpf, int idade, String estado, String cep, String pais, String descricao, String email, String senha) {
        super(nome, email, cep, estado, descricao, senha)
        this.cpf = cpf
        this.sobrenome = sobrenome
        this.pais = pais
        this.idade = idade

    }


    Candidato() {}

    List<Competencia> getCompetencias(){
        return competencias
    }



    boolean validacao() {
            nome = (nome ?: '').trim()
            if (nome.isEmpty() || nome.length() > 40 || nome.length() < 2) {
                System.out.println("O campo nome deve ter entre 2 e 40 caracteres.");
                return false
            }

            sobrenome = (sobrenome ?: '').trim()
            if (sobrenome.isEmpty() || sobrenome.length() > 120 || sobrenome.length() < 2) {
                System.out.println("O campo sobrenome deve ter entre 2 e 120 caracteres.");
                return false
            }


            cpf = (cpf ?: '').trim()
            if (cpf.length() != 11) {
                System.out.println("O campo CPF deve conter exatamente 11 dígitos.");
                return false
            }
            for (int i = 0; i < cpf.length(); i++) {
                if (!Character.isDigit(cpf.charAt(i))) {
                    System.out.println("O campo CPF deve conter apenas números.");
                    return false
                }
            }


            if (idade < 0 || idade > 99) {
                System.out.println("O campo idade deve estar entre 0 e 99.");
                return false
            }


            estado = (estado ?: '').trim().toUpperCase()
            if (estado.length() != 2) {
                System.out.println("O campo estado deve ter exatamente 2 letras (UF).");
                return false
            }
            for (int i = 0; i < estado.length(); i++) {
                if (!Character.isLetter(estado.charAt(i))) {
                    System.out.println("O campo estado deve conter apenas letras.");
                    return false
                }
            }


            cep = (cep ?: '').trim()
            if (cep.length() != 8) {
                System.out.println("O campo CEP deve conter exatamente 8 dígitos.");
                return false
            }
            for (int i = 0; i < cep.length(); i++) {
                if (!Character.isDigit(cep.charAt(i))) {
                    System.out.println("O campo CEP deve conter apenas números.");
                    return false
                }
            }


            pais = (pais ?: '').trim()
            if (pais.isEmpty() || pais.length() < 1) {
                System.out.println("O campo país deve ter mais que 1 caracter e não pode estar vazio.");
                return false
            }


            descricao = (descricao ?: '').trim()
            if (descricao.isEmpty()) {
                System.out.println("O campo descrição não pode estar vazio.");
                return false
            }

            email = (email ?: '').trim()
            if (email.isEmpty() || email.length() > 100 || !email.contains("@") || !email.contains(".")) {
                System.out.println("O campo email deve conter um endereço de e-mail válido.");
                return false
            }

            senha = (senha ?: '').trim()
            if (senha.length() < 6 || senha.length() > 30) {
                System.out.println("A senha deve ter entre 6 e 30 caracteres.");
                return false
            }

            return true
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
                Senha: $senha
                Cep: $cep 
                Estado: $estado
                Pais: $pais
                Descricao: $descricao
                CPF: $cpf
                Idade: $idade
                Competencias: ${competencias ? competencias.join(', ') : "nenhuma competência"} """

    }
}

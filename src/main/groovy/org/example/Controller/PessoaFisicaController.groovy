package org.example.Controller

import org.example.Model.PessoaFisica

class PessoaFisicaController {
    static  List<PessoaFisica> candidatos = []

    public PessoaFisicaController(){
        inicializarCandidatos()
    }

   void cadastrarPessoaFisica(PessoaFisica pf){
        if( pf.nome.trim().isEmpty() || pf.email.trim().isEmpty() ||  pf.cpf.trim().isEmpty() || pf.idade <= 0
        || pf.cep.trim().isEmpty() || pf.estado.trim().isEmpty() || pf.descricao.trim().isEmpty()){
            throw new Exception("Todos os campos devem ser preenchidos corretamente.")
        }
        candidatos.add(pf)
    }

    void listarPessoaFisica() {
        if (candidatos.isEmpty()){
            throw new Exception("Nenhum candidato cadastrado.")
        } else{
          for(PessoaFisica pf : candidatos){
              println ""
              println pf.toString()
              println "==============================================="
          }
        }
    }

    void inicializarCandidatos(){
        candidatos.add(new PessoaFisica("Alice", "alice@email.com", "SP", "12345-678", "Apaixonada por tecnologia", "12345678901", 25, ["Java", "Python"]))
        candidatos.add(new PessoaFisica("Bruno", "bruno@email.com", "RJ", "23456-789", "Desenvolvedor fullstack", "23456789012", 30, ["Angular", "Spring Framework"]))
        candidatos.add(new PessoaFisica("Carla", "carla@email.com", "MG", "34567-890", "Engenheira de dados", "34567890123", 28, ["Python", "SQL"]))
        candidatos.add(new PessoaFisica("Daniel", "daniel@email.com", "RS", "45678-901", "Especialista em frontend", "45678901234", 35, ["Angular", "React"]))
        candidatos.add(new PessoaFisica("Elena", "elena@email.com", "BA", "56789-012", "Analista de sistemas", "56789012345", 22, ["Java", "Spring Boot"]))
    }

}

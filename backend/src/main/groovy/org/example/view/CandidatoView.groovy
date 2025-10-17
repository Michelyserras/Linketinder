package org.example.view

import org.example.Controller.CandidatoController
import org.example.Model.Candidato

class CandidatoView {
    private CandidatoController candidatoController = new CandidatoController()()
    static scanner = new Scanner(System.in)


    void menuCandidato() {
        Scanner scanner = new Scanner(System.in)

        while (true) {
            println """
        1 - Cadastrar Candidato
        2 - Listar Candidatos
        3 - Voltar
        """

            print "Escolha uma opcao: "
            def input = scanner.nextLine().trim()
            int opcao = -1
            try {
                opcao = input.toInteger()
            } catch (Exception e) {
                println "Entrada inválida! Digite um número de 1 a 3."
                continue
            }

            switch (opcao) {
                case 1:
                    limpaTela()
                    cadastrarCandidato()
                    break
                case 2:
//                    limpaTela()
//                    listarCandidatos()
                    break
                case 3:
                    limpaTela()
                    return
                default:
                    println "Opcao invalida! Digite 1, 2 ou 3."
            }
        }
    }


    void cadastrarCandidato(){
        String nome, descricao, cpf, email,  cep, estado
        int idade
        List<String> competencias = new ArrayList<>()

        println "Digite o nome: "
        nome = scanner.nextLine()
        println "Digite o email: "
        email = scanner.nextLine()
        println "Digite o cep: "
        cep = scanner.nextLine()
        println "Digite o estado: "
        estado = scanner.nextLine()
        println "Digite a descricao: "
        descricao = scanner.nextLine()
        println "Digite o cpf: "
        cpf = scanner.nextLine()
        println "Digite a idade: "
        idade = Integer.parseInt(scanner.nextLine())
        for(int i = 0; i < 3; i++){
            println "Digite a competencia ${i+1}: "
            String competencia = scanner.nextLine()
            competencias.add(competencia)
        }

        try {
             Candidatocandidato = new Candidato(nome, email, cep, estado, descricao, cpf, idade, competencias)
            candidatoController.cadastra Candidato(candidato)
            println "Candidato cadastrado com sucesso!"
        } catch (Exception e) {
            println "Erro ao cadastrar candidato: ${e.message}"
        }
    }

    void listarCandidatos(){
        try {
            candidatoController.lista Candidato()
        } catch (Exception e) {
            println "Erro ao listar candidatos: ${e.message}"
        }
    }

    void limpaTela(){
        for(int i = 0; i < 50; i++){
            println ""
        }
    }

}

package org.example.view

import org.example.Controller.CandidatoController
import org.example.Controller.CompetenciaController
import org.example.Model.Candidato

class CandidatoView {
    CandidatoController candidatoController = new CandidatoController()
    CompetenciaController competenciaController = new CompetenciaController()
    CompetenciaView competenciaView = new CompetenciaView()
    static scanner = new Scanner(System.in)

//    CandidatoView(CandidatoController candidatoController, CompetenciaController competenciaController){
//        this.candidatoController = candidatoController
//        this.competenciaController = competenciaController
//    }
//


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
                     limpaTela()
                     listarCandidatos()
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
        String nome, descricao, cpf, email,  cep, estado, senha, sobrenome, pais
        int idade


        println "Digite o nome: "
        nome = scanner.nextLine()
        println "Digite o sobrenome: "
        sobrenome = scanner.nextLine()
        println "Digite o email: "
        email = scanner.nextLine()
        println "Digite a senha: "
        senha = scanner.nextLine()
        println "Digite o pais: "
        pais = scanner.nextLine()
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

    Candidato candidato = new Candidato()

    candidato.setNome(nome)
        candidato.setSobrenome(sobrenome)
        candidato.setEmail(email)
        candidato.setSenha(senha)
        candidato.setPais(pais)
        candidato.setIdade(idade)
        candidato.setCep(cep)
        candidato.setEstado(estado)
        candidato.setDescricao(descricao)
        candidato.setCpf(cpf)

        try {
            def c = candidatoController.cadastrarCandidato(candidato)
            if (c == null) {
                println "Erro ao cadastrar candidato: retorno nulo"
                return
            }


            def competencias = competenciaView.escolherCompetencia(c.getId())
            if (competencias != null) {
                competencias.forEach { comp ->
                    competenciaController.adicionarCompetenciaAoCandidato(c.id, comp.id)
                }
            }

            println "Candidato cadastrado com sucesso!"
        } catch (Exception e) {
            println "Erro ao cadastrar candidato: ${e.message}"
        }
    }

    void listarCandidatos(){
        try {
            candidatoController.listarCandidatos()
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

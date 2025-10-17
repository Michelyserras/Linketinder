package org.example.view

import org.example.Controller.CandidatoController
import org.example.Controller.CompetenciaController
import org.example.DAO.CompetenciasDAO
import org.example.Model.Competencia

class CompetenciaView {
    private CompetenciaController competenciaController = new CompetenciaController()
    static scanner = new Scanner(System.in)

    def adicionarNovaCompetencia(){
        while(true){
            println "======== CADASTRO COMPETENCIAS ======== \n"
            println "Informe um nome: "
            def nome = scanner.nextLine()

            println "Deseja continuar? (S/N)"
            def res = scanner.nextLine().toLowerCase()
            if(res != "s"){
                break
            }

            Competencia competencia = new Competencia(nome)
            try {
                competenciaController.cadastrarNovaCompetencia(competencia)
                println "Pessoa Juridica cadastrada com sucesso!"
            } catch (Exception e) {
                println "Erro ao cadastrar Pessoa Juridica: ${e.message}"
            }
        }
    }

    def escolherCompetencia(int idCandidato) {
        def competencias = competenciaController.listarCompetencias()
        def competenciasEscolhidas = []

        if (competencias == null || competencias.isEmpty()) {
            println(" Nenhuma competência disponível no sistema.")
            return []
        }

        while (true) {
            println("\n============================================")
            println("Competências disponíveis:")
            println("\t ID NOME")
            competencias.each { comp ->
                println(comp)
            }

            print("\nInforme o ID da competência que deseja adicionar (ou 'sair' para encerrar): ")
            def input = scanner.nextLine().trim()

            if (input.equalsIgnoreCase("sair")) break


            if (!input.isInteger()) {
                println(" Por favor, digite um número válido ou 'sair' para encerrar.")
                continue
            }

            def idComp = input.toInteger()
            def competencia = competenciaController.buscarCompetencia(idComp)

            if (!competencia) {
                println(" Nenhuma competência encontrada com o ID informado.")
                continue
            }

            try {
                println("Competência adicionada ao candidato!")
                competenciasEscolhidas.add(competencia)
            } catch (Exception e) {
                println("Erro ao adicionar competência: ${e.message}")
            }

            print("\nDeseja adicionar outra competência? (S/N): ")
            def continuar = scanner.nextLine().trim().toLowerCase()
            if (continuar != "s") break
        }

        return competenciasEscolhidas
    }
}

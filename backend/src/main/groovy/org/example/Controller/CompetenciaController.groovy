package org.example.Controller

import org.example.Model.Competencia
import org.example.Service.CompetenciaService

class CompetenciaController {
    CompetenciaService competenciaService = new CompetenciaService()

    def cadastrarNovaCompetencia(Competencia competencia){
            try {
                competenciaService.cadastrarCompetencia(competencia)
                println("Competência cadastrada com sucesso!")
                return true
            } catch (Exception e) {
                println("Erro ao cadastrar competência: ${e.message}")
                return false
            }
        }

    List<Competencia> listarCompetencias(){
        try{
            competenciaService.listarCompetencias()
        }catch (Exception e){
            println("Erro ao listar competencias: ${e.getMessage()}")
        }

    }

    boolean buscarCompetencia(int id){
        try{
            competenciaService.buscarPorId(id)
        }catch (Exception e){
            println("${e.getMessage()}")
        }
    }

    def adicionarCompetenciaAoCandidato(idCandidato, idComp) {
        try {
            competenciaService.adicionarCompetenciaAoCandidato(idCandidato, idComp)
        } catch (Exception e) {
            println("${e.getMessage()}")
        }
    }
}
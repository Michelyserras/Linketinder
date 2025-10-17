package org.example.Service

import groovy.transform.Undefined.EXCEPTION
import org.example.DAO.CompetenciasDAO
import org.example.Model.Candidato
import org.example.Model.Competencia

import java.sql.SQLException

class CompetenciaService {
    CompetenciasDAO competenciaDao = new CompetenciasDAO()


    def cadastrarCompetencia(Competencia competencia) {
        if (!competencia) {
            println("Os campos são obrigatórios")
            return null
        }

        if (!competencia.validacao()) {
            println "Erro ao cadastrar candidato"
            return null
        }

        try {
            competenciaDao.criarCompetencia(competencia)
        } catch (Exception e) {
            println "Erro: ${e.getMessage()}"
        }
    }

    def cadastrarCompetenciaCandidato(Integer idCandidato, Integer idCompetencia) {

        if (!idCandidato && idCompetencia) {
            println("Todos os campos são obrigatórios")
            return null
        }

        if (!(idCandidato instanceof Integer) && !(idCompetencia instanceof Integer)) {
            println("Os campos devem ser numéricos")
            return null
        }

        try {
            competenciaDao.adicionarCompetenciasCandidato(idCandidato, idCompetencia)
        } catch (Exception e) {
            println("${e.getMessage()}")
        }
    }

    List<Competencia> listarCompetencias() {
        try {
            def competencias = competenciaDao.listarTodasCompetencias()

            if (competencias.isEmpty()) {
                throw new Exception("Nenhuma competencia cadastrada.")
            } else {
                competencias.each { comp ->
                    println comp.toString()
                }

            }
        return competencias
        }catch (Exception e ) {
            println "${e.getMessage()}"
        }
    }

    boolean buscarPorId(int id){
        if(!id){
            println("É obrigatório informar um id")
        }
        if(!(id instanceof Integer)){
            println("Por favor informe um valor numérico")
        }

        try{
            def competencia = competenciaDao.buscarCompetenciaPorID(id)
            return competencia != null
        }catch (Exception e ) {
            println "${e.getMessage()}"
        }
    }

    def adicionarCompetenciaAoCandidato(int idCandidato, int idComp){
        if(!idCandidato || !idComp){
            println("Todos os campos são obrigatórios")
        }
        if(!(idCandidato instanceof Integer) || !(idComp instanceof Integer)){
            println("Infome um valor numérico")
        }

        try{
            competenciaDao.adicionarCompetenciasCandidato(idCandidato, idComp)
        }catch(Exception e){
            println("${e.getMessage()}")
        }
    }

}

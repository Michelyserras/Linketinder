package org.example.Service

import org.example.DAO.CandidatoDAO
import org.example.Model.Candidato

class CandidatoService {
    CandidatoDAO candidatoDAO

    def cadastrarCandidato(Candidato candidato){

        if(!candidato){
            println("Todos os campos são obrigatórios")
            return
        }
        if(!candidato.validacao()){
            println "Erro ao cadastrar candidato"
            return
        }
        try{
           return candidatoDAO.criarCandidato(candidato)
        }catch(Exception e){
            println "Erro: ${e.getStackTrace()}"
        }
    }

    List<Candidato> listarCandidato() {
        try{
            def candidatos = candidatoDAO.listarCandidatos()

            if (candidatos.isEmpty()){
                throw new Exception("Nenhum candidato cadastrado.")
            } else{
                candidatos.each {candidato ->
                    println ""
                    println candidato.toString()
                    println ""
                }
            }
            return candidatos
        }catch (Exception e){
            println "${e.getMessage()}"
        }

    }



}

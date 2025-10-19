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

    def atualizarCandidato(Integer id, Candidato candidato){
        if(!candidato){
            println("Todos os campos são obrigatórios")
            return
        }
        if(!candidato.validacao()){
            println "Erro ao cadastrar candidato"
            return
        }
        if(!id || id == null){
            println("Todos os campos são obrigatórios")
            return
        }
        if(!(id instanceof Integer)){
            println "Informe um valor numerico"
            return
        }

        try{
            return candidatoDAO.atualizarCandidato(id, candidato)
        }catch(Exception e){
            println "Erro: ${e.getStackTrace()}"
        }

    }

    def removerCandidato(Integer id){
        if(!id || id == null){
            println("Todos os campos são obrigatórios")
            return
        }
        if(!(id instanceof Integer)){
            println "Informe um valor numerico"
            return
        }
        def candidatoExiste = candidatoDAO.buscarCandidatoPorID(id)

        if(candidatoExiste){
            try{
                return candidatoDAO.removerCandidato(candidatoExiste.id)
            }catch(Exception e){
                println "Erro: ${e.getStackTrace()}"
            }
        }
        println("O candidato com o id: ${id} não existe")

    }

    def buscarCandidato(Integer id){
        if(!id || id == null){
            println("Todos os campos são obrigatórios")
            return
        }
        if(!(id instanceof Integer)){
            println "Informe um valor numerico"
            return
        }

        try{
            return candidatoDAO.buscarCandidatoPorID(id)
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

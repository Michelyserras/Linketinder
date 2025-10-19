package org.example.Controller

import org.example.Model.Candidato
import org.example.Service.CandidatoService


class CandidatoController {

    CandidatoService candidatoService = new CandidatoService(candidatoDAO: new org.example.DAO.CandidatoDAO())

    CandidatoController(){
        inicializarCandidatos()
    }

    def cadastrarCandidato(Candidato candidato){
        try{
           return candidatoService.cadastrarCandidato(candidato)
        }catch(Exception e){
            println("${e.getStackTrace()}")
            return null
        }

    }

    def atualizarCandidato(Integer id, Candidato candidato){
        try{
            candidatoService.atualizarCandidato(id, candidato)
        }catch(Exception e ){
            println("${e.getMessage()}")
        }
    }

    def removerCandidato(Integer id){
        try{
            return candidatoService.removerCandidato(id)
        }catch(Exception e){
            println "Erro: ${e.getStackTrace()}"
        }
    }

    def listarCandidatos() {
       try{
           candidatoService.listarCandidato()
       }catch(Exception e){
           println("${e.getMessage()}")
       }
    }

    def buscarCandidato(Integer id){
        try{
            candidatoService.buscarCandidato(id)
        }catch(Exception e){
            println("${e.getMessage()}")
        }
    }


    def inicializarCandidatos(){
        def candidatos = []
        candidatos.add(new Candidato("Alice","Silva", "12345678901",25, "SP", "12345678","Brasil",  "Apaixonada por tecnologia", "alice@email.com","1234567"))
        candidatos.add(new Candidato("Bruno", "Santos","23456789012", 30,  "RJ", "23456789", "Brasil", "Desenvolvedor fullstack",  "bruno@email.com", "40028922"))
        candidatos.add(new Candidato("Carla", "Oliveira", "34567890123", 28, "MG", "34567890", "Brasil",  "Engenheira de dados", "carla@email.com", "D152z656"))
        candidatos.add(new Candidato("Daniel","Santos",  "45678901234", 35, "RS", "45678901", "Brasil", "Especialista em frontend", "daniel@email.com", "Daniel12345"))
        candidatos.add(new Candidato("Elena", "Gilbert", "56789012345", 22, "BA", "56789012", "Brasil", "Analista de sistemas",  "elena@email.com", "theVampireDiaries1235"))

        candidatos.forEach{ c ->
            candidatoService.cadastrarCandidato(c)
        }
    }

}

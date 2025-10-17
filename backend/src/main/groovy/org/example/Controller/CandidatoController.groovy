package org.example.Controller

import org.example.Model.Candidato
import org.example.Service.CandidatoService


class CandidatoController {
    CandidatoService candidatoService

    public CandidatoController(){
        inicializarCandidatos()
    }

   void cadastrarCandidato(Candidato candidato){
        candidatoService.cadastrarCandidato(candidato)
    }

    void listarCandidato() {
        if (candidatos.isEmpty()){
            throw new Exception("Nenhum candidato cadastrado.")
        } else{
          for(Candidato pf : candidatos){
              println ""
              println pf.toString()
              println "==============================================="
          }
        }
    }

    void inicializarCandidatos(){
        candidatos.add(new Candidato("Alice", "alice@email.com", "SP", "12345-678", "Apaixonada por tecnologia", "12345678901", 25, ["Java", "Python"]))
        candidatos.add(new Candidato("Bruno", "bruno@email.com", "RJ", "23456-789", "Desenvolvedor fullstack", "23456789012", 30, ["Angular", "Spring Framework"]))
        candidatos.add(new Candidato("Carla", "carla@email.com", "MG", "34567-890", "Engenheira de dados", "34567890123", 28, ["Python", "SQL"]))
        candidatos.add(new Candidato("Daniel", "daniel@email.com", "RS", "45678-901", "Especialista em frontend", "45678901234", 35, ["Angular", "React"]))
        candidatos.add(new Candidato("Elena", "elena@email.com", "BA", "56789-012", "Analista de sistemas", "56789012345", 22, ["Java", "Spring Boot"]))
    }

}

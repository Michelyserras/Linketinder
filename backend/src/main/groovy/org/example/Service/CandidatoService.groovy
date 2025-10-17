package org.example.Service

import org.example.DAO.CandidatoDAO
import org.example.Model.Candidato

class CandidatoService {
    CandidatoDAO candidatoDAO

    def cadastrarCandidato(Candidato candidato){

        if(!candidato){
            println("Todos os campos são obrigatórios")
            return null;
        }
        if(!candidato.validacao()){
            println "Erro ao cadastrar candidato"
            return null
        }

        try{
            candidatoDAO.criarCandidato(candidato)
        }catch(Exception e){
            println "Erro: ${e.getMessage()}"
        }

    }


}

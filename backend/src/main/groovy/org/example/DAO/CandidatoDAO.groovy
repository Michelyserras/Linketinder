package org.example.DAO

import org.example.Model.Candidato
import org.example.Model.Competencia
import org.example.Model.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoDAO {

   final Connection conn = Database.getConnection();
    CompetenciasDAO competenciaDao = new CompetenciasDAO()

    Candidato criarCandidato(Candidato candidato){
        String query = ''' INSERT INTO CANDIDATO (nome, sobrenome, cpf, idade, estado, cep, pais, descricao, email, senha) VALUES (?, ?, ?,?,?,?,?,?,?,?); '''

        try{
             conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS).withCloseable {ps ->
                ps.setString(1, candidato.nome)
                ps.setString(2, candidato.sobrenome)
                ps.setString(3, candidato.cpf)
                ps.setInt(4, candidato.idade)
                ps.setString(5, candidato.estado)
                ps.setString(6, candidato.cep)
                ps.setString(7, candidato.pais)
                ps.setString(8, candidato.descricao)
                ps.setString(9, candidato.email)
                ps.setString(10, candidato.senha)


                ps.executeUpdate()
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) candidato.id = rs.getInt(1)

                print "Candidato: ${candidato.getNome()} adicionado com sucesso"

            }
            return candidato
        }catch (SQLException sql){
            println "Erro ao criar candidato: ${sql.getMessage()}"
            return null
        }
    }

    def removerCandidato(Candidato candidato){
        String query = ''' DELETE FROM candidato WHERE id = ?; '''
        try{
           conn.prepareStatement(query).withCloseable {ps ->
                ps.setInt(1, candidato.getId())
                ps.execute()
                println 'Candidato removido com sucesso'
            }
        }catch(SQLException sql){
            println "Erro ao remover candidato: ${sql.getMessage()}"
        }
    }

    def atualizarCandidato(Candidato candidato){
        String query = ''' UPDATE TABLE candidato SET nome = ?, sobrenome = ?, cpf = ?, idade = ?, estado = ?, cep = ?, pais = ?, descricao = ?, email = ?, senha = ?;'''

        try{
            conn.prepareStatement(query).withCloseable {ps->
                ps.setString(1, candidato.nome)
                ps.setString(2, candidato.sobrenome)
                ps.setString(3, candidato.cpf)
                ps.setInt(4, candidato.idade)
                ps.setString(5, candidato.estado)
                ps.setString(6, candidato.cep)
                ps.setString(7, candidato.pais)
                ps.setString(8, candidato.descricao)
                ps.setString(9, candidato.email)
                ps.setString(10, candidato.senha)

                ps.executeUpdate()

                println "Candidato atualizado com sucesso!"
            }
        }catch(SQLException sql){
            println "Erro ao atualizar candidato: ${sql.getMessage()} "
        }
    }


    List<Candidato> listarCandidatos(){
        String query = ''' SELECT * FROM candidato;'''
        def candidatos = []

        try{
            conn.prepareStatement(query).withCloseable {ps ->
              ResultSet rs = ps.executeQuery()
                   while (rs.next()){
                       List<Competencia> competencias = competenciaDao.listarCompetenciasCandidatos(rs.getInt("id"))
                       candidatos.add(new Candidato(
                              id: rs.getInt("id"),
                              nome: rs.getString("nome"),
                              sobrenome: rs.getString("sobrenome"),
                              cpf: rs.getString("cpf"),
                              idade: rs.getInt("idade"),
                              estado: rs.getString("estado"),
                              cep: rs.getString("cep"),
                              pais: rs.getString("pais"),
                              descricao: rs.getString("descricao"),
                              email: rs.getString("email"),
                              senha: rs.getString("senha"),
                              competencias: competencias
                       ))
                   }
                   return candidatos
            }
        }catch(SQLException sql){
            println "Erro ao listar candidatos: ${sql.getMessage()}"

        }
    }
}

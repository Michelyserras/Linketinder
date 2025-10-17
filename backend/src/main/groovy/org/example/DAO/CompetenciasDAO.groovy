package org.example.DAO

import org.example.Model.Competencia

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CompetenciasDAO {
    final Connection conn = Database.getConnection();;


    def criarCompetencia(Competencia competencia){
        String query = ''' INSERT INTO competencia(nome) values(?);'''

        try{
            conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS).withCloseable {ps ->
                ps.setString(1, nome)

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) competencia.id = rs.getInt(1)

                ps.executeUpdate()
                println "Competencia: ${competencia.getNome()} criada com sucesso"
            }
        }catch(SQLException sql){
            println "Erro ao criar competencia: ${sql.getMessage()}"
        }
    }

    def removerCompetencia(Competencia competencia){
        String query = ''' DELETE FROM competencia WHERE id = ?;'''

        try{
            conn.prepareStatement(query).withCloseable {ps->
                ps.setInt(1, competencia.id)
                ps.executeUpdate()

                println "Competencia removida com sucesso"
            }
        }catch(SQLException sql){
            println "Erro ao remover competencia: ${sql.getMessage()}"
        }
    }

    def atualizarCompetencia(Competencia competencia){
        String query  = '''UPDATE TABLE competencia SET nome = ?;'''

        try{
            conn.prepareStatement(query).withCloseable { ps ->
                ps.setString(1, competencia.nome)

                ps.executeUpdate()
                println "Competência atualizada com sucesso"
            }
        }catch(SQLException sql){
            println "Erro ao atualizar competência: ${sql.getMessage()}"
        }
    }

    def adicionarCompetenciasCandidato(int idCandidato, int idCompetencia){
        String query = ''' INSERT INTO competencias_candidatos(id_candidato, id_competencia) VALUES(?,?);'''

        try{
            conn.prepareStatement(query).withCloseable {ps ->
                ps.setInt(1, idCandidato)
                ps.setInt(2, idCompetencia)

                ps.executeUpdate()
                println("Competência adicionada com sucesso!")
            }
        }catch(SQLException sql){
            println("Erro ao adicionar competencia do candidato: ${sql}")
        }
    }

    List<Competencia> listarCompetenciasCandidatos(int idCandidato){
        String query = '''SELECT comp.nome AS nome_competencia FROM competencias_candidatos cc
                        INNER JOIN competencias comp ON cc.id_competencia = comp.id
                        WHERE cc.id_candidato = ?;'''

        def competencias = [];
        try{
            conn.prepareStatement(query).withCloseable(({ ps ->
                ps.setInt(1, idCandidato)
                ResultSet rs = ps.executeQuery()
                while (rs.next()) {
                    competencias.add(new Competencia(rs.getString("nome")));
                }
            } as Closure<List<Competencia>>))

            return competencias

        }catch (SQLException sql){
            println("Erro ao listar competências do candidato");
        }


    }

    def adicionarCompetenciasVaga(int idVaga, int idCompetencia){
        String query = ''' INSERT INTO competencias_vaga(id_vaga, id_competencia) VALUES(?,?);'''

        try{
            conn.prepareStatement(query).withCloseable {ps ->
                ps.setInt(1, idVaga)
                ps.setInt(2, idCompetencia)

                ps.executeUpdate()
                println("Competência adicionada com sucesso!")
            }
        }catch(SQLException sql){
            println("Erro ao adicionar competencia da vaga: ${sql}")
        }
    }

    List<Competencia> listarCompetenciasVagas(int idVaga){
        String query = '''SELECT comp.nome AS nome_competencia FROM competencias_vaga cc
                        INNER JOIN competencias comp ON cc.id_competencia = comp.id
                        WHERE cc.id_vaga = ?;'''

        def competencias = [];
        try{
            conn.prepareStatement(query).withCloseable(({ ps ->
                ps.setInt(1, idVaga)
                ResultSet rs = ps.executeQuery()
                while (rs.next()) {
                    competencias.add(new Competencia(rs.getString("nome")));
                }
            } as Closure<List<Competencia>>))

            return competencias

        }catch (SQLException sql){
            println("Erro ao listar competências do candidato");
        }

    }


}

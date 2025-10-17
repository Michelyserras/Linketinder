package org.example.DAO

import org.example.Model.Vaga

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class VagaDAO {
    final Connection conn = Database.getConnection();;

    def criarVaga(Vaga vaga){
        String query = ''' INSERT INTO vaga(nome, descricao, localidade, id_empresa) VALUES (?,?,?,?)'''

        try{
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS).withCloseable {ps->
                ps.setString(1, vaga.nome)
                ps.setString(2, vaga.descricao)
                ps.setString(3, vaga.localidade)
                ps.setInt(4, vaga.id_empresa)

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) vaga.id = rs.getInt(1)

                ps.executeUpdate()
                println "Vaga: ${vaga.getNome()} criada com sucesso"
            }
        }catch(SQLException sql){
            println "Erro ao criar vaga: ${sql.getMessage()}"
        }
    }

    def removerVaga(Vaga vaga){
        String query = ''' DELETE FROM vaga WHERE id = ?; '''

        try{
            PreparedStatement ps = conn.prepareStatement(query).withCloseable {ps->
                ps.setInt(1, vaga.getId())
                ps.execute()
                println "Vaga: ${vaga.getNome()} removida com sucesso"
            }
        }catch(SQLException sql){
            println "Erro ao remover vaga: ${sql.getMessage()}"
        }
    }

    def atualizarVaga(Vaga vaga){
        String query = ''' UPDATE TABLE vaga SET nome=?, descricao=?, localidade = ?, id_empresa = ?; '''
        try{
            PreparedStatement ps = conn.prepareStatement(query).withCloseable {ps->
                ps.setString(1, vaga.nome)
                ps.setString(2, vaga.descricao)
                ps.setString(3, vaga.localidade)
                ps.setInt(4, vaga.id_empresa)

                ps.executeUpdate()
                println "A vaga: ${vaga.getNome()} foi atualizada com sucesso"
            }
        }catch(SQLException sql){
            println "Erro ao atualizar vaga ${sql.getMessage()}"
        }
    }


    def listarVagas(Integer id){
        String query = ''' SELECT * FROM vaga WHERE id_empresa = ?'''
        def vagas = []

        try{
             conn.prepareStatement(query).withCloseable {ps->
                 ps.setInt(1, id);
                ResultSet rs = ps.executeQuery()
                while(rs.next()){
                    vagas.add(
                            new Vaga(rs.getInt("id"), rs.getString("nome"),
                                    rs.getString("descricao"), rs.getString("localidade"),
                                    rs.getInt("id_empresa"))
                    )
                }
                return vagas
            }
        }catch(SQLException sql){
            println "Erro ao listar vagas publicadas: ${sql.getMessage()}."
        }
    }

}

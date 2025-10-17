package org.example.DAO

import org.example.Model.Candidato
import org.example.Model.Empresa

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class EmpresaDAO {
    final Connection conn = Database.getConnection();;

    def criarEmpresa(Empresa empresa) {
        String query = ''' INSERT INTO empresa(nome, cnpj, estado, cep, pais, descricao, email, senha) VALUES (?,?,?,?,?,?,?,?);'''

        try {
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS).withCloseable { ps ->
                ps.setString(1, empresa.nome)
                ps.setString(2, empresa.cnpj)
                ps.setString(3, empresa.estado)
                ps.setString(6, empresa.cep)
                ps.setString(7, empresa.pais)
                ps.setString(8, empresa.descricao)
                ps.setString(9, empresa.email)
                ps.setString(10, empresa.senha)

                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) empresa.id = rs.getInt(1)


                ps.executeUpdate()
                print "Candidato: ${empresa.getNome()} adicionado com sucesso"
            }
        } catch (SQLException sql) {
            println "Erro ao criar empresa: ${sql.getMessage()}"
        }
    }

    def removerEmpresa(Empresa empresa){
        String query = ''' DELETE FROM empresa WHERE id = ?; '''
        try{
            PreparedStatement ps = conn.prepareStatement(query).withCloseable {ps ->
                ps.setInt(1, empresa.getId())
                ps.execute()
                println 'Empresa removida com sucesso'
            }
        }catch(SQLException sql){
            println "Erro ao remover empresa: ${sql.getMessage()}"
        }
    }

    def atualizarEmpresa(Empresa empresa){
        String query = ''' UPDATE TABLE empresa SET nome = ?, cnpj = ?, estado = ?, cep = ?, pais = ?, descricao = ?, email = ?, senha =  ?;'''

        try{
            PreparedStatement ps = conn.prepareStatement(query).withCloseable {ps->
                ps.setString(1, empresa.nome)
                ps.setString(2, empresa.cnpj)
                ps.setString(3, empresa.estado)
                ps.setString(6, empresa.cep)
                ps.setString(7, empresa.pais)
                ps.setString(8, empresa.descricao)
                ps.setString(9, empresa.email)
                ps.setString(10, empresa.senha)

                ps.executeUpdate()

                println "Empresa atualizada com sucesso!"
            }
        }catch(SQLException sql){
            println "Erro ao atualizar empresa: ${sql.getMessage()} "
        }

    }

    List<Empresa> listarEmpresas(){
        String query = ''' SELECT * FROM empresa;'''
        def empresas = []

        try{
            conn.prepareStatement(query).withCloseable {ps ->
               ResultSet rs = ps.executeQuery()
                    while (rs.next()){
                        empresas.add(new Empresa(
                                rs.getInt("id"),
                                rs.getString("nome"),
                                rs.getString("cnpj"),
                                rs.getString("estado"),
                                rs.getString("cep"),
                                rs.getString("pais"),
                                rs.getString("descricao"),
                                rs.getString("email"),
                                rs.getString("senha"),
                                rs.getArray("vagas")
                        ))
                    }
                    return empresas
            }
        }catch(SQLException sql){
            println "Erro ao listar empresas: ${sql.getMessage()}"

        }
    }
}




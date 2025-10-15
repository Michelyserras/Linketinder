package org.example.DAO

import org.example.Model.Candidato

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class CandidatoDAO {

   final Connection conn = Database.getConnection();;

    def inicializar(){
        criarTabela()
    }

    def criarTabela(){
        String query = '''
            CREATE TABLE IF NOT EXISTS candidato (
                id SERIAL PRIMARY KEY,
                nome VARCHAR(40) NOT NULL,
                sobrenome VARCHAR(120) NOT NULL,
                cpf VARCHAR(11) NOT NULL,
                idade NUMBER(2) NOT NULL,
                estado VARCHAR(2) NOT NULL,
                cep VARCHAR(8) NOT NULL,
                pais VARCHAR(45) NOT NULL,
                descricao TEXT NOT NULL,
                email VARCHAR(100) NOT NULL,
                senha VARCHAR(30) NOT NULL
            );
        '''

        try{
            PreparedStatement ps = conn.prepareStatement(query).withCloseable { ps ->
                ps.execute();
                println 'Tabela de candidatos foi criada ou já existe'
            }
        }catch(SQLException sql){
            println 'Erro ao criar tabela' + sql.getMessage();
        }
    }

    Candidato criarCandidato(Candidato candidato){
        String query = ''' INSERT INTO CANDIDATO (nome, sobrenome, cpf, idade, estado, cep, pais, descricao, email, senha) VALUES (?, ?, ?,?,?,?,?,?,?,?); '''

        try{
            PreparedStatement ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS).withCloseable {ps ->
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

                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()) candidato.id = rs.getInt(1)


                ps.executeUpdate()
                print "Candidato: ${candidato.getNome()} adicionado com sucesso"

            }
        }catch (SQLException sql){
            println "Erro ao criar candidato: ${sql.getMessage()}"
        }
    }

    def removerCandidato(Candidato candidato){
        String query = ''' DELETE FROM CANDIDATO WHERE id = ?; '''
        try{
            PreparedStatement ps = conn.prepareStatement(query).withCloseable {ps ->
                ps.setInt(1, candidato.getId())
                ps.execute()
                println 'Candidato removido com sucesso'
            }
        }catch(SQLException sql){
            println "Erro ao remover candidato: ${sql.getMessage()}"
        }
    }

    def atualizarCandidato(Candidato candidato){
        String query = ''' UPDATE TABLE candidato SET nome = ?, sobrenome = ?, cpf = ?, idade = ?, estado = ?, cep = ?, pais = ?, descricao = ?, email = ?, senha = ?'''

        try{
            PreparedStatement ps = conn.prepareStatement(query).withCloseable {ps->
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
            PreparedStatement ps = conn.prepareStatement(query).withCloseable {ps ->
               ps.executeQuery().withCloseable {rs ->
                   while (rs.next()){
                       candidatos.add(new Candidato(
                               rs.getInt("id"),
                               rs.getString("nome"),
                               rs.getString("sobrenome"),
                               rs.getString("cpf"),
                               rs.getInt("idade"),
                               rs.getString("estado"),
                               rs.getString("cep"),
                               rs.getString("pais"),
                               rs.getString("descricao"),
                               rs.getString("email"),
                               rs.getString("senha"),
                               rs.getString("competencias")
                       ))
                   }
                   return candidatos
               }
            }
        }catch(SQLException sql){
            println "Erro ao listar candidatos: ${sql.getMessage()}"

        }
    }
}

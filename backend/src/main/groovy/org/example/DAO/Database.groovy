package org.example.DAO

import java.sql.Connection
import java.sql.Driver
import java.sql.DriverManager

class Database {
    static Connection conn = null;
    static final String url = 'jdbc:postgresql://localhost:5432/linketinder'
    static final String user = 'postgres'
    static final String password = 'postgres'

    static Connection getConnection(){
        if(conn == null){
            conn = DriverManager.getConnection(url,user,password);
            println 'conectado com o banco';
        }
        return conn;
    }




}

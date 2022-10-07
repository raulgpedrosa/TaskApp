/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Raul Pedrosa
 */
//class para conectar o banco de dados com a nossa aplicação
public class ConnectionFactory {
    
    /* jdbc é o driver de conexão de banco de dados com o java e o jdbc com o 
    banco de dados do mysql*/
    
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    
    /* URL qual é local onde o banco de dados está rodando.
    Meu banco está rodando localmente pela porta 3306, que é a porta
    mostrada no Start do XAMPP, mais o nome do meu banco de dados, que no
    meu caso agora é taskapp.*/
    
    public static final String URL = "jdbc:mysql://localhost:3306/taskapp";
    
    // Usuário que por padrão do MySQL é root (pode ser alterado) 
    public static final String USER = "root";
    
    // Senha que por padrão MySQL fica vazia (pode ser alterado também)
    public static final String PASS = "";
    
    public static Connection getConnection(){
    
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex){
            throw new RuntimeException("Erro na conexão com banco de dados", ex);
        }    
    }
    
    public static void closeConnection(Connection connection){
    
        try {
            if(connection != null){
                connection.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dodos", ex);
        }
    
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement){
    
        try {
            if(connection != null){
                connection.close();
            }
            
            if(statement != null){
                statement.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dodos", ex);
        }
    
    }
    
    public static void closeConnection(Connection connection, 
            PreparedStatement statement, ResultSet resultSet){
    
        try {
            if(connection != null){
                connection.close();
            }
            
            if(statement != null){
                statement.close();
            }
            
            if(resultSet != null){
                resultSet.close();
            }
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao fechar a conexão com o banco de dodos", ex);
        }
    
    }
    
    
}

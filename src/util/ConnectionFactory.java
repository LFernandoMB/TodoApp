package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/todoApp";
    public static final String USER = "root";
    public static final String PASS = "";
    
    // Java Dependencies
    // - Build Scripts -> build.gradle -> depencencies {
    // compile group: 'mysql', name: 'mysql-connector-java', version: '5.1.13'
    
    // Referência
    // https://mvnrepository.com/artifact/mysql/mysql-connector-java
    // implementation group: 'mysql', name: 'mysql-connector-java', version: '5.1.13'
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);     
        } catch (Exception ex){
            throw new RuntimeException("Erro na conexão com o banco de dados", ex);
        }
    }
    
    public static void closeConnection(Connection connection){
        try {
            if (connection != null){
                connection.close();
            }
        }catch (Exception ex){
            throw new RuntimeException("Erro ao fechar com o ", ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement){
        try {
            if (connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
        }catch (Exception ex){
            throw new RuntimeException("Erro ao fechar com o ", ex);
        }
    }
    
    public static void closeConnection(Connection connection, PreparedStatement statement, ResultSet resultSet){
        try {
            if (connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        }catch (Exception ex){
            throw new RuntimeException("Erro ao fechar com o ", ex);
        }
    }
}
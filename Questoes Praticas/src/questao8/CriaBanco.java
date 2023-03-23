package questao8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriaBanco {

    public static void main(String[] args) {
        
        // Informações para conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/"; // endereço do servidor e porta
        String user = "root"; // nome do usuário
        String password = "aluno"; // senha do usuário
        
        // Nome do banco de dados a ser criado
        String databaseName = "pds2";
        
        // Nome da tabela a ser criada
        String tablePerson = "pessoa";
        
        // SQL para criação da tabela
        String createTable = "CREATE TABLE IF NOT EXISTS " + tablePerson +
                           "(id INT NOT NULL AUTO_INCREMENT, " +
                           " nome VARCHAR(255), " + 
                           " idade INT, " + 
                           " PRIMARY KEY ( id ));";
        
        Connection conexao = null;
        Statement statement = null;
        
        try {
            // Conexão com o banco de dados
            conexao = DriverManager.getConnection(url, user, password);
            statement = conexao.createStatement();
            
            // Deleta o banco de dados para não estourar erro ao criar novamente
            statement.executeUpdate("DROP DATABASE " + databaseName);
            
            // Criação do banco de dados
            statement.executeUpdate("CREATE DATABASE " + databaseName);
            
            // Seleciona o banco de dados criado
            statement.executeUpdate("USE " + databaseName);
            
            // Criação da tabela
            statement.executeUpdate(createTable);
            
            System.out.println("Banco de dados e tabela criados com sucesso!");
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Encerra conexão com o banco de dados
                if (statement != null) {
                    statement.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

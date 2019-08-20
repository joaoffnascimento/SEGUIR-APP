package br.edu.ifs;

import java.sql.*;

/**
 * @author Joao Felipe FIDAPÉ
 * @version 1.2
 */
public class ConnectionFactory {

    //Driver para ser carregado pela JVM
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    //Nome do usuário do Banco de Dados
    private static final String USERNAME = "root";

    //Senha do Banco de Dados
    private static final String PASSWORD = "admin";

    //Endereço do Servidor
    private static final String ENDSRV = "localhost";

    //Nome da instancia
    private static final String NMINST = "DBIFS";

    //Dados de caminho, porta e nome da base de dados que irá ser feita a conexão
    private static final String DATABASE_URL = "jdbc:mysql://"+ENDSRV+"/"+NMINST;

    /**
     * Cria uma conexão com o banco de dados SQL SERVER utilizando o nome de usuário e senha fornecidos
     *
     * @param //USERNAME
     * @param //PASSWORD
     * @return uma conexão com o banco de dados
     * @throws Exception
     */
    public static Connection createConnectionToSQLServer() throws Exception {
        Class.forName(DRIVER); // Faz com que a classe seja carregada pela JVM

        // Cria a conexão com o banco de dados
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }
}
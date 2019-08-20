package br.edu.ifs.seguir.repositorio;
import br.edu.ifs.ConnectionFactory;
import br.edu.ifs.seguir.model.AejpessoaEntity;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AlunoRepositorio {
    private Connection con;

    public AlunoRepositorio() {

        try {
            //Recupera uma conexão com o banco de dados
            ConnectionFactory sql = new ConnectionFactory();
            con = sql.createConnectionToSQLServer();

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.con = con;
    }

    public boolean inserirAluno(AejpessoaEntity pessoa) {
        //Apontar ao invés da coluna, apontar para o joker, dependendo da quantidade; quantidade x posição
        try {
            PreparedStatement statement = con.prepareStatement("INSERT INTO Aluno (Nome) VALUES (?)");
            statement.setString(1, pessoa.getNome());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public ArrayList<AejpessoaEntity> listarPessoa() {
        try {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM Aluno");
            ResultSet resultSet = statement.executeQuery();
            ArrayList<AejpessoaEntity> alunos = new ArrayList<>();

            while (resultSet.next()) {
                AejpessoaEntity a = new AejpessoaEntity(resultSet.getString("Nome"));
                a.setIdPessoa(resultSet.getInt("idAluno"));
                alunos.add(a);
            }
            return alunos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean removerPessoa(int id) {
        try {
            PreparedStatement statement = con.prepareStatement("DELETE FROM Aluno WHERE (idAluno = ?)");
            statement.setInt(1,id);
            statement.execute();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
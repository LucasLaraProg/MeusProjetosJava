package view;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author botel
 */
public class Conexao {

    private final String bd = "projeto"; // mudar o nome da base para cada projeto
    private final String usuario = "root";
    private final String senha = "";

    public Connection conectar() {
        Connection conexao = null;
        try { //tratamento de exceção            
            Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/" + this.bd,
                    this.usuario, this.senha);
        } catch (ClassNotFoundException e1) {
            System.out.println("Erro com o driver: " + e1.getMessage());
        } catch (SQLException e2) {
            System.out.println("Erro na tentativa de conexão: " + e2.getMessage());
        }
        return conexao;

    }
}

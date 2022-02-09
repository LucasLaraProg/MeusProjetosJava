package view;


import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Clientes {

    private String nome;
    private String rua;
    private String bairro;
    private String telefone;
    private String cep;
    private String numerocasa;
    private String cpfcnpj;

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumerocasa() {
        return numerocasa;
    }

    public void setNumerocasa(String numerocasa) {
        this.numerocasa = numerocasa;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean gravar() {
        try {
            Connection conexao = new Conexao().conectar();
            if (conexao != null) {
                PreparedStatement ps;
                String sql = "insert into clientes(nome,rua,bairro,cep,numero,cpf,telefone)values(?,?,?,?,?,?,?)";
                ps = conexao.prepareStatement(sql);
                ps.setString(1, getNome());
                ps.setString(2, getRua());
                ps.setString(3, getBairro());
                ps.setString(4, getCep());
                ps.setString(5, getNumerocasa() );
                ps.setString(6, getCpfcnpj());
                ps.setString(7, getTelefone());
                ps.executeUpdate();
                conexao.close();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}

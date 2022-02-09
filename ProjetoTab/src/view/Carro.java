package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author botel
 */
public class Carro {
    private String veiculo;
    private String cor;
    private String ano;
    private String placa;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    public String getPlaca(){
        return placa;
    }
    
    public void setPlaca(String placa){
        this.placa = placa;
        
    }
     public boolean gravarc() {
        try {
            Connection conexao = new Conexao().conectar();
            if (conexao != null) {
                PreparedStatement ps;
                String sql = "insert into carros (veiculo,ano,cor,placa)values(?,?,?,?)";
                ps = conexao.prepareStatement(sql);
                ps.setString(1, getVeiculo());
                ps.setString(2, getAno());
                ps.setString(3, getCor());
                ps.setString(4, getPlaca());
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

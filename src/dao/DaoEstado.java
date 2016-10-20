/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bd.conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import pojo.Estado;

/**
 *
 * @author Renato
 */
public class DaoEstado {
    private Estado estado;
    private final String SQLINCLUIR = "INSERT INTO VALUES (?,?,?)";
    private final String SQLALTERAR = "UPDATE ESTADO SET NOME=?,SIGLA=? WHERE ID=?";
    private final String SQLEXCLUIR = "DELETE FROM ESTADO WHERE ID=?";
    private final String SQLCONSULTAR = "SELECT * FROM ESTADO WHERE ID =?";
    
    
    
    public DaoEstado (Estado estado) {
        
        this.estado = estado;
    }
    
    public boolean incluir () {
        
        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, estado.getId());
            ps.setString(2, estado.getNome());
            ps.setString(2, estado.getSigla());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Não foi possivel incluir estado ao banco");
            return false;
        }
        
    }
    
    public boolean alterar () {
        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1,estado.getNome());
            ps.setString(2,estado.getSigla());
            ps.setInt(2,estado.getId());
            ps.executeUpdate();
            return true;    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Não foi possivel ALTERAR estado ao banco");
            return false;   
        }
        
    }
    public boolean excluir () {
         try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(SQLEXCLUIR);     
            ps.setInt(1,estado.getId());
            ps.executeUpdate();
            return true;    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Não foi possivel excluir estado ao banco");
            return false;   
        }
    }
    public boolean consultar () {
        
        try {
            PreparedStatement ps = conexao.getConexao().prepareStatement(SQLCONSULTAR);     
            ps.setInt(1,estado.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estado.setNome(rs.getString(2));
                estado.setSigla(rs.getString(3));
            } else {
                JOptionPane.showMessageDialog(null,"Estado não encontrado.");
            }
            return true;    
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Não foi possivel consultar estado ao banco");
            return false;   
        }
    }
    
}



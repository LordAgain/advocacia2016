
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conexao {
    private static Connection conexao;
    public static Connection getConexao () {
        
        try {
            if(conexao == null) {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                conexao = DriverManager.getConnection("jdbc:firebirdsql://localhost/" +
                        System.getProperty("user.dir") + "/BANCO.FDB", "SYSDBA", "masterkey");
                
            }
            return conexao;
        } catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null,"Erro no driver jdbc");
            return null;
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(null,"Erro na conexão com o banco de dados");
            se.printStackTrace();
            return null;
        }      
        
    }
    
}

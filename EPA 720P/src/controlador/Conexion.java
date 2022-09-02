
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Leonel
 */
public class Conexion {
    
   public static Connection conectar()
   {
       Connection conexion = null;
       String base = "jdbc:mysql://localhost:3306/EPA?useTimezone=true&serverTimezone=UTC&ssh=false";
       String usr = "root";
       String pass = "";
     
       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conexion = (Connection) DriverManager.getConnection(base, usr, pass);
       }
       catch(ClassNotFoundException ex)
       {
            JOptionPane.showMessageDialog(null, ex.getMessage());
       }
       catch(Exception ex)
       {
            JOptionPane.showMessageDialog(null, ex.getMessage());
       }
       finally
       {
           return conexion;
       }
   }
   
   public static void desconectar(Connection cnx)
   {
       try {
           cnx.close();
       } catch (SQLException ex) {
           Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}

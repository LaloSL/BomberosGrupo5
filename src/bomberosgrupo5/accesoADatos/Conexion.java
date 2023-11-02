// Clase Conexion (Proyecto BomberosGrupo5)

package bomberosgrupo5.accesoADatos;

import java.sql.*;
import javax.swing.JOptionPane;

//** @author Asus
public class Conexion {

    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="cuartel de bomberos"; 
    private static final String USUARIO="root"; 
    private static final String PASSWORD=""; 
    private static Connection connection; 

    private Conexion() { //no se puede instanciar objetos de esta clase
    }

    public static Connection getConectar() { //FY  Por lo tanto debemos utilizar este método static

        if (connection == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver"); //cargamos el driver
                connection = DriverManager.getConnection(URL + DB, USUARIO, PASSWORD); //conectamos el driver
                //JOptionPane.showMessageDialog(null, "Conectado exitosamente ");

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar Driver de conexión ");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexión con la Base de Datos ");
            }
        }
        return connection;
    }
}

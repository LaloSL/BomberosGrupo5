// Clase Conexion (Proyecto BomberosGrupo5)

package bomberosgrupo5.accesoADatos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

//public class Conexion {
//    private String url = "jdbc:mariadb://localhost:8080/cuartel de bomberos";  // Corrige la URL de conexión.
//    private String usuario = "root";
//    private String password = "";
//    private Connection conexion;
//
//    public Conexion() {
//        try {
//            Class.forName("org.mariadb.jdbc.Driver");  // Utiliza el controlador correcto.
//        } catch (ClassNotFoundException ex) {
//           JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos: " + ex.getMessage());
//        }
//    }
//
//    public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
//        this.url = url;
//        this.usuario = usuario;
//        this.password = password;
//
//        Class.forName("org.mariadb.jdbc.Driver");  // Utiliza el controlador correcto.
//    }
//
//    public Connection getConexion() {
//        if (conexion == null) {
//            try {
//                conexion = DriverManager.getConnection(url, usuario, password);
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error de conexión a base de datos: " + ex.getMessage());
//            }
//        }
//        return conexion;
//    }
//}



import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Joaco
 */
public class Conexion {
    private static final String URL="jdbc:mariadb://localhost:8080/";
    private static final String DB="cuartel de bomberos";
    private static final String USUARIO="root";
    private static final String PASWORD="";
    private static Connection connection;
    
    private Conexion (){}
    
    public static Connection getCotexion(){
        if (connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");//cargamos el driver
                connection = DriverManager.getConnection(URL+DB,USUARIO,PASWORD);//conectamos el driver
                //JOptionPane.showMessageDialog(null, "Conectado Exitosamente");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los Driver ");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion con la BD ");
            }
        }
        return connection;
    }
    
    
}

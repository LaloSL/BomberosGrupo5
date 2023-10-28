/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo5.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Conexion {
       private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="cuartel_de_bomberos";
    private static final String USUARIO="root";
    private static final String PASWORD="";
    private static Connection connection;
    
    private Conexion (){}
    
    public static Connection getCotexion(){
        if (connection==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");//cargamos el driver
                connection = DriverManager.getConnection(URL+DB,USUARIO,PASWORD);//conectamos el driver
            //JOptionPane.showMessageDialog(null, "Conectado");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar los Driver ");
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error de conexion con la BD ");

                
            }
        }
        return connection;
    } 
}

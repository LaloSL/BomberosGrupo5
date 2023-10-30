// Clase CuartelData (proyecto BomberosGrupo5)
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Cuartel;
import java.sql.*;
import javax.swing.JOptionPane;

public class CuartelData {

    private Connection con = null;

    public CuartelData() { // FY
        con = Conexion.getConectar();
    }

    // método guardar bombero:
    public void guardarCuartel(Cuartel cuartel) {
       
            String sql = "INSERT INTO cuartel (nombreCuartel,direccion,coordX,coordY,telefono,correo,estadoC)"
                    + "VALUE(?, ? ,? ,? ,? ,? ,?)";

            try {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, cuartel.getNombreCuartel());
                ps.setString(2, cuartel.getDireccion());
                ps.setInt(3, cuartel.getCoordX());
                ps.setInt(4, cuartel.getCoordY());
                ps.setString(5, cuartel.getTelefono());
                ps.setString(6, cuartel.getCorreo());
                ps.setBoolean(7, cuartel.isEstadoC());

                ps.executeUpdate();

                ResultSet rs=ps.getGeneratedKeys();

                if (rs.next()) {
                    cuartel.setIdCuartel(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Cuartel Agregado Exitosamente ");
                }
                ps.close();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel ");
            }
       
        }

}


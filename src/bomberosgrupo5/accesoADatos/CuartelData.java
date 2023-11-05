// Clase CuartelData (proyecto BomberosGrupo5)

package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Cuartel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CuartelData {
 private Connection con;
    //private Connection con = null;
 public CuartelData(Connection con) {
    this.con = con;
}
//    private Connection con = null;
//
//    public CuartelData() { 
//        con = Conexion.getConectar();
//    }
//------------------------------------------------------------------------------
    // método guardar cuartel:
    public void guardarCuartel(Cuartel cuartel) {
       
            String sql = "INSERT INTO cuartel (nombreCuartel,direccion,coordX,coordY,telefono,correo,estadoC)"
                    + "VALUE(?, ? ,? ,? ,? ,? ,?)";

            try {
                PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

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
    
//------------------------------------------------------------------------------

//método modificarCuartel:

public void modificarCuartel(Cuartel cuartel){

    String sql="UPDATE cuartel SET nombreCuartel=?, direccion=?, coordX=?, coordY=?, telefono=?, correo=?"
                    + "WHERE idCuartel=?";

            try {
                PreparedStatement ps = con.prepareStatement(sql);

                ps.setString(1, cuartel.getNombreCuartel());
                ps.setString(2, cuartel.getDireccion());
                ps.setInt(3, cuartel.getCoordX());
                ps.setInt(4, cuartel.getCoordY());
                ps.setString(5, cuartel.getTelefono());
                ps.setString(6, cuartel.getCorreo());
                ps.setInt(7, cuartel.getIdCuartel());
                
                int exito = ps.executeUpdate();
                
                if(exito==1){
                   JOptionPane.showMessageDialog(null, "Error al acceder a Tabla cuartel ");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel ");
            }
            
}
//------------------------------------------------------------------------------

public void eliminarCuartel(int id){
    String sql="UPDATE cuartel SET estadoC=0 WHERE idCuartel=?";
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito=ps.executeUpdate();
            if(exito==1){
            JOptionPane.showMessageDialog(null, "Cuartel Eliminado ");
            }
            
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel ");  
        }



}

//-----------------------DESDE ACA----------------------------
public int mostrarOpcionesYObtenerSeleccion(Connection con) {
    int idCuartelElegido = -1; // Valor predeterminado para indicar que no se ha seleccionado ningún cuartel
    List<String> nombresCuartel = new ArrayList<>();

    String sql = "SELECT Cuartel, nombreCuartel FROM cuartel WHERE estadoC = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idCuartel = rs.getInt("Cuartel");
            String nombreCuartel = rs.getString("nombreCuartel");

            nombresCuartel.add(idCuartel + ". " + nombreCuartel);
        }
        ps.close();

        if (!nombresCuartel.isEmpty()) {
            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Elija un cuartel:\n" + String.join("\n", nombresCuartel),
                    "Selección de Cuartel",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    nombresCuartel.toArray(),
                    nombresCuartel.get(0));

            if (seleccion != null) {
                String[] parts = seleccion.split("\\. ");
                if (parts.length == 2) {
                    idCuartelElegido = Integer.parseInt(parts[0]);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener nombres de cuarteles: " + ex.getMessage());
    }

    return idCuartelElegido;
}



public boolean existeCuartelConNombre(String nombreCuartel) {
    String sql = "SELECT COUNT(*) FROM cuartel WHERE nombreCuartel = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreCuartel);
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            return true; // Ya existe un cuartel con el mismo nombre
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar la existencia del cuartel.");
    }
    return false; // No existe un cuartel con el mismo nombre
}


//buscu un cuartel por id y lo devuelvo
public Cuartel buscarCuartelPorId(int idCuartel) {
    String sql = "SELECT nombreCuartel, direccion, coordX, coordY, telefono, correo, estadoC FROM cuartel WHERE Cuartel = ?";
    Cuartel cuartel = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCuartel);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cuartel = new Cuartel();
            cuartel.setIdCuartel(idCuartel);
            cuartel.setNombreCuartel(rs.getString("nombreCuartel"));
            cuartel.setDireccion(rs.getString("direccion"));
            cuartel.setCoordX(rs.getInt("coordX"));
            cuartel.setCoordY(rs.getInt("coordY"));
            cuartel.setTelefono(rs.getString("telefono"));
            cuartel.setCorreo(rs.getString("correo"));
            cuartel.setEstadoC(rs.getBoolean("estadoC"));
        } else {
            JOptionPane.showMessageDialog(null, "No existe el cuartel con el ID indicado");
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: " + ex.getMessage());
    }

    return cuartel;
}





}    




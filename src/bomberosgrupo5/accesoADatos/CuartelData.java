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
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, cuartel.getNombreCuartel());
            ps.setString(2, cuartel.getDireccion());
            ps.setInt(3, cuartel.getCoordX());
            ps.setInt(4, cuartel.getCoordY());
            ps.setString(5, cuartel.getTelefono());
            ps.setString(6, cuartel.getCorreo());
            ps.setBoolean(7, cuartel.isEstadoC());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                cuartel.setCuartel(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Cuartel Agregado Exitosamente ");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel ");
        }

    }

//------------------------------------------------------------------------------
//método modificarCuartel:
    public void modificarCuartel(Cuartel cuartel) {
//        String sql = "UPDATE Cuartel SET nombreCuartel = ?, direccion = ?, coordX = ?, coordY = ?, telefono = ?, correo = ? WHERE Cuartel = ?";
//        
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//
//            ps.setString(1, cuartel.getNombreCuartel());
//            ps.setString(2, cuartel.getDireccion());
//            ps.setInt(3, cuartel.getCoordX());
//            ps.setInt(4, cuartel.getCoordY());
//            ps.setString(5, cuartel.getTelefono());
//            ps.setString(6, cuartel.getCorreo());
//            ps.setInt(7, cuartel.getIdCuartel());
//
//            int exito = ps.executeUpdate();
//
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Cuartel modificado exitosamente.");
//            } else {
//                JOptionPane.showMessageDialog(null, "Error al modificar el cuartel." );
//                
//    
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//    JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel. Detalles: " + ex.getMessage());
//            
//            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel.");
//        }

             String sql = "UPDATE cuartel SET nombreCuartel = ?, direccion = ?, coordX = ?, coordY = ?, telefono = ?, correo = ? WHERE Cuartel = ?"; // Cambia "Cuartel" a "idCuartel" o la columna adecuada en tu base de datos

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, cuartel.getNombreCuartel());
        ps.setString(2, cuartel.getDireccion());
        ps.setInt(3, cuartel.getCoordX());
        ps.setInt(4, cuartel.getCoordY());
        ps.setString(5, cuartel.getTelefono());
        ps.setString(6, cuartel.getCorreo());
        ps.setInt(7, cuartel.getCuartel());

        int exito = ps.executeUpdate();
        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Cuartel modificado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el cuartel con ID " + cuartel.getCuartel() + " para modificar.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: " + ex.getMessage());
    }

}
//------------------------------------------------------------------------------

public void eliminarCuartel(int id){
    String sql="UPDATE cuartel SET estadoC=0 WHERE Cuartel=?";
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

    String sql = "SELECT cuartel, nombreCuartel FROM cuartel WHERE estadoC = 1";
    //System.out.println(""+sql);

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int Cuartel = rs.getInt("Cuartel");
            String nombreCuartel = rs.getString("nombreCuartel");

            nombresCuartel.add(Cuartel + ". " + nombreCuartel);
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
        JOptionPane.showMessageDialog(null, "Error al obtener nombres de cuarteles: ");
    }
    //System.out.println(""+idCuartelElegido);
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
//public Cuartel buscarCuartelPorId(int Cuartel, Connection con) {
//    String sql = "SELECT nombreCuartel, direccion, coordX, coordY, telefono, correo, estadoC "
//            + "FROM cuartel WHERE Cuartel = ? AND estadoC = 1";
//
//    Cuartel cuartel = null;
//    
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, Cuartel);
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            cuartel = new Cuartel();
//            cuartel.setNombreCuartel(rs.getString("nombreCuartel"));
//            cuartel.setDireccion(rs.getString("direccion"));
//            cuartel.setCoordX(rs.getInt("coordX"));
//            cuartel.setCoordY(rs.getInt("coordY"));
//            cuartel.setTelefono(rs.getString("telefono"));
//            cuartel.setCorreo(rs.getString("correo"));
//            cuartel.setEstadoC(rs.getBoolean("estadoC"));
//        } else {
//            JOptionPane.showMessageDialog(null, "No existe el cuartel con el ID indicado");
//        }
//        ps.close();
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: ");
//    }
//    System.out.println(""+cuartel.getCuartel());
//
//    return cuartel;

public Cuartel buscarCuartelPorId(int Cuartel) {
    String sql = "SELECT nombreCuartel, direccion, coordX, coordY, telefono, correo, estadoC "
            + "FROM cuartel WHERE Cuartel = ? AND estadoC = 1";

    Cuartel cuartel = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, Cuartel);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cuartel = new Cuartel();
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

    if (cuartel != null) {
        // Imprime el contenido de cuartel antes de retornarlo
        System.out.println("Contenido del cuartel:");
        System.out.println("Nombre: " + cuartel.getNombreCuartel());
        System.out.println("Dirección: " + cuartel.getDireccion());
        System.out.println("CoordX: " + cuartel.getCoordX());
        System.out.println("CoordY: " + cuartel.getCoordY());
        System.out.println("Teléfono: " + cuartel.getTelefono());
        System.out.println("Correo: " + cuartel.getCorreo());
        System.out.println("Estado: " + cuartel.isEstadoC());
    }

    return cuartel;
}


//-----------------------------------------------------------------
// aca esta el problemon....

//public void actualizarNombreCuartel(int Cuartel, String nuevoNombre) {
//    String sql = "UPDATE cuartel SET nombreCuartel = ? WHERE Cuartel = ? AND estadoC = 1";
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1, nuevoNombre);
//        ps.setInt(2, Cuartel);
//
//        int exito = ps.executeUpdate();
//
//        if (exito == 1) {
//            JOptionPane.showMessageDialog(null, "Nombre de cuartel actualizado exitosamente.");
//        } else {
//            JOptionPane.showMessageDialog(null, "Error al actualizar el nombre del cuartel. Asegúrate de que el cuartel exista y el estado sea 1.");
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: " );
//    }
//}


//----------------------------------------ELIMINAR CUARTEL---------------------------------------------------------

//------------------------selecciono cuartel a eliminar-----------------------------------------------------

public int mostrarCuartelesAEliminar(Connection con) {
    int idCuartelAEliminar = -1; // Valor predeterminado para indicar que no se ha seleccionado ningún cuartel
    List<String> cuartelesAEliminar = new ArrayList<>();

    String sql = "SELECT Cuartel, nombreCuartel FROM cuartel WHERE estadoC = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idCuartel = rs.getInt("Cuartel");
            String nombreCuartel = rs.getString("nombreCuartel");

            cuartelesAEliminar.add(idCuartel + ". " + nombreCuartel);
        }
        ps.close();

        if (!cuartelesAEliminar.isEmpty()) {
            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Elija un cuartel a eliminar:\n" + String.join("\n", cuartelesAEliminar),
                    "Selección de Cuartel a Eliminar",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    cuartelesAEliminar.toArray(),
                    cuartelesAEliminar.get(0));

            if (seleccion != null) {
                String[] parts = seleccion.split("\\. ");
                if (parts.length == 2) {
                    idCuartelAEliminar = Integer.parseInt(parts[0]);
                    System.out.println("ID del Cuartel a eliminar: " + idCuartelAEliminar);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la lista de cuarteles a eliminar: " + ex.getMessage());
    }

    return idCuartelAEliminar;
}

//--------------------------------------------------------------------------------------------

//---------------------cambiar estado de cuartel---------------------------------------
public void cambiarEstadoCuartel(int idCuartel, Connection con) {
    String sql = "UPDATE cuartel SET estadoC = 0 WHERE Cuartel = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCuartel);
        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Cuartel eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el cuartel.");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al cambiar el estado del cuartel: " + ex.getMessage());
    }
}


//---------------------------------------------------------------------------------

}

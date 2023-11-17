// Clase CuartelData (proyecto BomberosGrupo5)
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Cuartel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class CuartelData {

    private Connection con = null;

    public CuartelData() {
        con = Conexion.getConexion();
    }

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
    public void modificarCuartel(Cuartel cuartel) {
        String sql = "UPDATE cuartel SET nombreCuartel = ?"
                +", direccion = ?, coordX = ?, coordY = ?, telefono = ?, correo = ? "
                + "WHERE idCuartel = ?";
        //System.out.println("" + cuartel);
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

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel modificado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar el cuartel.");
            }
        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel.");
        }

    }
//------------------------------------------------------------------------------

    public void eliminarCuartel(int id) {
        String sql = "UPDATE cuartel SET estadoC=0 WHERE idCuartel=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Cuartel Eliminado ");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla cuartel ");
        }

    }

//-----------------------DESDE ACA----------------------------
    public List<String> mostrarOpcionesYObtenerSeleccion() {
        List<String> nombresCuartel = new ArrayList<>();

    String sql = "SELECT idCuartel, nombreCuartel FROM cuartel WHERE estadoC = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idCuartel = rs.getInt("idCuartel");
            String nombreCuartel = rs.getString("nombreCuartel");

            nombresCuartel.add(idCuartel + ". " + nombreCuartel);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener nombres de cuarteles: " + ex.getMessage());
    }

    return nombresCuartel;
//        int idCuartelElegido = -1; // Valor predeterminado para indicar que no se ha seleccionado ningún cuartel
//        List<String> nombresCuartel = new ArrayList<>();
//
//        String sql = "SELECT idCuartel, nombreCuartel FROM cuartel WHERE estadoC = 1";
//        //System.out.println(""+sql);
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                int idCuartel = rs.getInt("idCuartel");
//                String nombreCuartel = rs.getString("nombreCuartel");
//
//                nombresCuartel.add(idCuartel + ". " + nombreCuartel);
//            }
//            ps.close();
//
//            if (!nombresCuartel.isEmpty()) {
//                String seleccion = (String) JOptionPane.showInputDialog(null,
//                        "Elija un cuartel:\n" + String.join("\n", nombresCuartel),
//                        "Selección de Cuartel",
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        nombresCuartel.toArray(),
//                        nombresCuartel.get(0));
//
//                if (seleccion != null) {
//                    String[] parts = seleccion.split("\\. ");
//                    if (parts.length == 2) {
//                        idCuartelElegido = Integer.parseInt(parts[0]);
//
//                    }
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al obtener nombres de cuarteles: ");
//        }
//
//        return idCuartelElegido;
    }
//------------------------------------------------------------------------
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
//public Cuartel buscarCuartelPorId(int idCuartel) {
//    String sql = "SELECT `idCuartel`, `nombreCuartel`, `direccion`, `coordX`, `coordY`, `telefono`, `correo`, `estadoC` "
//            + "FROM `cuartel` WHERE `idCuartel` = ? AND `estadoC` = 1";
//
//    Cuartel cuartel = null;
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, idCuartel);
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            cuartel = new Cuartel(rs.getInt("idCuartel"), rs.getString("nombreCuartel"), rs.getString("direccion"),
//                                  rs.getInt("coordX"), rs.getInt("coordY"), rs.getString("telefono"),
//                                  rs.getString("correo"), rs.getBoolean("estadoC"));
//        } else {
//            JOptionPane.showMessageDialog(null, "No existe el cuartel con el ID indicado");
//        }
//        ps.close();
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: " + ex.getMessage());
//    }
//
//    return cuartel;
//}
//
////public Cuartel buscarCuartelPorId(int idCuartel) {
////    String sql = "SELECT idCuartel, nombreCuartel, direccion, coordX, coordY, telefono, correo, estadoC "
////            + "FROM cuartel WHERE idCuartel = ? AND estadoC = 1";
////
////    Cuartel cuartel = null;
////
////    try {
////        PreparedStatement ps = con.prepareStatement(sql);
////        ps.setInt(1, idCuartel);
////        ResultSet rs = ps.executeQuery();
////
////        if (rs.next()) {
////            // Incluye idCuartel al construir el objeto Cuartel
////            cuartel = new Cuartel(rs.getInt("idCuartel"), rs.getString("nombreCuartel"), rs.getString("direccion"),
////                                  rs.getInt("coordX"), rs.getInt("coordY"), rs.getString("telefono"),
////                                  rs.getString("correo"), rs.getBoolean("estadoC"));
////        } else {
////            JOptionPane.showMessageDialog(null, "No existe el cuartel con el ID indicado");
////        }
////        ps.close();
////    } catch (SQLException ex) {
////        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: ");
////    }
////
////    return cuartel;
////}
//
    public Cuartel buscarCuartelPorId(int idCuartel) {
        String sql = "SELECT nombreCuartel, direccion, coordX, coordY, telefono, correo, estadoC "
                + "FROM cuartel WHERE idCuartel = ? AND estadoC = 1";

        Cuartel cuartel = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCuartel);
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: ");
        }

        return cuartel;
    }

//-----------------------------------------------------------------
// aca esta el problemon....
    public void actualizarNombreCuartel(int idCuartel, String nuevoNombre) {
        String sql = "UPDATE cuartel SET nombreCuartel = ? WHERE idCuartel = ? AND estadoC = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nuevoNombre);
            ps.setInt(2, idCuartel);

            int exito = ps.executeUpdate();

            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Nombre de cuartel actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar el nombre del cuartel. Asegúrate de que el cuartel exista y el estado sea 1.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla cuartel: ");
        }
    }

//----------------------------------------ELIMINAR CUARTEL---------------------------------------------------------
//------------------------selecciono cuartel a eliminar-----------------------------------------------------
    public int mostrarCuartelesAEliminar() {
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
    public void cambiarEstadoCuartel(int idCuartel) {
        String sql = "UPDATE cuartel SET estadoC = 0 WHERE idCuartel = ?";

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
//-------------------------------MODIFICAR------------------------------------
//-------------------------------Modificar cuartel---------------------------
//--------------modificar nombre---------------
//    public void modificarNombre(int idCuaM) {
//        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cuartel:");
//
//        String sql = "UPDATE cuartel SET nombreCuartel=? WHERE idCuartel=?";
//
//        try {
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setString(1, nuevoNombre);
//                ps.setInt(2, idCuaM);
//
//                int exito = ps.executeUpdate();
//                if (exito == 1) {
//                    JOptionPane.showMessageDialog(null, "Nombre del cuartel actualizado exitosamente.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el nombre del cuartel. Asegúrate de que el cuartel sea válido.");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al actualizar el nombre del cuartel.");
//        }
//    }
////--------------------------------------------------------------------------------
//
////-----------Modificar Direccion---------------------------
//    public void modificarDireccion(int idCuaM) {
//        String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección del cuartel:");
//
//        String sql = "UPDATE cuartel SET direccion=? WHERE idCuartel=?";
//
//        try {
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setString(1, nuevaDireccion);
//                ps.setInt(2, idCuaM);
//
//                int exito = ps.executeUpdate();
//                if (exito == 1) {
//                    JOptionPane.showMessageDialog(null, "Dirección del cuartel actualizada exitosamente.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la dirección del cuartel. Asegúrate de que el cuartel sea válido.");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al actualizar la dirección del cuartel: " + ex.getMessage());
//        }
//    }
////-----------------------Modificar coordX---------------------------------------------------------
//
//    public void modificarCoordX(int idCuaM) {
//        String nuevaCoordX = JOptionPane.showInputDialog("Ingrese la nueva cordenada X del cuartel:");
//
//        String sql = "UPDATE cuartel SET coordX=? WHERE idCuartel=?";
//
//        try {
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setString(1, nuevaCoordX);
//                ps.setInt(2, idCuaM);
//
//                int exito = ps.executeUpdate();
//                if (exito == 1) {
//                    JOptionPane.showMessageDialog(null, "Cordenada X actualizada exitosamente.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la cordenada X del cuartel. Asegúrate de que el cuartel sea válido.");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al actualizar la cordenada X: " + ex.getMessage());
//        }
//    }
//
////-----------------------Modificar coordX---------------------------------------------------------
//    public void modificarCoordY(int idCuaM) {
//        String nuevaCoordY = JOptionPane.showInputDialog("Ingrese la nueva cordenada Y del cuartel:");
//
//        String sql = "UPDATE cuartel SET coordY=? WHERE idCuartel=?";
//
//        try {
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setString(1, nuevaCoordY);
//                ps.setInt(2, idCuaM);
//
//                int exito = ps.executeUpdate();
//                if (exito == 1) {
//                    JOptionPane.showMessageDialog(null, "Cordenada Y actualizada exitosamente.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la cordenada Y del cuartel. Asegúrate de que el cuartel sea válido.");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al actualizar la cordenada Y: " + ex.getMessage());
//        }
//    }
//
////-----------------------Modificar Telefono---------------------------------------------------------
//    public void modificarTelefono(int idCuaM) {
//        String nuevoTel = JOptionPane.showInputDialog("Ingrese el nuevo telefono del cuartel:");
//
//        String sql = "UPDATE cuartel SET telefono=? WHERE idCuartel=?";
//
//        try {
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setString(1, nuevoTel);
//                ps.setInt(2, idCuaM);
//
//                int exito = ps.executeUpdate();
//                if (exito == 1) {
//                    JOptionPane.showMessageDialog(null, "Telefono del cuartel actualizado exitosamente.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el telefono del cuartel. Asegúrate de que el cuartel sea válido.");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al actualizar el telefono del cuartel: " + ex.getMessage());
//        }
//    }
//
////-----------------------Modificar Telefono---------------------------------------------------------
//    public void modificarCorreo(int idCuaM) {
//        String nvoCorreo = JOptionPane.showInputDialog("Ingrese el nuevo telefono del cuartel:");
//
//        String sql = "UPDATE cuartel SET correo=? WHERE idCuartel=?";
//
//        try {
//            try (PreparedStatement ps = con.prepareStatement(sql)) {
//                ps.setString(1, nvoCorreo);
//                ps.setInt(2, idCuaM);
//
//                int exito = ps.executeUpdate();
//                if (exito == 1) {
//                    JOptionPane.showMessageDialog(null, "Correo del cuartel actualizado exitosamente.");
//                } else {
//                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el correo del cuartel. Asegúrate de que el cuartel sea válido.");
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al actualizar el correo del cuartel: " + ex.getMessage());
//        }
//    }

//---------------------------------VISTAS--------------------------------------
    public List<Cuartel> datosTabla() {
        ArrayList<Cuartel> cuarteles = new ArrayList<>();
        String sql = "SELECT idCuartel, nombreCuartel FROM cuartel WHERE estadoC = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cuartel cuartel = new Cuartel();
                cuartel.setIdCuartel(rs.getInt("idCuartel"));
                cuartel.setNombreCuartel(rs.getString("Nombre Cuartel"));

                cuarteles.add(cuartel);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Inscripción");
        }
    return cuarteles;
    }

}

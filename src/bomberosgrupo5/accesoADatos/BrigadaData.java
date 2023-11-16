// Clase BrigadaData (Proyecto BomberosGrupo5)
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Brigada;
import bomberosgrupo5.entidades.Cuartel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class BrigadaData {

   private Connection con = null;
    public BrigadaData() {
       con=Conexion.getConexion();
    }

//------------------------------------------------------------------------------
//método guardar Brigada:
    public void guardarBrigada(Brigada brigada) {
        String sql = "INSERT INTO brigada (nombreBrig, especialidad, libre, idCuartel, estadoBr) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brigada.getNombreBrig());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getIdCuartel());
            ps.setBoolean(5, brigada.isEstadoBr());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet rs = ps.getGeneratedKeys();
                if (rs.next()) {
                    brigada.setIdBrigada(rs.getInt(1));
                    //JOptionPane.showMessageDialog(null, "Brigada Agregada Exitosamente");
                }
                ps.close();
            } else {
                JOptionPane.showMessageDialog(null, "La ID de brigada ya existe en la base de datos. No se pudo agregar la brigada.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla brigada: " + ex.getMessage());
        }
    }
//    public void guardarBrigada(Brigada brigada) {
//        String sql = "INSERT INTO brigada (nombreBrig, especialidad, libre, Cuartel, estadoBr) VALUES (?, ?, ?, ?, ?)";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//            ps.setString(1, brigada.getNombreBrig());
//            ps.setString(2, brigada.getEspecialidad());
//            ps.setBoolean(3, brigada.isLibre());
//            ps.setInt(4, brigada.getCuartel().getIdCuartel());
//            ps.setBoolean(5, brigada.isEstadoBr());
//
//            int rowsAffected = ps.executeUpdate();
//
//            if (rowsAffected > 0) {
//                ResultSet rs = ps.getGeneratedKeys();
//                if (rs.next()) {
//                    brigada.setIdBrigada(rs.getInt(1));
//                    JOptionPane.showMessageDialog(null, "Brigada Agregada Exitosamente");
//                }
//                ps.close();
//            } else {
//                JOptionPane.showMessageDialog(null, "La ID de brigada ya existe en la base de datos. No se pudo agregar la brigada.");
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla brigada: " + ex.getMessage());
//        }
//    }

//    ---------------------------------------------------------------------------------------
    public int obtenerIdBrigada(String nombreBrigada) {
        int idBrigada = -1; // Valor predeterminado si no se encuentra ninguna coincidencia

//    String sql = "SELECT Brigada FROM brigada WHERE nombreBrig = ?";
        String sql = "SELECT Brigada FROM brigada WHERE nombreBrig = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreBrigada);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idBrigada = rs.getInt("Brigada");
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            // Manejo de errores
            ex.printStackTrace();
        }

        return idBrigada;
    }

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone(); //To change body of generated methods, choose Tools | Templates.
//    }

//-------------------desde aca------------------------
    public int contarBrigadasPorCuartel(int numeroCuartel) {
        int cantidadBrigadas = 0;

        try {
            String sql = "SELECT COUNT(*) AS cantidad FROM brigada WHERE idCuartel = ? AND estadoBr = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numeroCuartel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cantidadBrigadas = rs.getInt("cantidad");
            }

            ps.close();
        } catch (SQLException ex) {
            // Manejar excepciones, por ejemplo, imprimir el error
            ex.printStackTrace();
        }
        //System.out.println("cant " + cantidadBrigadas);
        return cantidadBrigadas;
    }

    public boolean hayCupoParaNuevaBrigada(int numeroCuartel) {
        int cantidadBrigadas = contarBrigadasPorCuartel(numeroCuartel);
        int capacidadMaxima = 3; // Cambia esto según la capacidad máxima de brigadas por cuartel que desees

        return cantidadBrigadas < capacidadMaxima;
    }

//brigadas con el mismo nombre
    public boolean existeBrigadaConNombreEnCuartel(String nombreBrigada, int idCuartel) {
        String sql = "SELECT COUNT(*) FROM brigada WHERE nombreBrig = ? AND idCuartel = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreBrigada);
            ps.setInt(2, idCuartel);
            ResultSet rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                return true; // Ya existe una brigada con el mismo nombre en el cuartel especificado
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la brigada en el cuartel.");
        }
        return false; // No existe una brigada con el mismo nombre en el cuartel especificado
    }

//-----------------------metodo listar brigadas-----------------------------------------
    public int mostrarOpciones() {
        int idBrigadaElegida = -1; // Valor predeterminado para indicar que no se ha seleccionado ninguna brigada
        List<String> nombresBrigadas = new ArrayList<>();

        String sql = "SELECT idBrigada, nombreBrig FROM brigada WHERE estadoBr = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBrigada = rs.getInt("idBrigada");
                String nombreBrigada = rs.getString("nombreBrig");

                nombresBrigadas.add(idBrigada + ". " + nombreBrigada);
            }
            ps.close();

            if (!nombresBrigadas.isEmpty()) {
                String seleccion = (String) JOptionPane.showInputDialog(null,
                        "Elija una brigada:\n" + String.join("\n", nombresBrigadas),
                        "Selección de Brigada",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        nombresBrigadas.toArray(),
                        nombresBrigadas.get(0));

                if (seleccion != null) {
                    String[] parts = seleccion.split("\\. ");
                    if (parts.length == 2) {
                        idBrigadaElegida = Integer.parseInt(parts[0]);
                        System.out.println(" id " + idBrigadaElegida);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de brigadas: " + ex.getMessage());
        }

        return idBrigadaElegida;
    }
    //------------------------------Listar Especialidades------------------------

    public String elegirEspecialidad() {

        String[] especialidades = {"Incendios viviendas e Industrias", "Salvamento en derrumbes", "Rescates de montaña", "Rescate en accidente de transito", "Rerscate en inundaciones", "Operativos prevencion"};

        return (String) JOptionPane.showInputDialog(null,
                "Seleccione una especialidad:",
                "Selección de especialidad",
                JOptionPane.PLAIN_MESSAGE,
                null,
                especialidades,
                especialidades[0]);

    }


//-----------------------------------------------------------------------------------------
//-------------------buscar brigada por id-----------------
    public Brigada buscarBrigadaPorId(int idBrigada) {
        String sql = "SELECT nombreBrig, especialidad, libre, idCuartel, estadoBr FROM brigada WHERE idBrigada = ?";
        Brigada brigada = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                brigada = new Brigada();
                brigada.setIdBrigada(idBrigada);
                brigada.setNombreBrig(rs.getString("nombreBrig"));
                brigada.setEspecialidad(rs.getString("especialidad"));
                brigada.setLibre(rs.getBoolean("libre"));
                brigada.setEstadoBr(rs.getBoolean("estadoBr"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la brigada con el ID indicado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada: " + ex.getMessage());
        }

        return brigada;
    }
//------------------------------------------------------------------------------

//----------------------------Eliminar Brigada----------------------------
    //-------------Lista brigadas disponibles a eliminar----------------
    public int mostrarBrigadasAEliminar() {
        int idBrigadaAEliminar = -1; // Valor predeterminado para indicar que no se ha seleccionado ninguna brigada
        List<String> brigadasAEliminar = new ArrayList<>();

        String sql = "SELECT idBrigada, nombreBrig FROM brigada WHERE estadoBr = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBrigada = rs.getInt("idBrigada");
                String nombreBrigada = rs.getString("nombreBrig");

                brigadasAEliminar.add(idBrigada + ". Nombre: " + nombreBrigada);
            }
            ps.close();

            if (!brigadasAEliminar.isEmpty()) {
                String seleccion = (String) JOptionPane.showInputDialog(null,
                        "Elija una brigada a eliminar:\n" + String.join("\n", brigadasAEliminar),
                        "Selección de Brigada a Eliminar",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        brigadasAEliminar.toArray(),
                        brigadasAEliminar.get(0));

                if (seleccion != null) {
                    String[] parts = seleccion.split("\\. ");
                    if (parts.length == 2) {
                        idBrigadaAEliminar = Integer.parseInt(parts[0]);
                        System.out.println("ID de la Brigada a eliminar: " + idBrigadaAEliminar);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de brigadas a eliminar: " + ex.getMessage());
        }

        return idBrigadaAEliminar;
    }

    //------------------------------------------------------------------
//--------------eliminar brigada cambiando el estado------------------------------------------
    public void cambiarEstadoBrigada(int idBrigada) {
        String sql = "UPDATE brigada SET estadoBr = 0 WHERE idBrigada = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Brigada eliminada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar la brigada.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado de la brigada: " + ex.getMessage());
        }
    }

//--------------------------------------------------------------------------------------------
//------------------obtengo idBrigada teniendo idCuartel------------------------------------
    public List<Integer> obtenerIdsBrigadasPorIdCuartel(int idCuartel) {
        List<Integer> idsBrigadas = new ArrayList<>();

        String sql = "SELECT idBrigada FROM brigada WHERE idCuartel = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCuartel);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBrigada = rs.getInt("idBrigada");
                idsBrigadas.add(idBrigada);
            }

            ps.close();
        } catch (SQLException ex) {
            // Manejar excepciones, por ejemplo, imprimir el error
            ex.printStackTrace();
        }

        return idsBrigadas;
    }

//-----------------------------------------------------------------------------------------
//----------------------cambiar estado de brigadasss--------------------------------------
    public void cambiarEstadoBrigadas(List<Integer> idsBrigadas) {
        for (Integer idBrigada : idsBrigadas) {
            cambiarEstadoBrigada(idBrigada);
        }

        JOptionPane.showMessageDialog(null, "Brigadas eliminadas exitosamente.");
    }

//---------------------------------------------------------------------------------------
//----------------------MODIFICAR--------------------------------------------
//----------------------Modificar Nombre.--------------------------------
    public void modificarNombreBrigada(int idBrigM) {
        String nuevoNombreBrigada = JOptionPane.showInputDialog("Ingrese el nuevo nombre de la brigada:");

        String sql = "UPDATE brigada SET nombreBrig=? WHERE idBrigada=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, nuevoNombreBrigada);
            ps.setInt(2, idBrigM);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Nombre de la brigada actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el nombre de la brigada. Asegúrate de que la brigada sea válida.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el nombre de la brigada: " + ex.getMessage());
        }
    }

//----------------------Modificar Especialidad.--------------------------------
    public void modificarEspecialidad(int idBrigM, String especialidad) {

        String sql = "UPDATE brigada SET especialidad=? WHERE idBrigada=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, especialidad);
            ps.setInt(2, idBrigM);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Especialidad de la brigada actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la especialidad de la brigada. Asegúrate de que la brigada sea válida.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la especialidad de la brigada: " + ex.getMessage());
        }
       
    }

    
    //----------------------Modificar Estado(Libre/Ocupada).--------------------------------
    public void modificarEstado(int idBrigM, boolean nuevoEstado) {
        String sql = "UPDATE brigada SET libre=? WHERE idBrigada=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setBoolean(1, nuevoEstado);
            ps.setInt(2, idBrigM);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Estado de la brigada actualizado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado de la brigada. Asegúrate de que la brigada sea válida.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado de la brigada: " + ex.getMessage());
        }
    }

    //-----------------------------obtener Estado------------------------------
    public boolean obtenerEstado() {
        int opcion = 0;
        boolean nuevoEstado = false;

        while (opcion != 1 && opcion != 2) {
            String input = JOptionPane.showInputDialog("Ingrese el nuevo estado:\n1. Ocupada (false)\n2. Desocupada (true)");
            opcion = Integer.parseInt(input);

            switch (opcion) {
                case 1:
                    nuevoEstado = false;
                    break;
                case 2:
                    nuevoEstado = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 2 para 'Ocupada' o 1 para 'Desocupada'.");
                    break;
            }
        }

        return nuevoEstado;
    }

//---------------------------------------------------- SINIESTRO ----------------------------------------------------
//--------------------------------- AGREGAR SINIESTRO: listar brigadas libre---------------------------------------
    public int brigadasLibres() {
        int idBrigadaElegida = -1; // Valor predeterminado para indicar que no se ha seleccionado ninguna brigada
        List<String> nombresBrigadas = new ArrayList<>();

        String sql = "SELECT idBrigada, nombreBrig FROM brigada WHERE estadoBr = 1 and libre = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBrigada = rs.getInt("idBrigada");
                String nombreBrigada = rs.getString("nombreBrig");

                nombresBrigadas.add(idBrigada + ". " + nombreBrigada);
            }
            ps.close();

            if (!nombresBrigadas.isEmpty()) {
                String seleccion = (String) JOptionPane.showInputDialog(null,
                        "Elija una brigada:\n" + String.join("\n", nombresBrigadas),
                        "Selección de Brigada",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        nombresBrigadas.toArray(),
                        nombresBrigadas.get(0));

                if (seleccion != null) {
                    String[] parts = seleccion.split("\\. ");
                    if (parts.length == 2) {
                        idBrigadaElegida = Integer.parseInt(parts[0]);
                        System.out.println(" id " + idBrigadaElegida);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay brigadas disponibles para asignar un siniestro. El programa se cerrará.");
                System.exit(0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de brigadas: " + ex.getMessage());
        }

        return idBrigadaElegida;
    }

//----------------------------------------------------------------------------------------------------------------   
//-------------------------brigada ocupada-------------------------------------------------------------------------
    public void brigadaOcupada(int idBrigada) {
        String sql = "UPDATE brigada SET libre=0 WHERE idBrigada=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idBrigada);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Brigada ocupada desde ahora");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el estado de la brigada. Asegúrate de que la brigada sea válida.");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado de la brigada: " + ex.getMessage());
        }
    }

//----------------------------------------------------------------------------------------------------------------- 
    
//--------------------------------------- OPCION ELIMINAR SINIESTRO--------------------------------------------------------
//--------------------------libero brigada---------------------------------------------

public void marcarBrigadaComoLibre(int idBrigada) {
    String sql = "UPDATE brigada SET libre = 1 WHERE idBrigada = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idBrigada);

        int filasAfectadas = ps.executeUpdate();

        if (filasAfectadas > 0) {
            JOptionPane.showMessageDialog(null, "Brigada libre");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró la Brigada con ID: " + idBrigada);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al marcar la Brigada como libre: " + ex.getMessage());
    }
}

//------------------------------------------------------------------------------------  
//--------------------------------------FIN OPCION ELIMINAR SINIESTRO-------------------------------------------------------
}

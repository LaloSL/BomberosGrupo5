// Clase SiniestroData:
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Cuartel;
import bomberosgrupo5.entidades.Siniestro;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SiniestroData {

    private Connection con;

    public SiniestroData(Connection con) {
        this.con = con;
    }

//------------------------------------------------------------------------------    
//   para que no me modifique la hora en la base ejecute (donde se hace inser, update, etc)
//   ALTER TABLE siniestro MODIFY COLUMN fechaSiniestro DATETIME DEFAULT NULL;
//Esto eliminará cualquier valor predeterminado y permitirá que la columna acepte valores NULL si es necesario. 
//------------------------------------------------------------------------------
//----------------------- convertir fecha y hora ------------------------------
    public LocalDateTime convertirAFechaHora(String fechaHora) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.parse(fechaHora, formatter);
    }

//-----------------------------------------------------------------------------
//---------------------------insertar siniestro-------------------------------
public void insertarSiniestro(Connection con, int idBrigada, String tipo, LocalDateTime fechaHoraSiniestro, int coordx, int coordy, String detalles, LocalDateTime fechaHoraResol, int puntuacion) throws SQLException {
    String consulta = "INSERT INTO siniestro (idBrigada, tipo, fechaSiniestro, coordx, coordy, detalles, fechaResol, puntuacion, estadoS) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, 1)"; 

    try (PreparedStatement statement = con.prepareStatement(consulta)) {
        statement.setInt(1, idBrigada);
        statement.setString(2, tipo);
        statement.setTimestamp(3, Timestamp.valueOf(fechaHoraSiniestro));
        statement.setInt(4, coordx);
        statement.setInt(5, coordy);
        statement.setString(6, detalles);
        statement.setTimestamp(7, (fechaHoraResol != null) ? Timestamp.valueOf(fechaHoraResol) : null);
        statement.setInt(8, puntuacion);

        int filasAfectadas = statement.executeUpdate();

        if (filasAfectadas > 0) {
            System.out.println("Siniestro registrado con éxito.");
        } else {
            System.out.println("No se registró ningún siniestro.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        System.out.println("Error al insertar el siniestro en la base de datos.");
    }
}

//----------------------------------------------------------------------------
//--------------------------------MODIFICAR SINIESTRO------------------------
//--------------------lista los siniestros----------------------------------
    public int mostrarOpcionesSiniestros(Connection con) {
        int idSiniestroElegido = -1; // Valor predeterminado para indicar que no se ha seleccionado ningún siniestro
        List<String> opcionesSiniestros = new ArrayList<>();

        String sql = "SELECT idCodigo, tipo, detalles FROM siniestro";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idSiniestro = rs.getInt("idCodigo");
                String tipoSiniestro = rs.getString("tipo");
                String detallesSiniestro = rs.getString("detalles");

                opcionesSiniestros.add(idSiniestro + ". Tipo: " + tipoSiniestro + ", Detalles: " + detallesSiniestro);
            }
            ps.close();

            if (!opcionesSiniestros.isEmpty()) {
                String seleccion = (String) JOptionPane.showInputDialog(null,
                        "Elija un siniestro:\n" + String.join("\n", opcionesSiniestros),
                        "Selección de Siniestro",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcionesSiniestros.toArray(),
                        opcionesSiniestros.get(0));

                if (seleccion != null) {
                    String[] parts = seleccion.split("\\. ");
                    if (parts.length == 2) {
                        idSiniestroElegido = Integer.parseInt(parts[0]);
                        System.out.println(" id " + idSiniestroElegido);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay siniestros disponibles para asignar a una brigada. El programa se cerrará.");
                System.exit(0);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener opciones de siniestros: " + ex.getMessage());
        }

        return idSiniestroElegido;
    }

//--------------------------------------------------------------------------
//--------------------modificar tipo---------------------------------------
    public void modificarTipoSiniestro(int idSiniestro, Connection con) {
        try {
            String nuevoTipoSiniestro = JOptionPane.showInputDialog("Ingrese el nuevo tipo de siniestro:");
            String sql = "UPDATE siniestro SET tipo=? WHERE idCodigo=?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nuevoTipoSiniestro);
                ps.setInt(2, idSiniestro);

                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Tipo de siniestro actualizado exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar el tipo de siniestro. Asegúrate de que el siniestro sea válido.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el tipo de siniestro: " + ex.getMessage());
        }
    }

//-------------------------------------------------------------------------
//----------------------- modificar fecha----------------------------------
    public void modificarFechaSiniestro(int idSiniestro, Connection con) {
    try {
        String nuevaFechaSiniestro = JOptionPane.showInputDialog("Ingrese la nueva fecha de siniestro (dd/MM/yyyy HH:mm):");

        // de String a LocalDateTime
        LocalDateTime fechaSiniestroLocalDateTime = null;
        try {
            fechaSiniestroLocalDateTime = convertirAFechaHora(nuevaFechaSiniestro);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha de siniestro: " + e.getMessage());
            return;
        }

        String sql = "UPDATE siniestro SET fechaSiniestro=? WHERE idCodigo=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            // Asegura que se pase un valor null si fechaSiniestroLocalDateTime es null
            ps.setObject(1, (fechaSiniestroLocalDateTime != null) ? Timestamp.valueOf(fechaSiniestroLocalDateTime) : null);
            ps.setInt(2, idSiniestro);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Fecha de siniestro actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la fecha de siniestro. Asegúrate de que el siniestro sea válido.");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la fecha de siniestro: " + ex.getMessage());
    }
}

//    public void modificarFechaSiniestro(int idSiniestro, Connection con) {
//    try {
//        String nuevaFechaSiniestro = JOptionPane.showInputDialog("Ingrese la nueva fecha de siniestro (dd/MM/yyyy HH:mm):");
//
//        // de String a LocalDateTime
//        LocalDateTime fechaSiniestroLocalDateTime = null;
//        try {
//            fechaSiniestroLocalDateTime = convertirAFechaHora(nuevaFechaSiniestro);
//        } catch (ParseException e) {
//            JOptionPane.showMessageDialog(null, "Error al convertir la fecha de siniestro: " + e.getMessage());
//            return;
//        }
//
//        String sql = "UPDATE siniestro SET fechaSiniestro=? WHERE idCodigo=?";
//
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setObject(1, fechaSiniestroLocalDateTime);
//            ps.setInt(2, idSiniestro);
//
//            int exito = ps.executeUpdate();
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Fecha de siniestro actualizada exitosamente.");
//            } else {
//                JOptionPane.showMessageDialog(null, "No se pudo actualizar la fecha de siniestro. Asegúrate de que el siniestro sea válido.");
//            }
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al actualizar la fecha de siniestro: " + ex.getMessage());
//    }
//}

//-------------------------------------------------------------------------
//----------------------modificar coordenada X----------------------------
    public void modificarCoordenadaX(int idSiniestro, Connection con) {
        try {
            String nuevaCoordenadaXStr = JOptionPane.showInputDialog("Ingrese la nueva coordenada X:");
            double nuevaCoordenadaX = Double.parseDouble(nuevaCoordenadaXStr);

            String sql = "UPDATE siniestro SET coordx=? WHERE idCodigo=?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, nuevaCoordenadaX);
                ps.setInt(2, idSiniestro);

                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Coordenada X del siniestro actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la coordenada X del siniestro. Asegúrate de que el siniestro sea válido.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la nueva coordenada X. Asegúrate de ingresar un valor numérico.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la coordenada X del siniestro: " + ex.getMessage());
        }
    }

//------------------------------------------------------------------------
//----------------------------modificar coordenada Y----------------------
    public void modificarCoordenadaY(int idSiniestro, Connection con) {
        try {
            String nuevaCoordenadaYStr = JOptionPane.showInputDialog("Ingrese la nueva coordenada Y:");
            double nuevaCoordenadaY = Double.parseDouble(nuevaCoordenadaYStr);

            String sql = "UPDATE siniestro SET coordy=? WHERE idCodigo=?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setDouble(1, nuevaCoordenadaY);
                ps.setInt(2, idSiniestro);

                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Coordenada Y del siniestro actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la coordenada Y del siniestro. Asegúrate de que el siniestro sea válido.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la nueva coordenada Y. Asegúrate de ingresar un valor numérico.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la coordenada Y del siniestro: " + ex.getMessage());
        }
    }

//------------------------------------------------------------------------
//---------------------------modificar detalles---------------------------
    public void modificarDetallesSiniestro(int idSiniestro, Connection con) {
        try {
            String nuevosDetalles = JOptionPane.showInputDialog("Ingrese los nuevos detalles del siniestro:");

            String sql = "UPDATE siniestro SET detalles=? WHERE idCodigo=?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nuevosDetalles);
                ps.setInt(2, idSiniestro);

                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Detalles del siniestro actualizados exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar los detalles del siniestro. Asegúrate de que el siniestro sea válido.");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar los detalles del siniestro: " + ex.getMessage());
        }
    }

//------------------------------------------------------------------------
//-------------------- modoficar fecha de resolucion ---------------------
    public void modificarFechaResolucion(int idSiniestro, Connection con) {
    try {
        String nuevaFechaResolucionStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de resolución (dd/MM/yyyy HH:mm):");

        // de String a LocalDateTime
        LocalDateTime nuevaFechaResolucion = null;
        try {
            nuevaFechaResolucion = convertirAFechaHora(nuevaFechaResolucionStr);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Error al convertir la fecha de resolución: " + e.getMessage());
            return;
        }

        String sql = "UPDATE siniestro SET fechaResol=? WHERE idCodigo=?";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, Timestamp.valueOf(nuevaFechaResolucion));
            ps.setInt(2, idSiniestro);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Fecha de resolución del siniestro actualizada exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar la fecha de resolución del siniestro. Asegúrate de que el siniestro sea válido.");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la fecha de resolución del siniestro: " + ex.getMessage());
    }
}


//------------------------------------------------------------------------
//------------------------- modificar puntuacion -------------------------
    public void modificarPuntuacion(int idSiniestro, Connection con) {
        try {
            String nuevaPuntuacionStr = JOptionPane.showInputDialog("Ingrese la nueva puntuación:");
            int nuevaPuntuacion = Integer.parseInt(nuevaPuntuacionStr);

            String sql = "UPDATE siniestro SET puntuacion=? WHERE idCodigo=?";

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, nuevaPuntuacion);
                ps.setInt(2, idSiniestro);

                int exito = ps.executeUpdate();
                if (exito == 1) {
                    JOptionPane.showMessageDialog(null, "Puntuación del siniestro actualizada exitosamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo actualizar la puntuación del siniestro. Asegúrate de que el siniestro sea válido.");
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar la nueva puntuación. Asegúrate de ingresar un valor numérico.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la puntuación del siniestro: " + ex.getMessage());
        }
    }

//-----------------------------------------------------------------------
//--------------------------------FIN MODIFICAR SINIESTRO--------------------
//-----------------------------ELIMINAR SINIESTRO------------------
//--------------------------listar siniestro para devuelve idCodigo-------------
    public int mostrarSiniestros(Connection con) {
        int idSiniestroSeleccionado = -1;
        List<String> siniestros = new ArrayList<>();

        String sql = "SELECT idCodigo, detalles FROM siniestro WHERE estadoS = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idSiniestro = rs.getInt("idCodigo");
                String detalles = rs.getString("detalles");

                siniestros.add(idSiniestro + ". Detalles: " + detalles);
            }
            ps.close();

            if (!siniestros.isEmpty()) {
                String seleccion = (String) JOptionPane.showInputDialog(null,
                        "Elija un siniestro:\n" + String.join("\n", siniestros),
                        "Selección de Siniestro",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        siniestros.toArray(),
                        siniestros.get(0));

                if (seleccion != null) {
                    String[] parts = seleccion.split("\\. ");
                    if (parts.length == 2) {
                        idSiniestroSeleccionado = Integer.parseInt(parts[0]);
                        System.out.println("ID del Siniestro seleccionado: " + idSiniestroSeleccionado);
                    }
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la lista de siniestros: " + ex.getMessage());
        }

        return idSiniestroSeleccionado;
    }

//---------------------------------------------------------------------------
//-------------------------recuperar idBrigada desde idCodigo-------------------------
    public int obtenerIdBrigadaPorIdSiniestro(Connection con, int idSiniestro) {
        int idBrigada = -1;

        String sql = "SELECT idBrigada FROM siniestro WHERE idCodigo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idSiniestro);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                idBrigada = rs.getInt("idBrigada");
                System.out.println("ID de la Brigada asociada al Siniestro: " + idBrigada);
            } else {
                System.out.println("No se encontró el siniestro con ID: " + idSiniestro);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener el ID de la Brigada: " + ex.getMessage());
        }

        return idBrigada;
    }

//------------------------------------------------------------------------------------
//------------------eliminar siniestro-------------------------------------------------
    public void eliminarSiniestro(Connection con, int idCodigo) {
        String sql = "UPDATE siniestro SET estadoS = 0 WHERE idCodigo = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCodigo);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Siniestro eliminado.");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un siniestro con el ID indicado.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el estado del siniestro: " + ex.getMessage());
        }
    }

//-------------------------------------------------------------------------------------
//-----------------------------FIN ELIMINAR SINIESTRO-----------------------------
}

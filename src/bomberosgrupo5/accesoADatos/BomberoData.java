// Clase BrigadaData (proyecto BomberosGrupo5)
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Bombero;
import bomberosgrupo5.entidades.Cuartel;
import bomberosgrupo5.entidades.Brigada;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BomberoData {

    private Connection con = null;
    public BomberoData() {
       con=Conexion.getConexion();
    }

//-------------------GUARDAR BOMBERO---------------------------------------------------------
    public void guardarBombero(Bombero bombero) {

        String sql = "INSERT INTO bombero (dni, nombreApellido, grupoSanguineo, fechaNac, celular, idBrigada, estadoB)"
                + "VALUE(?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, bombero.getDni());
            ps.setString(2, bombero.getNombreApellido());
            ps.setString(3, bombero.getGrupoSanguineo());
            ps.setDate(4, Date.valueOf(bombero.getFechaNac()));
            ps.setString(5, bombero.getCelular());
            ps.setInt(6, bombero.getIdBrigada());

            ps.setBoolean(7, bombero.isEstadoB());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                bombero.setIdBombero(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Bombero Agregado Exitosamente ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla bombero ");
        }

    }
// public void guardarBombero(int dni, String nombreApellido, String grupoSanguineo, LocalDate fechaNac, String celular,boolean estadoB,int idBrigada) {
//
//    String sql = "INSERT INTO bombero (dni, nombreApellido, grupoSanguineo, fechaNac, celular, idBrigada, estadoB)"
//            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//        ps.setInt(1, dni);
//        ps.setString(2, nombreApellido);
//        ps.setString(3, grupoSanguineo);
//        ps.setDate(4, Date.valueOf(fechaNac));
//        ps.setString(5, celular);
//        ps.setInt(6, idBrigada);
//        ps.setBoolean(7, estadoB);
//
//        ps.executeUpdate();
//
//        ResultSet rs = ps.getGeneratedKeys();
//
//        if (rs.next()) {
//            int idBombero = rs.getInt(1);
//            JOptionPane.showMessageDialog(null, "Bombero Agregado Exitosamente con ID: " + idBombero);
//        }
//        ps.close();
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla bombero: " + ex.getMessage());
//    }
//}
//------------------------------------------------------------------------------------------------------
//    
//-------------------------------------------------------------------------------------------------
    public Bombero buscarBomberoId(int idBombero) {
        String sql = "SELECT dni, nombreApellido, grupoSanguineo, fechaNac, celular, idBrigada, estadoB FROM bombero WHERE idBombero = ? AND estadoB = 1";
        Bombero bombero = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBombero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bombero = new Bombero();
                bombero.setIdBombero(idBombero);
                bombero.setDni(rs.getInt("dni"));
                bombero.setNombreApellido(rs.getString("nombreApellido"));
                bombero.setGrupoSanguineo(rs.getString("grupoSanguineo"));
                bombero.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                bombero.setCelular(rs.getString("celular"));
                bombero.setIdBrigada(rs.getInt("idBrigada"));
                bombero.setEstadoB(rs.getBoolean("estadoB"));

                // Imprimir el bombero recuperado antes del return
//                System.out.println("Bombero recuperado:");
//                System.out.println(bombero);
            } else {
                JOptionPane.showMessageDialog(null, "No existe el bombero con el ID indicado");
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero: " + ex.getMessage());
            bombero = null; // Asignar null en caso de excepción
        }

        return bombero;
    }

//     public Bombero  buscarBomberoId (int idBombero, Connection con){
//        
//        String sql = "SELECT dni, nombreApellido, fechaNac, celular, idBrigada FROM bombero WHERE idBombero = ? and estadoB = 1";
//        Bombero bombero =null;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);            
//            ps.setInt(1, idBombero);
//            ResultSet rs=ps.executeQuery();      
//            if(rs.next()){
//                bombero=new Bombero();
//                bombero.setDni(rs.getInt("dni"));
//                bombero.setNombreApellido(rs.getString("nombreApellido"));
//                bombero.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
//                bombero.setCelular(rs.getString("celular"));
//                bombero.setBrigada((Brigada) rs.getObject("idBrigada"));
//                bombero.isEstadoB();
//              
//            }else{
//                JOptionPane.showMessageDialog(null, "No existe el bombero con el ID indicado");
//            }
//            ps.close();
//        
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
//        }
//        return bombero;               
//      }
//-----------------------------------------------------------------------------------------------------     
//-------------------------------
    public Bombero buscarBomberoPorDni(int dni) {

        Bombero bomberoEncontrado = null;
        String sql = "SELECT * FROM bombero WHERE dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Si se encuentra un bombero con el DNI especificado, crea un objeto Bombero con los datos obtenidos de la base de datos
                bomberoEncontrado = new Bombero(
                        rs.getInt("dni"),
                        rs.getString("nombreApellido"),
                        rs.getString("grupoSanguineo"),
                        rs.getDate("fechaNac").toLocalDate(),
                        rs.getString("celular"),
                        //null, // Aquí deberías obtener la brigada asociada, si la tienes en la base de datos
                        rs.getBoolean("estadoBom")
                );

                // Formatea la información del bombero como una cadena de texto
                String infoBombero = "DNI: " + bomberoEncontrado.getDni() + "\n"
                        + "Nombre y Apellido: " + bomberoEncontrado.getNombreApellido() + "\n"
                        + "Grupo Sanguíneo: " + bomberoEncontrado.getGrupoSanguineo() + "\n"
                        + "Fecha de Nacimiento: " + bomberoEncontrado.getFechaNac() + "\n"
                        + "Celular: " + bomberoEncontrado.getCelular() + "\n"
                        + "Estado: " + (bomberoEncontrado.isEstadoB() ? "Activo" : "Inactivo");

                JOptionPane.showMessageDialog(null, "Información del Bombero:\n" + infoBombero);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró un bombero con el DNI especificado.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar al bombero por DNI: " + ex.getMessage());
        }

        return bomberoEncontrado;
    }

//---------------------------------------------------------------------------------------------------
//------------------------------------------------------------------------------
    public boolean existeBomberoConNombre(String nombreApellido, int dni) {
        boolean existe = false;
        String sql = "SELECT COUNT(*) FROM bombero WHERE nombreApellido = ? AND dni = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreApellido);
            ps.setInt(2, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    existe = true;
                }
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {

        }

        return existe;
    }

    //-----------------------------------------
//----------------cuenta bombero segun idBrigada  y cupo de bomberos------------
    public int contarBomberosPorBrigada(int idBrigada) {
        int cantidadBomberos = 0;

        try {
            String sql = "SELECT COUNT(*) AS cantidad FROM bombero WHERE idBrigada = ? AND estadoB = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cantidadBomberos = rs.getInt("cantidad");
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("cant: " + cantidadBomberos);
        return cantidadBomberos;
    }

    public boolean hayCupoParaNuevoBombero(int idBrigada) {
        int cantidadBbomberos = contarBomberosPorBrigada(idBrigada);
        int capacidadMaxima = 3; // CAPACIDAD BRIGADA

        return cantidadBbomberos < capacidadMaxima;
    }
//-----------------------------------------------------------------------

//---------------------------------ELIMINAR--------------------------------
//-----------------------Listo los bomberos para seleccionar al que van a eliminar
    public List<String> mostrarBomberosAEliminar() {
        
       List<String> nombreBombero = new ArrayList<>();

    String sql = "SELECT idBombero, nombreApellido FROM bombero WHERE estadoB = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idBrigada = rs.getInt("idBombero");
            String nombreBrig = rs.getString("nombreApellido");

            nombreBombero.add(idBrigada + ". " + nombreBrig);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener nombres de bomberos: " + ex.getMessage());
    }

    return nombreBombero; 
        
        
        
//        int idBomberoAEliminar = -1;
//        List<String> bomberosAEliminar = new ArrayList<>();
//
//        String sql = "SELECT idBombero, dni, nombreApellido FROM bombero WHERE estadoB = 1";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                int idBombero = rs.getInt("idBombero");
//                int dniBombero = rs.getInt("dni");
//                String nombreApellido = rs.getString("nombreApellido");
//
//                bomberosAEliminar.add(idBombero + ". DNI: " + dniBombero + ", Nombre: " + nombreApellido);
//            }
//            ps.close();
//
//            if (!bomberosAEliminar.isEmpty()) {
//                String seleccion = (String) JOptionPane.showInputDialog(null,
//                        "Elija un bombero a eliminar:\n" + String.join("\n", bomberosAEliminar),
//                        "Selección de Bombero a Eliminar",
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        bomberosAEliminar.toArray(),
//                        bomberosAEliminar.get(0));
//
//                if (seleccion != null) {
//                    String[] parts = seleccion.split("\\. ");
//                    if (parts.length == 2) {
//                        idBomberoAEliminar = Integer.parseInt(parts[0]);
//                        System.out.println("ID del Bombero a eliminar: " + idBomberoAEliminar);
//                    }
//                }
//            }
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al obtener la lista de bomberos a eliminar: " + ex.getMessage());
//        }
//
//        return idBomberoAEliminar;
    }

//-------------------------------------------------------------------------------
//--------------CAMBIO EL ESTADO DE UN BOMBERO-------------
    public void cambiarEstadoBombero(int idBombero) {
        String sql = "UPDATE bombero SET estadoB = 0 WHERE idBombero = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBombero);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Bombero eliminado exitosamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar al bombero.");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cambiar el estado del bombero: " + ex.getMessage());
        }
    }

//---------------------------------------------------------------------------------------------------
//-------------averiguo bomberos que pertenecen a una misma brigada -----------------------
    
    public List<Integer> obtenerIDsBomberosPorBrigada(int idBrigada) {
    List<Integer> idsBomberos = new ArrayList<>();

    String sql = "SELECT idBombero FROM bombero WHERE idBrigada = ? AND estadoB = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idBrigada);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idBombero = rs.getInt("idBombero");
            idsBomberos.add(idBombero);
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener los IDs de los bomberos de la brigada: " + ex.getMessage());
    }

    return idsBomberos;
}
//    public List<Bombero> obtenerBomberosPorBrigada(int idBrigada) {
//        List<Bombero> bomberos = new ArrayList<>();
//
//        String sql = "SELECT * FROM bombero WHERE idBrigada = ? AND estadoB = 1";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idBrigada);
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()) {
//                Bombero bombero = new Bombero();
//            bombero.setIdBombero(rs.getInt("idBombero"));
//            bombero.setDni(rs.getInt("dni"));
//            bombero.setNombreApellido(rs.getString("nombreApellido"));
//            bombero.setGrupoSanguineo(rs.getString("grupoSanguineo"));
//            bombero.setFechaNac(rs.getDate("fechaNac").toLocalDate());
//            bombero.setCelular(rs.getString("celular"));
//            bombero.setEstadoB(rs.getBoolean("estadoB"));
//
//            bomberos.add(bombero);
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al obtener los IDs de los bomberos de la brigada: " + ex.getMessage());
//        }
//
//        return bomberos;
//    }
//------------Borrado logico de bomberos que pertenecen a un brigada--------------
    
    public void cambiarEstadoBomberosPorBrigada(int idBrigada) {
    // Obtener la lista de IDs de bomberos que pertenecen a la brigada
    List<Integer> idsBomberosAEliminar = obtenerIDsBomberosPorBrigada(idBrigada);

    for (Integer idBombero : idsBomberosAEliminar) {
        cambiarEstadoBombero(idBombero);
    }
}
//
//    public void cambiarEstadoBomberosPorBrigada(int idBrigada) {
//        // Obtener la lista de IDs de bomberos que pertenecen a la brigada
//        List<Integer> idsBomberosAEliminar = obtenerBomberosPorBrigada(idBrigada);
//
//        for (Integer idBombero : idsBomberosAEliminar) {
//            cambiarEstadoBombero(idBombero);
//        }
//
//        //JOptionPane.showMessageDialog(null, "Bomberos eliminados exitosamente.");
//    }

//-------------------------------------
//---------------------cambiar estados de bomberos en brigadas--------------
//    public void cambiarEstadoBomberosPorBrigadas(List<Integer> idsBrigadas) {
//        for (Integer idBrigada : idsBrigadas) {
//            List<Integer> idsBomberosAEliminar = obtenerBomberosPorBrigada(idBrigada);
//
//            for (Integer idBombero : idsBomberosAEliminar) {
//                cambiarEstadoBombero(idBombero);
//            }
//        }
//
//        //JOptionPane.showMessageDialog(null, "Bomberos eliminados exitosamente.");
//    }

//------------------------------------------------------------------------
//-------------------------------MODIFICAR BOMBEROS----------------------------
//-----------------------opciones de bomberos a modificar-----------------
    public List<String> mostrarOpcionesBomberos() {
       // int idBomberoElegido = -1; // Valor predeterminado para indicar que no se ha seleccionado ningún bombero
        List<String> nombresBomberos = new ArrayList<>();

        String sql = "SELECT idBombero, nombreApellido FROM bombero WHERE estadoB = 1";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int idBombero = rs.getInt("idBombero");
                String nombreBombero = rs.getString("nombreApellido");

                nombresBomberos.add(idBombero + ". " + nombreBombero);
            }
            ps.close();

//            if (!nombresBomberos.isEmpty()) {
//                String seleccion = (String) JOptionPane.showInputDialog(null,
//                        "Elija un bombero:\n" + String.join("\n", nombresBomberos),
//                        "Selección de Bombero",
//                        JOptionPane.PLAIN_MESSAGE,
//                        null,
//                        nombresBomberos.toArray(),
//                        nombresBomberos.get(0));
//
//                if (seleccion != null) {
//                    String[] parts = seleccion.split("\\. ");
//                    if (parts.length == 2) {
//                        idBomberoElegido = Integer.parseInt(parts[0]);
//                        System.out.println(" id " + idBomberoElegido);
//                    }
//                }
//            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener nombres de bomberos: " + ex.getMessage());
        }

        return nombresBomberos;
    }

//------------------------------------------------------------------------
//---------------------- buscarbombero por id (MODOFICAR)---------------------
    public Bombero buscarBomberoPorId(int idBombero) {
        String sql = "SELECT nombreApellido, grupoSanguineo, fechaNac, celular FROM bombero WHERE idBombero = ?";
        Bombero bombero = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBombero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bombero = new Bombero();
                bombero.setIdBombero(idBombero);
                
                bombero.setNombreApellido(rs.getString("nombreApellido"));
                bombero.setGrupoSanguineo(rs.getString("grupoSanguineo"));
                bombero.setFechaNac(rs.getDate("fechaNac").toLocalDate());
                bombero.setCelular(rs.getString("celular"));
                

                // Imprimir información del bombero
                System.out.println("Información del Bombero:");
                
                
                System.out.println("Nombre: " + bombero.getNombreApellido());
                System.out.println("grupoS: " + bombero.getGrupoSanguineo());
                System.out.println("fechaN: " + bombero.getFechaNac());
                System.out.println("cel: " + bombero.getCelular());
                
                // Agrega más líneas para imprimir otros atributos según sea necesario
            } else {
                JOptionPane.showMessageDialog(null, "No existe el bombero con el ID indicado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero: " + ex.getMessage());
        }

        // Imprimir mensaje si no se encuentra el bombero
        if (bombero == null) {
            System.out.println("No se encontró el bombero con el ID indicado.");
        }

        // Devolver el bombero (puede ser null si no se encontró)
        return bombero;
    }

//-------------------------------------------------------------------------
    
//---------------------modificar nombre y apellido de bomberos--------------
 public void modificarBombero(int idBombero, int dni, String nombreApellido, String grupoSanguineo, LocalDate fechaNac, String celular) {
    

    String sql = "UPDATE bombero SET dni=?, nombreApellido=?, grupoSanguineo=?, fechaNac=?, celular=?  WHERE idBombero=?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, dni);
        ps.setString(2, nombreApellido);
        ps.setString(3, grupoSanguineo);
        ps.setDate(4, Date.valueOf(fechaNac));
        ps.setString(5, celular);
        ps.setInt(6, idBombero);
        
        int exito = ps.executeUpdate();
        if (exito == 1) {
            JOptionPane.showMessageDialog(null, "Bombero actualizado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo actualizar el nombre del bombero. Asegúrate de que el bombero sea válido.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el nombre del bombero: " + ex.getMessage());
    }
}
   
    
//--------------------------------------------------------------------------
 
//--------------------------modificar grupo sanguineo-----------------------
//public void modificarGrupoSanguineoBombero(int idBombero) {
//    String nuevoGrupoSanguineo = JOptionPane.showInputDialog("Ingrese el nuevo grupo sanguíneo del bombero:");
//
//    String sql = "UPDATE bombero SET grupoSanguineo=? WHERE idBombero=?";
//
//    try (PreparedStatement ps = con.prepareStatement(sql)) {
//        ps.setString(1, nuevoGrupoSanguineo);
//        ps.setInt(2, idBombero);
//
//        int exito = ps.executeUpdate();
//        if (exito == 1) {
//            JOptionPane.showMessageDialog(null, "Grupo sanguíneo del bombero actualizado exitosamente.");
//        } else {
//            JOptionPane.showMessageDialog(null, "No se pudo actualizar el grupo sanguíneo del bombero. Asegúrate de que el bombero sea válido.");
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al actualizar el grupo sanguíneo del bombero: " + ex.getMessage());
//    }
//}


//------------------------------------------------------------------------- 

//--------------------modificar fecha de nacimiento------------------------
//public void modificarFechaNacimientoBombero(int idBombero) {
//    try {
//        String nuevaFechaNacimientoStr = JOptionPane.showInputDialog("Ingrese la nueva fecha de nacimiento del bombero (formato: yyyy-MM-dd):");
//
//        // de String a un objeto LocalDate
//        LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoStr);
//
//        String sql = "UPDATE bombero SET fechaNac=? WHERE idBombero=?";
//
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setDate(1, java.sql.Date.valueOf(nuevaFechaNacimiento));
//            ps.setInt(2, idBombero);
//
//            int exito = ps.executeUpdate();
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Fecha de nacimiento del bombero actualizada exitosamente.");
//            } else {
//                JOptionPane.showMessageDialog(null, "No se pudo actualizar la fecha de nacimiento del bombero. Asegúrate de que el bombero sea válido.");
//            }
//        }
//    } catch (DateTimeParseException ex) {
//        JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Utiliza el formato yyyy-MM-dd.");
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al actualizar la fecha de nacimiento del bombero: " + ex.getMessage());
//    }
//}


//-------------------------------------------------------------------------

////-----------------------modificar numero celular--------------------------
//public void modificarNumeroCelularBombero(int idBombero) {
//    try {
//        String nuevoNumeroCelular = JOptionPane.showInputDialog("Ingrese el nuevo número de celular del bombero:");
//        String sql = "UPDATE bombero SET celular=? WHERE idBombero=?";
//
//        try (PreparedStatement ps = con.prepareStatement(sql)) {
//            ps.setString(1, nuevoNumeroCelular);
//            ps.setInt(2, idBombero);
//
//            int exito = ps.executeUpdate();
//            if (exito == 1) {
//                JOptionPane.showMessageDialog(null, "Número de celular del bombero actualizado exitosamente.");
//            } else {
//                JOptionPane.showMessageDialog(null, "No se pudo actualizar el número de celular del bombero. Asegúrate de que el bombero sea válido.");
//            }
//        }
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al actualizar el número de celular del bombero: " + ex.getMessage());
//    }
//}
//


//-------------------------------------------------------------------------
 
//---------------------------------------------------------------------------
 
// //-----------------Bomberos por brigada ViewConsultar-------------------------------
// 
// public List<Integer> IDsBomberosPorBrigada(int idBrigada) {
//    List<Integer> idsBomberos = new ArrayList<>();
//
//    String sql = "SELECT idBombero FROM bombero WHERE idBrigada = ? AND estadoB = 1";
//
//    try {
//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setInt(1, idBrigada);
//        ResultSet rs = ps.executeQuery();
//
//        while (rs.next()) {
//            int idBombero = rs.getInt("idBombero");
//            idsBomberos.add(idBombero);
//        }
//        ps.close();
//        
////        // Verificar si la lista tiene solo un elemento
////        if (idsBomberos.size() == 1) {
////            // Mostrar JOptionPane indicando que la brigada tiene un solo bombero
////            JOptionPane.showMessageDialog(null, "La brigada seleccionada contiene un solo bombero");
////        }
//
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al obtener los IDs de los bomberos de la brigada: " + ex.getMessage());
//        
//    }
//
//    return idsBomberos;
//}
//
// 
// //----------------- Fin Bomberos por brigada-------------------------------
 
 
 //---------------------- Muestra nombre de bomberos de la misma brigada-----------------------
 
 public List<String> mostrarOpcionesBomberosPorBrigada(int idBrigada) {
    List<String> nombresBomberos = new ArrayList<>();

    String sql = "SELECT idBombero, nombreApellido FROM bombero WHERE idBrigada = ? AND estadoB = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idBrigada);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idBombero = rs.getInt("idBombero");
            String nombreBombero = rs.getString("nombreApellido");

            nombresBomberos.add(idBombero + ". " + nombreBombero);
        }
        ps.close();
        
        if (nombresBomberos.size() == 1) {
            JOptionPane.showMessageDialog(null, "La brigada seleccionada contiene un solo bombero");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener nombres de bomberos: " + ex.getMessage());
    }

    return nombresBomberos;
}

 
 //----------------------Fin Muestra nombre de bomberos de la misma brigada-----------------------
}

// Clase BrigadaData (proyecto BomberosGrupo5)

package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Bombero;
import bomberosgrupo5.entidades.Cuartel;
import bomberosgrupo5.entidades.Brigada;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

//** @author Asus

public class BomberoData {
    
//    private Connection con = null;
//    
    
//    public BomberoData(){ 
//        con = Conexion.getConectar();
//    }
    
    private Connection con;
    //private Connection con = null;
 public BomberoData(Connection con) {
    this.con = con;
}
    
    
    
//------------------------------------------------------------------------------
////public void guardarBombero(Bombero bombero, Brigada brigada) {
////    int idBrigada = brigada.getIdBrigada();
////    System.out.println("brigada: "+idBrigada);
////           // obtenerIdBrigada("cola"); // Obtener el ID de Brigada
////
//////    if (idBrigada != -1) {
//////        String sql = "INSERT INTO bombero (dni, nombreApellido, grupoSanguineo, fechaNac, celular, Brigada, estadoB) VALUES (?, ?, ?, ?, ?, ?, ?)";
//////
//////        try {
//////            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//////
//////            ps.setInt(1, bombero.getDni());
//////            ps.setString(2, bombero.getNombreApellido());
//////            ps.setString(3, bombero.getGrupoSanguineo());
//////            ps.setDate(4, Date.valueOf(bombero.getFechaNac()));
//////            ps.setString(5, bombero.getCelular());
//////            ps.setInt(6, idBrigada); // Usar el ID de Brigada obtenido
//////            ps.setBoolean(7, bombero.isEstadoB());
//////
//////            ps.executeUpdate();
//////
//////            ResultSet rs = ps.getGeneratedKeys();
//////
//////            if (rs.next()) {
//////                bombero.setIdBombero(rs.getInt(1));
//////                JOptionPane.showMessageDialog(null, "Bombero Agregado Exitosamente");
//////            }
//////            ps.close();
//////        } catch (SQLException ex) {
//////            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla bombero");
//////        }
//////    } else {
//////        JOptionPane.showMessageDialog(null, "No se encontró la Brigada con el nombre especificado.");
//////    }
////}
////
////
//
//
//
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
                ps.setInt(6, bombero.getBrigada().getIdBrigada());
                
                ps.setBoolean(7, bombero.isEstadoB());
    
                ps.executeUpdate();

                ResultSet rs=ps.getGeneratedKeys();

                if (rs.next()) {
                    bombero.setIdBombero(rs.getInt(1));
                    JOptionPane.showMessageDialog(null, "Bombero Agregado Exitosamente ");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla bombero ");
            }
       
        }

//    
//
//    
    
//    public void modificarBombero (Bombero bombero){
//        
//        String sql = "UPDATE bombero SET dni=?, nombreApellido=?, fechaNac=?, celular=?, idBrigada=?"
//                + "WHERE idBombero=? ";
//        try {
//            PreparedStatement ps= con.prepareStatement(sql);
//            ps.setInt(1, bombero.getDni());
//            ps.setString(2, bombero.getNombreApellido());
//            ps.setDate(3, Date.valueOf(bombero.getFechaNac()));
//            ps.setString(4, bombero.getCelular());
//            ps.setInt(5, bombero.getCodBrigada());
//            int exito = ps.executeUpdate();
//            if( exito==1){
//                JOptionPane.showMessageDialog(null, "Bombero Modificado");
//            }       
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
//        }
//        
//    }
    
//     public void eliminarBombero (int idBombero){
//        
//        String sql = "UPDATE bombero SET estadoB = 0 WHERE idBombero = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idBombero);
//            int exito=ps.executeUpdate();
//            if(exito==1){
//                JOptionPane.showMessageDialog(null, "Bombero borrado");
//            }
//        
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
//        }
//          
//        }


     public Bombero  buscarBomberoId (int idBombero){
        //busca bombero por ID y con el estado 1(activo)
        String sql = "SELECT dni, nombreApellido, fechaNac, celular, idBrigada FROM bombero WHERE idBombero = ? and estadoB = 1";
        Bombero bombero =null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setInt(1, idBombero);
            ResultSet rs=ps.executeQuery();      
            if(rs.next()){
                bombero=new Bombero();
                bombero.setDni(rs.getInt("dni"));
                bombero.setNombreApellido(rs.getString("NombreApellido"));
                bombero.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                bombero.setCelular(rs.getString("Celular"));
                bombero.setBrigada((Brigada) rs.getObject("idBrigada"));
                bombero.isEstadoB();
            }else{
                JOptionPane.showMessageDialog(null, "No existe el bombero con el ID indicado");
            }
            ps.close();
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
        return bombero;               
      }
     
   //-------------  buscarBomberoPorDni--------
//     public Bombero buscarBomberoPorDni(int dni, Connection connection) {
//    Bombero bomberoEncontrado = null;
//    String sql = "SELECT * FROM bombero WHERE dni = ?";
//
//    try {
//        PreparedStatement ps = connection.prepareStatement(sql);
//        ps.setInt(1, dni);
//        ResultSet rs = ps.executeQuery();
//
//        if (rs.next()) {
//            // Si se encuentra un bombero con el DNI especificado, crea un objeto Bombero con los datos obtenidos de la base de datos
//            bomberoEncontrado = new Bombero(
//                rs.getInt("dni"),
//                rs.getString("nombreApellido"),
//                rs.getString("grupoSanguineo"),
//                rs.getDate("fechaNac").toLocalDate(),
//                rs.getString("celular"),
//                null, // Aquí deberías obtener la brigada asociada, si la tienes en la base de datos
//                rs.getBoolean("estadoBom")
//                    
//            );
//        }
//
//        ps.close();
//    } catch (SQLException ex) {
//        JOptionPane.showMessageDialog(null, "Error al buscar al bombero por DNI: " + ex.getMessage());
//    }
//
//    return bomberoEncontrado;
//}
public Bombero buscarBomberoPorDni(int dni, Connection connection) {
    
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
                null, // Aquí deberías obtener la brigada asociada, si la tienes en la base de datos
                rs.getBoolean("estadoBom")
            );

            // Formatea la información del bombero como una cadena de texto
            String infoBombero = "DNI: " + bomberoEncontrado.getDni() + "\n" +
                                "Nombre y Apellido: " + bomberoEncontrado.getNombreApellido() + "\n" +
                                "Grupo Sanguíneo: " + bomberoEncontrado.getGrupoSanguineo() + "\n" +
                                "Fecha de Nacimiento: " + bomberoEncontrado.getFechaNac() + "\n" +
                                "Celular: " + bomberoEncontrado.getCelular() + "\n" +
                                "Estado: " + (bomberoEncontrado.isEstadoB() ? "Activo" : "Inactivo");

            // Muestra la información en un cuadro de diálogo
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



     public boolean existeBomberoConNombre(String nombreApellido, int dni, Connection con) {
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
                existe = true; // El bombero con el mismo nombre ya existe en la base de datos
            }
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        // Maneja cualquier excepción que pueda ocurrir al consultar la base de datos
        //ex.printStackTrace();
    }

    return existe;
}

   //-----------------------------------------
//cuenta bombero segun idBrigada
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
        // Manejar excepciones, por ejemplo, imprimir el error
        ex.printStackTrace();
    }
         System.out.println("cant: "+cantidadBomberos);
    return cantidadBomberos;
}

     public boolean hayCupoParaNuevoBombero(int idBrigada) {
    int cantidadBbomberos = contarBomberosPorBrigada(idBrigada);
    int capacidadMaxima = 3; // Cambia esto según la capacidad máxima de brigadas por cuartel que desees

    return cantidadBbomberos < capacidadMaxima;
}
     
     
     
     
//---------------------------------ELIMINAR--------------------------------

//--------------CAMBIO EL ESTADO DE UN BOMBERO-------------
public void actualizarBombero(Bombero bombero) {
    String sql = "UPDATE bombero SET estadoB = false WHERE dni = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, bombero.getDni());

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            JOptionPane.showMessageDialog(null, "Bombero eliminado exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar al bombero.");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar el bombero: " + ex.getMessage());
    }
}

     
}  


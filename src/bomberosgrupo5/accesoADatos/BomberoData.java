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

//------------------------------------------------------------------------------------------------------
//    


//-------------------------------------------------------------------------------------------------
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
//-----------------------------------------------------------------------------------------------------     

//-------------------------------
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
//-----------------------------------------------------------------------
     
     
     
     
//---------------------------------ELIMINAR--------------------------------
//-----------------------Listo los bomberos para seleccionar al que van a eliminar
    public int mostrarBomberosAEliminar(Connection con) {
    int idBomberoAEliminar = -1; // Valor predeterminado para indicar que no se ha seleccionado ningún bombero
    List<String> bomberosAEliminar = new ArrayList<>();

    String sql = "SELECT idBombero, dni, nombreApellido FROM bombero WHERE estadoB = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idBombero = rs.getInt("idBombero");
            int dniBombero = rs.getInt("dni");
            String nombreApellido = rs.getString("nombreApellido");

            bomberosAEliminar.add(idBombero + ". DNI: " + dniBombero + ", Nombre: " + nombreApellido);
        }
        ps.close();

        if (!bomberosAEliminar.isEmpty()) {
            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Elija un bombero a eliminar:\n" + String.join("\n", bomberosAEliminar),
                    "Selección de Bombero a Eliminar",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    bomberosAEliminar.toArray(),
                    bomberosAEliminar.get(0));

            if (seleccion != null) {
                String[] parts = seleccion.split("\\. ");
                if (parts.length == 2) {
                    idBomberoAEliminar = Integer.parseInt(parts[0]);
                    System.out.println("ID del Bombero a eliminar: " + idBomberoAEliminar);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la lista de bomberos a eliminar: " + ex.getMessage());
    }

    return idBomberoAEliminar;
}
 
//-------------------------------------------------------------------------------
//--------------CAMBIO EL ESTADO DE UN BOMBERO-------------
public void cambiarEstadoBombero(int idBombero, Connection con) {
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
public List<Integer> obtenerBomberosPorBrigada(int idBrigada, Connection con) {
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
//------------Borrado logico de bomberos que pertenecen a un brigada--------------
public void cambiarEstadoBomberosPorBrigada(int idBrigada, Connection con) {
    // Obtener la lista de IDs de bomberos que pertenecen a la brigada
    List<Integer> idsBomberosAEliminar = obtenerBomberosPorBrigada(idBrigada, con);

    for (Integer idBombero : idsBomberosAEliminar) {
        cambiarEstadoBombero(idBombero, con);
    }

    //JOptionPane.showMessageDialog(null, "Bomberos eliminados exitosamente.");
}

//-------------------------------------

//---------------------cambiar estados de bomberos en brigadas--------------
public void cambiarEstadoBomberosPorBrigadas(List<Integer> idsBrigadas, Connection con) {
    for (Integer idBrigada : idsBrigadas) {
        List<Integer> idsBomberosAEliminar = obtenerBomberosPorBrigada(idBrigada, con);

        for (Integer idBombero : idsBomberosAEliminar) {
            cambiarEstadoBombero(idBombero, con);
        }
    }

    //JOptionPane.showMessageDialog(null, "Bomberos eliminados exitosamente.");
}


//------------------------------------------------------------------------
}  


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
    
    String sql = "INSERT INTO bombero (dni, nombreApellido, grupoSanguineo, fechaNac, celular, Brigada, estadoB)"
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
        String sql = "SELECT dni, nombreApellido, fechaNac, celular, Brigada FROM bombero WHERE idBombero = ? and estadoB = 1";
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
     
     
     
//     public Bombero  buscarBomberoDni (int dni){
//        //busca alumnos por ID y con el estado 1(activo)
//        String sql = "SELECT nombreApellido, fechaNac, celular, CodBrigada FROM bombero WHERE dni = ? and estadoB = 1";
//        Bombero bombero =null;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);            
//            ps.setInt(1, dni);
//            ResultSet rs=ps.executeQuery();      
//            if(rs.next()){
//                bombero=new Bombero();
//                bombero.setDni(rs.getInt("dni"));
//                bombero.setNombreApellido(rs.getString("NombreApellido"));
//                bombero.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
//                bombero.setCelular(rs.getString("Celular"));
//                bombero.setCodBrigada(rs.getInt("idBrigada"));
//                bombero.isEstadoB();
//            }else{
//                JOptionPane.showMessageDialog(null, "No existe el bombero con el DNI indicado");
//            }
//            ps.close();
//        
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Bombero");
//        }
//        return bombero;               
//      }
     
     
//     public List<Bombero>  listarBomberos (){
//        //
//        String sql = "SELECT idBombero, dni, nombreApellido, fechaNac, celular, CodBrigada FROM bombero WHERE estadoB = 1";
//        ArrayList<Bombero> bomberos=new ArrayList<>();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);            
//            
//            ResultSet rs=ps.executeQuery();      
//            while(rs.next()){
//                Bombero bombero=new Bombero();
//                bombero.setIdBombero(rs.getInt("idBombero"));
//                bombero.setDni(rs.getInt("dni"));
//                bombero.setNombreApellido(rs.getString("NombreApellido"));
//                bombero.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
//                bombero.setCelular(rs.getString("Celular"));
//                bombero.setCodBrigada(rs.getInt("CodBrigada"));
//                bombero.isEstadoB();
//                bomberos.add(bombero);    
//            }
//            ps.close();
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla bombero");
//        }
//        return   bomberos;            
//      }

     



     public boolean existeBomberoConNombre(String nombreApellido, Connection con) {
    boolean existe = false;
    String sql = "SELECT COUNT(*) FROM bombero WHERE nombreApellido = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreApellido);
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
    int capacidadMaxima = 5; // Cambia esto según la capacidad máxima de brigadas por cuartel que desees

    return cantidadBbomberos < capacidadMaxima;
}
}  


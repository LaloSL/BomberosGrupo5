// Clase BrigadaData (Proyecto BomberosGrupo5)
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Brigada;
import bomberosgrupo5.entidades.Cuartel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BrigadaData {
private Connection con;
 public BrigadaData(Connection con) {
    this.con = con;
}
   

//------------------------------------------------------------------------------
//método guardar Brigada:
 
 public void guardarBrigada(Brigada brigada) {
    String sql = "INSERT INTO brigada (nombreBrig, especialidad, libre, Cuartel, estadoBr) VALUES (?, ?, ?, ?, ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, brigada.getNombreBrig());
        ps.setString(2, brigada.getEspecialidad());
        ps.setBoolean(3, brigada.isLibre());
        ps.setInt(4, brigada.getCuartel().getIdCuartel());
        ps.setBoolean(5, brigada.isEstadoBr());

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                brigada.setIdBrigada(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Brigada Agregada Exitosamente");
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
//        
//            
//            String sql = "INSERT INTO brigada (nombreBrig, especialidad, libre, Cuartel, estadoBr)"
//                    + " VALUES (?, ?, ?, ?, ?)";
//
//            try {
//                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//                ps.setString(1, brigada.getNombreBrig());
//                ps.setString(2, brigada.getEspecialidad());
//                ps.setBoolean(3, brigada.isLibre());
//                ps.setInt(4, brigada.getCuartel().getIdCuartel());
//                ps.setBoolean(5, brigada.isEstadoBr());
//
//                ps.executeUpdate();
//
//                ResultSet rs=ps.getGeneratedKeys();
//
//                if (rs.next()) {
//                    brigada.setIdBrigada(rs.getInt(1));
//                    JOptionPane.showMessageDialog(null, "Brigada Agregada Exitosamente ");
//                }
//                ps.close();
//                
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla brigada ");
//            }
//       
//        }
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

//---------------------------------------------------------------    
    
    
    // método modificar Brigada:----------------------------------------------
//    public void modificarBrigada(Brigada brigada){
//        
//        String sql = "UPDATE brigada SET nombreBrig=?, especialidad=?, libre=?, CodCuartel=? WHERE idBrigada= ?";
//                
//        try {
//            PreparedStatement ps= con.prepareStatement(sql);
//           ps.setString(1, brigada.getNombreBrig());
//            ps.setString(2, brigada.getEspecialidad());
//            ps.setBoolean(3, brigada.isLibre());
//            ps.setInt(4, brigada.getCodCuartel());
//            int ok = ps.executeUpdate();
//            if( ok == 1){
//                
//                JOptionPane.showMessageDialog(null, "Brigada Modificada ");
//            }       
//                   
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada ");
//        }
//    }
//    
    // método eliminar Brigada:----------------------------------------------
//     public void eliminarMateria (int idBrigada){
//        
//        String sql = "UPDATE brigada SET estadoBr = 0 WHERE idBrigada = ?";
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, idBrigada);
//            int exito=ps.executeUpdate();
//            if(exito==1){
//                JOptionPane.showMessageDialog(null, "Brigada Eliminada");
//            }
//        
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada");
//        }
//                 
//    
//    
//}
//     //médtodo Buscar brigada por id:-----------------------------------------
//     public Brigada  buscarBrigadaId (int idBrigada){
//        //busca materias por ID y con el estado 1(activo)
//        String sql = "SELECT nombreBrig, especialidad, libre, idCuartel, estadoBr FROM brigada WHERE idBrigada = ?";
//        Brigada brigada =null;
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);            
//            ps.setInt(1, idBrigada);
//            ResultSet rs=ps.executeQuery();      
//            if(rs.next()){
//                brigada =new Brigada();
//                brigada.setIdBrigada(idBrigada);
//                brigada.setNombreBrig(rs.getString("nombreBrigada"));
//                brigada.setEspecialidad(rs.getString("especialidad"));  
//                brigada.isLibre();
//                brigada.setCodCuartel(rs.getInt("CodCuartel"));
//                brigada.isEstadoBr();
//                                
//                int estado = rs.getInt("estadoBr");//muestra el estado en el radio button
//                brigada.setEstadoBr(estado == 1);                
//                
//                //JOptionPane.showMessageDialog(null, "Alumno borrado");
//            }else{
//                JOptionPane.showMessageDialog(null, "No existe la brigada con el ID indicado");
//            }
//            ps.close();
//        
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada");
//        }
//        return brigada;               
//      }
    // médtodo para listar Brigadas:-----------------------------------------
//     public List<Brigada>  listarMaterias (){
//        //
//        String sql = "SELECT idBrigada, nombreBrig, especialidad, libre, idCuartel FROM brigada WHERE estadoBr = 1";
//        ArrayList<Brigada> brigadas=new ArrayList<>();
//        try {
//            PreparedStatement ps = con.prepareStatement(sql);            
//            
//            ResultSet rs=ps.executeQuery();      
//            while(rs.next()){
//                Brigada brigada=new Brigada();
//                brigada.setIdBrigada(rs.getInt("idBrigada"));
//                brigada.setNombreBrig(rs.getString("nombreBrigada"));
//                brigada.setEspecialidad(rs.getString("especialidad"));  
//                brigada.isLibre();
//                brigada.setCodCuartel(rs.getInt("CodCuartel"));
//                brigada.isEstadoBr();
//                brigadas.add(brigada);
//                
//            }
//            ps.close();
//        
//        
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
//        }
//        return   brigadas;            
//      }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

//-------------------desde aca------------------------
    
public int contarBrigadasPorCuartel(int numeroCuartel) {
        int cantidadBrigadas = 0;

        try {
            String sql = "SELECT COUNT(*) AS cantidad FROM brigada WHERE Cuartel = ? AND estadoBr = 1";
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

        return cantidadBrigadas;
    }





public boolean hayCupoParaNuevaBrigada(int numeroCuartel) {
    int cantidadBrigadas = contarBrigadasPorCuartel(numeroCuartel);
    int capacidadMaxima = 3; // Cambia esto según la capacidad máxima de brigadas por cuartel que desees

    return cantidadBrigadas < capacidadMaxima;
}

//brigadas con el mismo nombre
public boolean existeBrigadaConNombreEnCuartel(String nombreBrigada, int idCuartel) {
    String sql = "SELECT COUNT(*) FROM brigada WHERE nombreBrig = ? AND Cuartel = ?";
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


//metodo listar brigadas


     public int mostrarOpciones(Connection con) {
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


//buscar brigada por id
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






}






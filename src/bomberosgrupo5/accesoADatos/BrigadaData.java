// Clase BrigadaData (Proyecto BomberosGrupo5)

package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Brigada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BrigadaData {
    
private Connection con = null;

public void guardarBrigada(Brigada brigada){

    if(brigada.getIdBrigada()== 0){
        String sql="INSERT INTO brigada (nombreBrig, especialidad, libre, CodCuartel, estadoBr)"
                    + "VALUE(? ,? ,? ,?,?)";
        
        try {            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brigada.getNombreBrig());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getCodCuartel());
            ps.setBoolean(5, brigada.isEstadoBr());
            ps.executeUpdate();
             
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                brigada.setIdBrigada(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Brigada agregada correctamente ");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada ");
        }
        }else{
            String sql = "UPDATE brigada SET estadoBr = ? WHERE idBrigada = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, brigada.isEstadoBr());
            ps.setInt(2, brigada.getIdBrigada());
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Brigada actualizada correctamente ");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la Brigada ");
        }
        }
 }
        
    public void modificarBrigada(Brigada brigada){
        
        String sql = "UPDATE brigada SET nombreBrig=?, especialidad=?, libre=?, CodCuartel=? WHERE idBrigada= ?";
                
        try {
            PreparedStatement ps= con.prepareStatement(sql);
           ps.setString(1, brigada.getNombreBrig());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getCodCuartel());
            int ok = ps.executeUpdate();
            if( ok == 1){
                
                JOptionPane.showMessageDialog(null, "Brigada Modificada ");
            }       
                   
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada ");
        }
    }
    
     public void eliminarMateria (int idBrigada){
        
        String sql = "UPDATE brigada SET estadoBr = 0 WHERE idBrigada = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBrigada);
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Brigada Eliminada");
            }
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada");
        }
                 
    
    
}
     
     //Buscar brigada por id
     public Brigada  buscarBrigadaId (int idBrigada){
        //busca materias por ID y con el estado 1(activo)
        String sql = "SELECT nombreBrig, especialidad, libre, idCuartel, estadoBr FROM brigada WHERE idBrigada = ?";
        Brigada brigada =null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setInt(1, idBrigada);
            ResultSet rs=ps.executeQuery();      
            if(rs.next()){
                brigada =new Brigada();
                brigada.setIdBrigada(idBrigada);
                brigada.setNombreBrig(rs.getString("nombreBrigada"));
                brigada.setEspecialidad(rs.getString("especialidad"));  
                brigada.isLibre();
                brigada.setCodCuartel(rs.getInt("CodCuartel"));
                brigada.isEstadoBr();
                                
                int estado = rs.getInt("estadoBr");//muestra el estado en el radio button
                brigada.setEstadoBr(estado == 1);                
                
                //JOptionPane.showMessageDialog(null, "Alumno borrado");
            }else{
                JOptionPane.showMessageDialog(null, "No existe la brigada con el ID indicado");
            }
            ps.close();
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Brigada");
        }
        return brigada;               
      }
     
     
     public List<Brigada>  listarMaterias (){
        //
        String sql = "SELECT idBrigada, nombreBrig, especialidad, libre, idCuartel FROM brigada WHERE estadoBr = 1";
        ArrayList<Brigada> brigadas=new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            
            ResultSet rs=ps.executeQuery();      
            while(rs.next()){
                Brigada brigada=new Brigada();
                brigada.setIdBrigada(rs.getInt("idBrigada"));
                brigada.setNombreBrig(rs.getString("nombreBrigada"));
                brigada.setEspecialidad(rs.getString("especialidad"));  
                brigada.isLibre();
                brigada.setCodCuartel(rs.getInt("CodCuartel"));
                brigada.isEstadoBr();
                brigadas.add(brigada);
                
            }
            ps.close();
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada");
        }
        return   brigadas;            
      }
    
    
    
    
    
    
}

    

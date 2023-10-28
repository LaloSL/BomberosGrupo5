// Clase Brigada Data (Proyecto BomberosGrupo5)

package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Brigada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class BrigadaData {
    
private Connection con = null;

public void guardarBrigada(Brigada brigada){

    if(brigada.getIdBrigada()== 0){
        String sql="INSERT INTO brigada (nombreBrig, especialidad, libre, idCuartel)"
                    + "VALUE(? ,? ,? ,?)";
        
        try {            
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, brigada.getNombreBrig());
            ps.setString(2, brigada.getEspecialidad());
            ps.setBoolean(3, brigada.isLibre());
            ps.setInt(4, brigada.getNroCuartel());
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
            String sql = "UPDATE materia SET estado = ? WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setBoolean(1, brigada.isLibre());
            ps.setInt(2, brigada.getIdBrigada());
            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Brigada actualizada correctamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar la Brigada");
        }
        }
        
    }
    
    
}

    

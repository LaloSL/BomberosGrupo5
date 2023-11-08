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

public class SiniestroData {

    private Connection con;

    public SiniestroData(Connection con) {
        this.con = con;
    }

//------------------------------------------------------------------------------
    public void guardarSiniestro(Siniestro siniestro) {
        String sql = "INSERT INTO siniestro (tipo,fechaSiniestro,horaSiniestro,coordx,coordy,detalles,fechaResol,puntuacion,idBrigada) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, siniestro.getTipo());
            ps.setDate(2, Date.valueOf(siniestro.getFechaSiniestro()));
        //    ps.setTime(3, Time.valueOf(siniestro.getHoraSiniestro()));
        //    ps.setString(4, siniestro.getCoordx());
        //    ps.setString(5, siniestro.getCoordy());
            ps.setString(6, siniestro.getDetalles());
            ps.setDate(7, Date.valueOf(siniestro.getFechaResol()));
            ps.setInt(8, siniestro.getPuntuacion());
        //    ps.setInt(9, siniestro.getBrigada();

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                siniestro.setIdSiniestro(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Siniestro Agregado Exitosamente");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla siniestro: " + ex.getMessage());
        }
    }

//------------------------------------------------------------------------------    
//public void guardarSiniestro(Siniestro siniestro) {
//
//        String sql = "INSERT INTO siniestro (tipo,fechaSiniestro,horaSiniestro,coordx,coordy,detalles,fechaResol,puntuacion,idBrigada)"
//                + "VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//
//        try {
//            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//        ps.setString(1, siniestro.getTipo());
//        ps.setDate(2, Date.valueOf(siniestro.getFechaSiniestro()));
//        ps.setTime(3, Time(siniestro.getHoraSiniestro()));
//        ps.setString(4, siniestro.getCoordX());
//        ps.setString(5, siniestro.getCoordY());
//        ps.setString(6, siniestro.getDetalles());
//        ps.setDate(7, Date.valueOf(siniestro.getFechaResol()));
//        ps.setInt(8, siniestro.getPuntuacion());
//        ps.setInt(9, siniestro.getBrigada());
//            
//            
//            ps.executeUpdate();
//
//            ResultSet rs = ps.getGeneratedKeys();
//
//            if (rs.next()) {
//                siniestro.setIdSiniestro(rs.getInt(1));
//                JOptionPane.showMessageDialog(null, "Siniestro Agregado Exitosamente ");
//            }
//            ps.close();
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla siniestro ");
//        }
//
//    }
////------------------------------------------------------------------------------
}

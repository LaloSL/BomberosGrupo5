/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Bombero;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class BomberoData {
    private Connection con=null;
    
    public BomberoData(){
        con=Conexion.getCotexion();
    }
    
    public void guardarBombero(Bombero bombero){
        
        String sql="INSERT INTO bombero (dni,nombreApellido, fechaNac, celular, idBrigada)"
                + "VALUE(? ,? ,? ,? ,?)";
        
        try {       
            
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, bombero.getDni());
            ps.setString(2, bombero.getNombreApellido());
            ps.setDate(3, Date.valueOf(bombero.getFechaNac()));
            ps.setString(4, bombero.getCelular());
            ps.setInt(5, bombero.getIdBrigada());
            ps.executeUpdate();
            
            ResultSet rs= ps.getGeneratedKeys();
            if(rs.next()){
                bombero.setIdBombero(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Bombero Agredado Exitosamente");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Bombero");
        }
        
    }
    
    
    public void modificarBombero (Bombero bombero){
        
        String sql = "UPDATE bombero SET dni = ?, nombreApellido = ?, fechaNac= ?, celular= ?, idBrigada= ?"
                + "WHERE idBombero = ? ";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, bombero.getDni());
            ps.setString(2, bombero.getNombreApellido());
            ps.setDate(3, Date.valueOf(bombero.getFechaNac()));
            ps.setString(4, bombero.getCelular());
            ps.setInt(5, bombero.getIdBrigada());
            int exito = ps.executeUpdate();
            if( exito==1){
                JOptionPane.showMessageDialog(null, "Bombero Modificado");
            }       
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
        
    }
    
     public void eliminarBombero (int idBombero){
        
        String sql = "UPDATE bombero SET estado = 0 WHERE idBombero = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idBombero);
            int exito=ps.executeUpdate();
            if(exito==1){
                JOptionPane.showMessageDialog(null, "Bombero borrado");
            }
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
                 
    
    
}
     public Bombero  buscarBomberoId (int idBombero){
        //busca bombero por ID y con el estado 1(activo)
        String sql = "SELECT dni, nombreApellido, fechaNac, celular, idBrigada FROM bombero WHERE idBombero = ?";
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
                bombero.setIdBrigada(rs.getInt("idBrigada"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe el bombero con el ID indicado");
            }
            ps.close();
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
        return bombero;               
      }
     public Bombero  buscarBomberoDni (int dni){
        //busca alumnos por ID y con el estado 1(activo)
        String sql = "SELECT nombreApellido, fechaNac, celular, idBrigada FROM bombero WHERE dni = ?";
        Bombero bombero =null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setInt(1, dni);
            ResultSet rs=ps.executeQuery();      
            if(rs.next()){
                bombero=new Bombero();
                bombero.setDni(rs.getInt("dni"));
                bombero.setNombreApellido(rs.getString("NombreApellido"));
                bombero.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                bombero.setCelular(rs.getString("Celular"));
                bombero.setIdBrigada(rs.getInt("idBrigada"));
            }else{
                JOptionPane.showMessageDialog(null, "No existe el bombero con el DNI indicado");
            }
            ps.close();
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno");
        }
        return bombero;               
      }
     
     public List<Bombero>  listarBomberos (){
        //
        String sql = "SELECT idBombero, dni, nombreApellido, fechaNac, celular, idBrigada FROM bombero";
        ArrayList<Bombero> bomberos=new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            
            ResultSet rs=ps.executeQuery();      
            while(rs.next()){
                Bombero bombero=new Bombero();
                bombero.setIdBrigada(rs.getInt("idBombero"));
                bombero.setDni(rs.getInt("dni"));
                bombero.setNombreApellido(rs.getString("NombreApellido"));
                bombero.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                bombero.setCelular(rs.getString("Celular"));
                bombero.setIdBrigada(rs.getInt("idBrigada"));
                bomberos.add(bombero);    
            }
            ps.close();
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla bombero");
        }
        return   bomberos;            
      }
   
}

// Clase Bombero (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

import java.time.LocalDate;

//** @author Asus
public class Bombero {

    private int idBombero;
    private int dni;
    private String nombreApellido;
    private String grupoSanguineo;
    private LocalDate fechaNac;
    private String celular;
    private Brigada Brigada;
    private boolean estadoB;
    

// Constructores:
    public Bombero() {
    }

    public Bombero(int dni, String nombreApellido, String grupoSanguineo, LocalDate fechaNac, String celular, int codBrigada, boolean estadoB) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.Brigada = Brigada;
        this.estadoB = estadoB;
    }

    public Bombero(int idBombero, int dni, String nombreApellido, String grupoSanguineo, LocalDate fechaNac, String celular, int codBrigada, boolean estadoB) {
        this.idBombero = idBombero;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.Brigada = Brigada;
        this.estadoB = estadoB;
    }
    
    // Getters & Setters:
    public int getIdBombero() {
        return idBombero;
    }

    public void setIdBombero(int idBombero) {
        this.idBombero = idBombero;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

//    public int getBrigada() {
//        return Brigada;
//    }
//
//    public void setBrigada(int codBrigada) {
//        this.Brigada = codBrigada;
//    }

    public boolean isEstadoB() {
        return estadoB;
    }

    public void setEstadoB(boolean estadoB) {
        this.estadoB = estadoB;
    }
//------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Bombero{" + "idBombero=" + idBombero + ", dni=" + dni + ", nombreApellido=" + nombreApellido + ", grupoSanguineo=" + grupoSanguineo + ", fechaNac=" + fechaNac + ", celular=" + celular + ", codBrigada=" + Brigada + ", estadoB=" + estadoB + '}';
    }

    
    
}









// public class BomberoData {
//    // ...
//
//    public int obtenerIdBrigada(String nombreBrigada) {
//        int idBrigada = -1; // Valor predeterminado en caso de que no se encuentre la brigada
//
//        try {
//            String sql = "SELECT idBrigada FROM brigada WHERE nombreBrig = ?";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, nombreBrigada);
//            ResultSet rs = ps.executeQuery();
//
//            if (rs.next()) {
//                idBrigada = rs.getInt("idBrigada");
//            }
//            
//            rs.close();
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al obtener el ID de Brigada");
//        }
//
//        return idBrigada;
//    }
//
//    public void guardarBombero(Bombero bombero, String nombreBrigada) {
//        int idBrigada = obtenerIdBrigada(nombreBrigada); // Obtener el ID de Brigada
//
//        if (idBrigada != -1) {
//            String sql = "INSERT INTO bombero (dni, nombreApellido, grupoSanguineo, fechaNac, celular, Brigada, estadoB) VALUES (?, ?, ?, ?, ?, ?, ?)";
//
//            try {
//                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//                ps.setInt(1, bombero.getDni());
//                ps.setString(2, bombero.getNombreApellido());
//                ps.setString(3, bombero.getGrupoSanguineo());
//                ps.setDate(4, Date.valueOf(bombero.getFechaNac()));
//                ps.setString(5, bombero.getCelular());
//                ps.setInt(6, idBrigada); // Usar el ID de Brigada obtenido
//                ps.setBoolean(7, bombero.isEstadoB());
//
//                ps.executeUpdate();
//
//                ResultSet rs = ps.getGeneratedKeys();
//
//                if (rs.next()) {
//                    bombero.setIdBombero(rs.getInt(1));
//                    JOptionPane.showMessageDialog(null, "Bombero Agregado Exitosamente");
//                }
//                ps.close();
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla bombero");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No se encontró la Brigada con el nombre especificado.");
//        }
//    }
//}






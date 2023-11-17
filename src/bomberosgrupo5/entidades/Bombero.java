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
    private Brigada brigada;
    private boolean estadoB;
    private int idBrigada;
    

// Constructores:

    public Bombero() {
    }

    public Bombero(int idBombero, int dni, String nombreApellido, String grupoSanguineo, LocalDate fechaNac, String celular, Brigada brigada, boolean estadoB) {
        this.idBombero = idBombero;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.brigada = brigada;
        this.estadoB = estadoB;
    }

    public Bombero(int dni, String nombreApellido, String grupoSanguineo, LocalDate fechaNac, String celular, Brigada brigada, boolean estadoB) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.brigada = brigada;
        this.estadoB = estadoB;
    }

    public Bombero(int dni, String nombreApellido, String grupoSanguineo, LocalDate fechaNac, String celular, boolean estadoB, int idBrigada) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.grupoSanguineo = grupoSanguineo;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.estadoB = estadoB;
        this.idBrigada = idBrigada;
    }

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

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }

    public boolean isEstadoB() {
        return estadoB;
    }

    public void setEstadoB(boolean estadoB) {
        this.estadoB = estadoB;
    }

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    @Override
    public String toString() {
        return "Bombero{" + "idBombero=" + idBombero + ", dni=" + dni + ", nombreApellido=" + nombreApellido + ", grupoSanguineo=" + grupoSanguineo + ", fechaNac=" + fechaNac + ", celular=" + celular + ", brigada=" + brigada + ", estadoB=" + estadoB + ", idBrigada=" + idBrigada + '}';
    }

    
    
}









//

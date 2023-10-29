// Clase Bombero (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

import java.time.LocalDate;

//** @author Asus
public class Bombero {

    private int idBombero;
    private int dni;
    private String nombreApellido;
    private LocalDate fechaNac;
    private String celular;
    private int codBrigada;
    private boolean estadoB;

// Constructores:
    public Bombero() {
    }

    public Bombero(int idBombero, int dni, String nombreApellido, LocalDate fechaNac, String celular, int CodBrigada, boolean estadoB) {
        this.idBombero = idBombero;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.codBrigada = CodBrigada;
        this.estadoB = estadoB;
    }

    public Bombero(int dni, String nombreApellido, LocalDate fechaNac, String celular, int CodBrigada, boolean estadoB) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.codBrigada = CodBrigada;
        this.estadoB = estadoB;
    }

    // Gettres & Setters:
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

    public int getCodBrigada() {
        return codBrigada;
    }

    public void setCodBrigada(int CodBrigada) {
        this.codBrigada = CodBrigada;
    }

    public boolean isEstadoB() {
        return estadoB;
    }

    public void setEstadoB(boolean estadoB) {
        this.estadoB = estadoB;
    }

    //--------------------------------------------------------------------------
    @Override
    public String toString() {
        return "Bombero{" + "idBombero=" + idBombero + ", dni=" + dni + ", nombreApellido=" + nombreApellido + ", fechaNac=" + fechaNac + ", celular=" + celular + ", CodBrigada=" + codBrigada + ", estadoB=" + estadoB + '}';
    }

}

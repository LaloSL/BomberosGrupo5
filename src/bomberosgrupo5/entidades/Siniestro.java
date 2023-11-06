// Clase Siniestro (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

import java.sql.Time;
import java.time.LocalDate;

//** @author Asus
public class Siniestro {

    private int idSiniestro;
    private String tipo;
    private LocalDate fechaSiniestro;
    private Time horaSiniestro;
    private int coordX;
    private int coordY;
    private String detalles;
    private LocalDate fechaResol;
    private int puntuacion;
    private Brigada brigada;

    // Constructor con todos sus atributos:  // primero con todos los atributos.
    public Siniestro(int idSiniestro, String tipo, LocalDate fechaSiniestro, Time horaSiniestro, int coordX, int coordY, String detalles, LocalDate fechaResol, int puntuacion, Brigada brigada) {
        this.idSiniestro = idSiniestro;
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.horaSiniestro = horaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.puntuacion = puntuacion;
        this.brigada = brigada;
    }
    
    // Constructor sin atributo idSiniestro:   /// luego sin atributo idSinisestro. 
    public Siniestro(String tipo, LocalDate fechaSiniestro, Time horaSiniestro, int coordX, int coordY, String detalles, LocalDate fechaResol, int puntuacion, Brigada brigada) {
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.horaSiniestro = horaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.puntuacion = puntuacion;
        this.brigada = brigada;
    }

    // Constructor vacio:   // por último atributo vacio.
    public Siniestro() {
    }
//------------------------------------------------------------------------------

// Getters & setters:
    public int getIdSiniestro() {
        return idSiniestro;
    }

    public void setIdSiniestro(int idSiniestro) {
        this.idSiniestro = idSiniestro;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(LocalDate fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public Time getHoraSiniestro() {
        return horaSiniestro;
    }

    public void setHoraSiniestro(Time horaSiniestro) {
        this.horaSiniestro = horaSiniestro;
    }

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public LocalDate getFechaResol() {
        return fechaResol;
    }

    public void setFechaResol(LocalDate fechaResol) {
        this.fechaResol = fechaResol;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Brigada getBrigada() {
        return brigada;
    }

    public void setBrigada(Brigada brigada) {
        this.brigada = brigada;
    }
    
//------------------------------------------------------------------------------    

    @Override
    public String toString() {
        return "Siniestro{" + "idSiniestro=" + idSiniestro + ", tipo=" + tipo + ", fechaSiniestro=" + fechaSiniestro + ", horaSiniestro=" + horaSiniestro + ", coordX=" + coordX + ", coordY=" + coordY + ", detalles=" + detalles + ", fechaResol=" + fechaResol + ", puntuacion=" + puntuacion + ", brigada=" + brigada + '}';
    }
    
}

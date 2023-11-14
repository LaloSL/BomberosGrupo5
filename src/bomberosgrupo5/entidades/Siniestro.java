// Clase Siniestro (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

import java.sql.Timestamp;
import java.time.LocalDate;

//** @author Asus
public class Siniestro {

    private int idSiniestro;
    private String tipo;
    private int coordX;
    private int coordY;
    private String detalles;
    private int puntuacion;
    private Brigada idBrigada;
    private Timestamp fechaSiniestro;
    private Timestamp fechaResol;

    public Siniestro() {
    }

    public Siniestro(int idSiniestro, String tipo, int coordX, int coordY, String detalles, int puntuacion, Brigada idBrigada, Timestamp fechaSiniestro, Timestamp fechaResol) {
        this.idSiniestro = idSiniestro;
        this.tipo = tipo;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
        this.fechaSiniestro = fechaSiniestro;
        this.fechaResol = fechaResol;
    }

    public Siniestro(String tipo, int coordX, int coordY, String detalles, int puntuacion, Brigada idBrigada, Timestamp fechaSiniestro, Timestamp fechaResol) {
        this.tipo = tipo;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
        this.fechaSiniestro = fechaSiniestro;
        this.fechaResol = fechaResol;
    }

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

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Brigada getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(Brigada idBrigada) {
        this.idBrigada = idBrigada;
    }

    public Timestamp getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(Timestamp fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public Timestamp getFechaResol() {
        return fechaResol;
    }

    public void setFechaResol(Timestamp fechaResol) {
        this.fechaResol = fechaResol;
    }

    @Override
    public String toString() {
        return "Siniestro{" + "idSiniestro=" + idSiniestro + ", tipo=" + tipo + ", coordX=" + coordX + ", coordY=" + coordY + ", detalles=" + detalles + ", puntuacion=" + puntuacion + ", idBrigada=" + idBrigada + ", fechaSiniestro=" + fechaSiniestro + ", fechaResol=" + fechaResol + '}';
    }

    

    
}

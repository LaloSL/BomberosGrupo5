// Clase Siniestro (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;


import java.time.LocalDate;
import java.time.LocalDateTime;

//** @author Asus
public class Siniestro {

    private int idSiniestro;
    private String tipo;
    private int coordX;
    private int coordY;
    private String detalles;
    private int puntuacion;
    private Brigada idBrigada;
    private LocalDateTime fechaSiniestro;
    private LocalDateTime fechaResol;

    public Siniestro() {
    }

    public Siniestro(int idSiniestro, String tipo, int coordX, int coordY, String detalles, int puntuacion, Brigada idBrigada, LocalDateTime fechaSiniestro, LocalDateTime fechaResol) {
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

    public Siniestro(String tipo, int coordX, int coordY, String detalles, int puntuacion, Brigada idBrigada, LocalDateTime fechaSiniestro, LocalDateTime fechaResol) {
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

    public LocalDateTime getFechaSiniestro() {
        return fechaSiniestro;
    }

    public void setFechaSiniestro(LocalDateTime fechaSiniestro) {
        this.fechaSiniestro = fechaSiniestro;
    }

    public LocalDateTime getFechaResol() {
        return fechaResol;
    }

    public void setFechaResol(LocalDateTime fechaResol) {
        this.fechaResol = fechaResol;
    }

    @Override
    public String toString() {
        return "Siniestro{" + "idSiniestro=" + idSiniestro + ", tipo=" + tipo + ", coordX=" + coordX + ", coordY=" + coordY + ", detalles=" + detalles + ", puntuacion=" + puntuacion + ", idBrigada=" + idBrigada + ", fechaSiniestro=" + fechaSiniestro + ", fechaResol=" + fechaResol + '}';
    }

   
    
}

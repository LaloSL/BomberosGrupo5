// Clase Siniestro (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

import java.time.LocalDate;

/**
 * @author Asus
 */
public class Siniestro {
   
  private int idCodigo;
  private String tipo;
  private LocalDate fechaSiniestro;
  private int coordX;
  private int coordY;
  private String detalles;
  private LocalDate fechaResol;
  private int puntuacion;
  private int idBrigada;

    public Siniestro() {
    }

    public Siniestro(int idCodigo, String tipo, LocalDate fechaSiniestro, int coordX, int coordY, String detalles, LocalDate fechaResol, int puntuacion, int idBrigada) {
        this.idCodigo = idCodigo;
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
    }

    public Siniestro(String tipo, LocalDate fechaSiniestro, int coordX, int coordY, String detalles, LocalDate fechaResol, int puntuacion, int idBrigada) {
        this.tipo = tipo;
        this.fechaSiniestro = fechaSiniestro;
        this.coordX = coordX;
        this.coordY = coordY;
        this.detalles = detalles;
        this.fechaResol = fechaResol;
        this.puntuacion = puntuacion;
        this.idBrigada = idBrigada;
    }

    public int getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(int idCodigo) {
        this.idCodigo = idCodigo;
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

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    @Override
    public String toString() {
        return "Siniestro{" + "idCodigo=" + idCodigo + ", tipo=" + tipo + ", fechaSiniestro=" + fechaSiniestro + ", coordX=" + coordX + ", coordY=" + coordY + ", detalles=" + detalles + ", fechaResol=" + fechaResol + ", puntuacion=" + puntuacion + ", idBrigada=" + idBrigada + '}';
    }
  
     
    
}

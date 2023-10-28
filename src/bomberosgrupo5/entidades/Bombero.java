/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo5.entidades;

import java.time.LocalDate;

/**
 *
 * @author Asus
 */
public class Bombero {
  private int idBombero;
  private int dni;
  private String nombreApellido;
  private LocalDate fechaNac;
  private String celular;
  private int idBrigada;

    public Bombero() {
    }

    public Bombero(int idBombero, int dni, String nombreApellido, LocalDate fechaNac, String celular, int idBrigada) {
        this.idBombero = idBombero;
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.fechaNac = fechaNac;
        this.celular = celular;
        this.idBrigada = idBrigada;
    }

    public Bombero(int dni, String nombreApellido, LocalDate fechaNac, String celular, int idBrigada) {
        this.dni = dni;
        this.nombreApellido = nombreApellido;
        this.fechaNac = fechaNac;
        this.celular = celular;
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

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    @Override
    public String toString() {
        return "Bombero{" + "idBombero=" + idBombero + ", dni=" + dni + ", nombreApellido=" + nombreApellido + ", fechaNac=" + fechaNac + ", celular=" + celular + ", idBrigada=" + idBrigada + '}';
    }
    
    
  
  
  
}

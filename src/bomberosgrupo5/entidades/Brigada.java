// Clase Brigada (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

public class Brigada {
    private int idBrigada;
    private String nombreBrig;
    private String especialidad;
    private boolean libre;
    private int idCuartel;

    public Brigada() {
    }

    public Brigada(int idBrigada, String nombreBrig, String especialidad, boolean libre, int nroCuartel) {
        this.idBrigada = idBrigada;
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.idCuartel = nroCuartel;
    }

    public Brigada(String nombreBrig, String especialidad, boolean libre, int nroCuartel) {
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.idCuartel = nroCuartel;
    }

    public int getIdBrigada() {
        return idBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.idBrigada = idBrigada;
    }

    public String getNombreBrig() {
        return nombreBrig;
    }

    public void setNombreBrig(String nombreBrig) {
        this.nombreBrig = nombreBrig;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public int getNroCuartel() {
        return idCuartel;
    }

    public void setNroCuartel(int nroCuartel) {
        this.idCuartel = nroCuartel;
    }

    @Override
    public String toString() {
        return "Brigada{" + "idBrigada=" + idBrigada + ", nombreBrig=" + nombreBrig + ", especialidad=" + especialidad + ", libre=" + libre + ", nroCuartel=" + idCuartel + '}';
    }
    
    
    
  
}

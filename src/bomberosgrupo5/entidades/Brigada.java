// Clase Brigada (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

public class Brigada {

    private int Brigada;
    private String nombreBrig;
    private String especialidad;
    private boolean libre;
    private Cuartel cuartel;
    private boolean estadoBr;

    // Constructores:

    public Brigada() {
    }

    public Brigada(int Brigada, String nombreBrig, String especialidad, boolean libre, Cuartel cuartel, boolean estadoBr) {
        this.Brigada = Brigada;
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
        this.estadoBr = estadoBr;
    }

    public Brigada(String nombreBrig, String especialidad, boolean libre, Cuartel cuartel, boolean estadoBr) {
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.cuartel = cuartel;
        this.estadoBr = estadoBr;
    }

    public int getBrigada() {
        return Brigada;
    }

    public void setBrigada(int Brigada) {
        this.Brigada = Brigada;
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

    public Cuartel getCuartel() {
        return cuartel;
    }

    public void setCuartel(Cuartel cuartel) {
        this.cuartel = cuartel;
    }

    public boolean isEstadoBr() {
        return estadoBr;
    }

    public void setEstadoBr(boolean estadoBr) {
        this.estadoBr = estadoBr;
    }

    @Override
    public String toString() {
        return "Brigada{" + "Brigada=" + Brigada + ", nombreBrig=" + nombreBrig + ", especialidad=" + especialidad + ", libre=" + libre + ", cuartel=" + cuartel + ", estadoBr=" + estadoBr + '}';
    }

    
}

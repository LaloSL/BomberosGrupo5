// Clase Brigada (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

public class Brigada {

    private int codBrigada;
    private String nombreBrig;
    private String especialidad;
    private boolean libre;
    private int codCuartel;
    private boolean estadoBr;

    // Constructores:
    public Brigada() {
    }
    
    public Brigada(String nombreBrig, String especialidad, boolean libre, int codCuartel, boolean estadoBr) {
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.codCuartel = codCuartel;
        this.estadoBr = estadoBr;
    }

    public Brigada(int codBrigada, String nombreBrig, String especialidad, boolean libre, int codCuartel, boolean estadoBr) {
        this.codBrigada = codBrigada;
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.codCuartel = codCuartel;
        this.estadoBr = estadoBr;
    }

    //Getters & Setters:

    public int getIdBrigada() {
        return codBrigada;
    }

    public void setIdBrigada(int idBrigada) {
        this.codBrigada = idBrigada;
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

    public int getCodCuartel() {
        return codCuartel;
    }

    public void setCodCuartel(int codCuartel) {
        this.codCuartel = codCuartel;
    }

    public boolean isEstadoBr() {
        return estadoBr;
    }

    public void setEstadoBr(boolean estadoBr) {
        this.estadoBr = estadoBr;
    }
    //--------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Brigada{" + "idBrigada=" + codBrigada + ", nombreBrig=" + nombreBrig + ", especialidad=" + especialidad + ", libre=" + libre + ", codCuartel=" + codCuartel + ", estadoBr=" + estadoBr + '}';
    }
    

}

// Clase Brigada (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

public class Brigada {

    private int idBrigada;
    private String nombreBrig;
    private String especialidad;
    private boolean libre;
    private int CodCuartel;
    private boolean estadoBr;

    // Constructores:
    public Brigada() {
    }

    public Brigada(int idBrigada, String nombreBrig, String especialidad, boolean libre, int CodCuartel, boolean estadoBr) {
        this.idBrigada = idBrigada;
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.CodCuartel = CodCuartel;
        this.estadoBr = estadoBr;
    }

    public Brigada(String nombreBrig, String especialidad, boolean libre, int CodCuartel, boolean estadoBr) {
        this.nombreBrig = nombreBrig;
        this.especialidad = especialidad;
        this.libre = libre;
        this.CodCuartel = CodCuartel;
        this.estadoBr = estadoBr;
    }

    // Gettres & Setters:
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

    public int getCodCuartel() {
        return CodCuartel;
    }

    public void setCodCuartel(int CodCuartel) {
        this.CodCuartel = CodCuartel;
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
        return "Brigada{" + "idBrigada=" + idBrigada + ", nombreBrig=" + nombreBrig + ", especialidad=" + especialidad + ", libre=" + libre + ", CodCuartel=" + CodCuartel + ", estadoBr=" + estadoBr + '}';
    }

}

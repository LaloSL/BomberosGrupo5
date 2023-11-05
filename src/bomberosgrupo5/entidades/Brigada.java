// Clase Brigada (Proyecto BomberosGrupo5)

package bomberosgrupo5.entidades;

public class Brigada {

    private int idBrigada;
    private String nombreBrig;
    private String especialidad;
    private boolean libre;
    private Cuartel cuartel;
    private boolean estadoBr;
    private int idCuartel;

    // Constructores:

    public Brigada() {
    }

    public Brigada(int idBrigada, String nombreBrig, String especialidad, boolean libre, Cuartel cuartel, boolean estadoBr) {
        this.idBrigada = idBrigada;
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
    
//    ---------------------agrego otro constructor donde le paso idcuartel solamente---------------------
    public Brigada(String nombre, String especialidad, boolean activa, int idCuartel, boolean estadoBr) {
     this.nombreBrig = nombreBrig;
     this.especialidad = especialidad;
     this.libre = libre;
    this.idCuartel = idCuartel; // Establecer la identificación del cuartel
    this.estadoBr = estadoBr;
}
//-----------------------------------------------------------------------------

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
        return "Brigada{" + "idBrigada=" + idBrigada + ", nombreBrig=" + nombreBrig + ", especialidad=" + especialidad + ", libre=" + libre + ", cuartel=" + cuartel + ", estadoBr=" + estadoBr + '}';
    }

    
    
}

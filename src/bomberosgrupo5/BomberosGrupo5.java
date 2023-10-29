// Main para realizar la pruebas de clases Data

package bomberosgrupo5;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import bomberosgrupo5.accesoADatos.BomberoData;
import bomberosgrupo5.entidades.Bombero;



//** @author Asus

public class BomberosGrupo5 {

    
    public static void main(String[] args) {
        
         // creo el objeto BomberoData que me permitirá guardar en BD:
         Bombero bom1 = new Bombero(1222222, "José Pekermán",LocalDate.of(1975, 1, 1),"11112222", 1, true);
         BomberoData bom = new BomberoData();
         bom.guardarBombero(bom1);
         
         
       // en este creo que no hace falta el idAlumno
       //(FY)Bombero joaquin= new Bombero(1234567890, "Joaquin Ortega",LocalDate.of(1990, 5, 5), "1234567890", 1, true);
       //creo un objeto Alumno data que me permite guardar en la BD
       //(FY) BomberoData bom= new BomberoData();
        //(FY)bom.guardarBombero(joaquin);
        
        //para insertar un bombero primero se debe de tener los datos de la brigada a la cual pertenece
    }
    
}

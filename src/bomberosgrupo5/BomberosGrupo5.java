// Main para realizar la pruebas de clases Data

package bomberosgrupo5;

import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import bomberosgrupo5.accesoADatos.BomberoData;
import bomberosgrupo5.accesoADatos.Conexion;
import bomberosgrupo5.entidades.Bombero;



//** @author Asus

public class BomberosGrupo5 {

    
    public static void main(String[] args) {
        
        //prueba de conexión:
        //Conexion.getConectar(); //FY
        
         // creo el objeto BomberoData que me permitirá guardar en BD:
         Bombero bomber1 = new Bombero(1222222,"José Pekermán",LocalDate.of(1975, 4, 20),"1112221",1,true);
         BomberoData bom = new BomberoData();
         bom.guardarBombero(bomber1);
         
         
       // en este creo que no hace falta el idAlumno
       //(FY)Bombero joaquin= new Bombero(1234567890, "Joaquin Ortega",LocalDate.of(1990, 5, 5), "1234567890", 1, true);
       //creo un objeto Alumno data que me permite guardar en la BD
       //(FY) BomberoData bom= new BomberoData();
        //(FY)bom.guardarBombero(joaquin);
        
        //para insertar un bombero primero se debe de tener los datos de la brigada a la cual pertenece
    }
    
}

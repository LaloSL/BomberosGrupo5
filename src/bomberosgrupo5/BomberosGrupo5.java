// Main para realizar la pruebas de clases Data

package bomberosgrupo5;

import java.sql.*;
import java.time.Month;
import bomberosgrupo5.accesoADatos.BomberoData;
import bomberosgrupo5.accesoADatos.Conexion;
import bomberosgrupo5.accesoADatos.CuartelData;
import bomberosgrupo5.entidades.Bombero;
import bomberosgrupo5.entidades.Cuartel;



//** @author Asus

public class BomberosGrupo5 {

    
    public static void main(String[] args) {
        
        //prueba de conexión: FY - Ok
        //Conexion.getConectar(); //FY - ok
        
        //creo primero el objeto Cuartel para ingresar datos a Tabla cuartel: Fy - ok
        //Cuartel cuar=new Cuartel("Cuartel 8", "Falucho 800",2080, 2080,"266888888", "Cuartel.8@sl.com.ar",true); //dato en memoria
        //CuartelData cua=new CuartelData(); 
        //cua.guardarCuartel(cuar);

        
        
        

        // creo el objeto BrigadaData que me permitirá guardar en BD:
        //Brigada brigada1 = new Bridaga("alfa",);
        
        
        
         // creo el objeto BomberoData que me permitirá guardar en BD:
//         Bombero bomber1 = new Bombero(1222222,"José Pekermán",LocalDate.of(1975, 1, 20),"1112221",1,true);
//         BomberoData bom = new BomberoData();
//         bom.guardarBombero(bomber1);
         
         
       // en este creo que no hace falta el idAlumno
       //(FY)Bombero joaquin= new Bombero(1234567890, "Joaquin Ortega",LocalDate.of(1990, 5, 5), "1234567890", 1, true);
       //creo un objeto Alumno data que me permite guardar en la BD
       //(FY) BomberoData bom= new BomberoData();
        //(FY)bom.guardarBombero(joaquin);
        
        //para insertar un bombero primero se debe de tener los datos de la brigada a la cual pertenece
    }
    
}

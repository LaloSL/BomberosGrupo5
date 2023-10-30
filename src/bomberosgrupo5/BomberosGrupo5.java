// Main para realizar la pruebas de clases Data

package bomberosgrupo5;

import java.sql.*;
import bomberosgrupo5.accesoADatos.BomberoData;
import bomberosgrupo5.accesoADatos.BrigadaData;
import bomberosgrupo5.accesoADatos.Conexion;
import bomberosgrupo5.entidades.Bombero;
import bomberosgrupo5.entidades.Brigada;
import java.time.LocalDate;

//** @author Asus

public class BomberosGrupo5 {

    
    public static void main(String[] args) {
        
        //prueba de conexión: 
        //Conexion.getConectar(); //prueba ok
        
        // Prueba del método guardar Cuartel [ok]
        //Cuartel cuar=new Cuartel("Cuartel 8", "Falucho 800",2080, 2080,"266888888", "Cuartel.8@sl.com.ar",true); //dato en memoria
        //CuartelData cua=new CuartelData(); 
        //cua.guardarCuartel(cuar);  

        //prueba de método modificarCuartel(): [verificar, no funciono]
        //Cuartel cuar=new Cuartel(12,"Cuartel 4", "Falucho 800",1085, 1085,"266888888", "Cuartel.4@sl.com.ar",true);
        //CuartelData cua=new CuartelData();
        //cua.modificarCuartel(cuar);
        
        // prueba de método eliminarCuartel(): 
        //Cuartel cuar=new Cuartel(12,"Cuartel 8", "Falucho 800",2080, 2080,"266888888", "Cuartel.8@sl.com.ar",true);
        //CuartelData cua=new CuartelData();
        //cua.eliminarCuartel(12);
        
        // Prueba de método guardarBrigada():  [verificar, no funciona]
        //Brigada briga1 = new Brigada("alfa", "salvamento en derrumbes", true, 2, true);
        //BrigadaData bri = new BrigadaData();
        //bri.guardarBrigada(briga1);
        
        
//         // creo el objeto BomberoData que me permitirá guardar en BD:
//         Bombero bomber1 = new Bombero(1222222,"José Pekermán",LocalDate.of(1975, 1, 20),"266111111",1,true);  //dato en memoria
//         BomberoData bom = new BomberoData();
//         bom.guardarBombero(bomber1);
        
        
        //para insertar un bombero primero se debe de tener los datos de la brigada a la cual pertenece
    }
    
}

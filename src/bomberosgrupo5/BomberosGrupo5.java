/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bomberosgrupo5;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;
import bomberosgrupo5.accesoADatos.BomberoData;
import bomberosgrupo5.entidades.Bombero;



/**
 *
 * @author Asus
 */
public class BomberosGrupo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         //Guardar Bombero
       // en este creo que no hace falta el idAlumno
       Bombero joaquin= new Bombero(1234567890, "Joaquin Ortega",LocalDate.of(1990, 5, 5), "1234567890", 1, true);
       //creo un objeto Alumno data que me permite guardar en la BD
        BomberoData bom= new BomberoData();
        bom.guardarBombero(joaquin);
        
        //para insertar un bombero primero se debe de tener los datos de la brigada a la cual pertenece
    }
    
}

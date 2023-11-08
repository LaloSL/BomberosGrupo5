//// Clase BrigadaData (Proyecto BomberosGrupo5)
//package bomberosgrupo5.accesoADatos;
//
//import java.sql.*;
//import bomberosgrupo5.accesoADatos.BomberoData;
//import bomberosgrupo5.accesoADatos.BrigadaData;
//import bomberosgrupo5.accesoADatos.Conexion;
//import bomberosgrupo5.accesoADatos.CuartelData;
//import bomberosgrupo5.entidades.Bombero;
//import bomberosgrupo5.entidades.Brigada;
//import bomberosgrupo5.entidades.Cuartel;
//import java.time.LocalDate;
//import java.util.List;
//import javax.swing.JOptionPane;
////import org.mariadb.jdbc.Connection;
//
////** @author Asus
//public class BomberosGrupo5 {
//
//    private static Brigada idBrigada;
//
//    public static void main(String[] args) {
//        Conexion con = new Conexion();
//        Connection connection = (Connection) con.getConexion(); // Obtener la conexión válida
//
//        BrigadaData brig = new BrigadaData(connection);
//        CuartelData cua1 = new CuartelData(connection);
//        BomberoData bom = new BomberoData(connection);
//        //prueba de conexión: 
//        //Conexion.getConectar(); //prueba ok
////        Conexion con = new Conexion();
////        BrigadaData brig = new BrigadaData(con);
//
////        Conexion con = new Conexion();
////        BrigadaData brig = new BrigadaData((Connection) con);
////
////
////        CuartelData cua1=new CuartelData((Connection) con);
////    -------------------------------------------------------------------    
//        // Prueba del método guardar Cuartel [ok] Cargado!!!!
////        Cuartel cuar=new Cuartel("Cuartel 9", "Falucho 850",2085, 2085,"266888999", "Cuartel.9@sl.com.ar",true); //dato en memoria
////        CuartelData cua=new CuartelData(); 
////        cua.guardarCuartel(cuar);  
//        //prueba de método modificarCuartel(): [verificar, no funciono]
//        //Cuartel cuar=new Cuartel(12,"Cuartel 4", "Falucho 800",1085, 1085,"266888888", "Cuartel.4@sl.com.ar",true);
//        //CuartelData cua=new CuartelData();
//        //cua.modificarCuartel(cuar);
//        // prueba de método eliminarCuartel(): 
//        //Cuartel cuar=new Cuartel(12,"Cuartel 8", "Falucho 800",2080, 2080,"266888888", "Cuartel.8@sl.com.ar",true);
//        //CuartelData cua=new CuartelData();
//        //cua.eliminarCuartel(12);
////------------------------------------------------------------------------------        
//        // Prueba de método guardarBrigada():  [cargada!!!]
////        Brigada briga = new Brigada("alfa","salvamento en derrumbes", true, 1, true);
////        BrigadaData brig = new BrigadaData();
////        brig.guardarBrigada(briga);
////         // creo el objeto BomberoData que me permitirá guardar en BD:
////         Bombero bomber1 = new Bombero(1222222,"José Pekermán",LocalDate.of(1975, 1, 20),"266111111",1,true);  //dato en memoria
////         BomberoData bom = new BomberoData();
////         bom.guardarBombero(bomber1);
////------------------------------------------------------------------------------        
////    // Prueba de método guardar bombero():  // error al acceder a la tabla bombero
////    Bombero bom1 = new Bombero(987, "Pablo Perez", "A+", LocalDate.of(1981, 5, 25), "2664567698",7, true);
////    BomberoData bom = new BomberoData();
////    bom.guardarBombero(bom1);
////        Brigada briga = new Brigada("Toxico","Drogas Peligrosas", true, cuar1, true);
////       //BrigadaData brig = new BrigadaData();
////        brig.guardarBrigada(briga);
////
////////         Prueba del método guardar Cuartel [ok] Cargado!!!!
////        Cuartel cuar1=new Cuartel("Cuartel Central", "Av Roca 600",2085, 2085,"266888999", "Cuartel.central@sl.com.ar",true); //dato en memoria
//////        CuartelData cua=new CuartelData(); 
////        cua1.guardarCuartel(cuar1);  
//////// Crear una instancia válida de Cuartel
////Cuartel cuar2 = new Cuartel("Cuartel Tilisarao", "Av Roca 34500", 2085, 2085, "266888999", "Cuartel.TILI@sl.com.ar", true);
////
//////
//////// Guardar el Cuartel en la base de datos
//////cua1.guardarCuartel(cuar2);
////////-------------------------------------------------------------
//////// Crear una nueva Brigada utilizando el Cuartel previamente creado
////Brigada briga = new Brigada("Atura", "Rescate en altura", true, cuar2, true);
//////BrigadaData brig = new BrigadaData(con);
////
////// Guardar la Brigada en la base de datos
////brig.guardarBrigada(briga);
////////-------------------------------------------------------------
//////    Bombero bom1 = new Bombero(677, "Carlos Gomez", "A-", LocalDate.of(1979, 5, 25), "2664567698",briga, true);
//////   
//////    bom.guardarBombero(bom1);        
////
////    Bombero bom2 = new Bombero(677, "Jorge Sosa", "A+", LocalDate.of(1982, 5, 25), "266455669",briga, true);
//////   
////    bom.guardarBombero(bom2);  
////----------------------------------------------------------------------------------------------------------
//        int opcion = 0;
//
//        while (opcion != 4) {
//            String input = JOptionPane.showInputDialog("Elija una acción:\n1. Agregar\n2. Modificar\n3. Eliminar\n4. Salir");
//
//            try {
//                opcion = Integer.parseInt(input);
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número válido.");
//                continue; // Volver al inicio del bucle
//            }
//
//            switch (opcion) {
//                case 1:
//                    int subOpcion = 0;
//                    while (subOpcion != 5) {
//                        String subInput = JOptionPane.showInputDialog("Elija qué agregar:\n1. Cuartel\n2. Brigada\n3. Bombero\n4. Salir\n5. Volver al menú anterior");
//
//                        try {
//                            subOpcion = Integer.parseInt(subInput);
//                        } catch (NumberFormatException e) {
//                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número válido.");
//                            continue; // Volver al inicio del bucle
//                        }
////---------------------------------------AGREGAR----------------------------------------------------------------------------------------------------------
//                        switch (subOpcion) {
//                            //--------------------AGREGAR CUARTEL---------------
//                            case 1:
//
//                                JOptionPane.showMessageDialog(null, "Complete los datos para agregar un nuevo cuartel");
//                                String nombreCuartel = JOptionPane.showInputDialog("Ingrese el nombre del cuartel:");
//
//                                if (cua1.existeCuartelConNombre(nombreCuartel)) {
//                                    JOptionPane.showMessageDialog(null, "Ya existe un cuartel con el mismo nombre. No se puede agregar.");
//                                } else {
//                                    String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cuartel:");
//                                    int longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud del cuartel (entero):"));
//                                    int latitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la latitud del cuartel (entero):"));
//                                    String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del cuartel:");
//                                    String correo = JOptionPane.showInputDialog("Ingrese el correo del cuartel:");
//
//                                    Cuartel cuar2 = new Cuartel(nombreCuartel, direccion, longitud, latitud, telefono, correo, true);
//                                    cua1.guardarCuartel(cuar2);
//                                }
//                                break;
//                            //--------------------------------------AGREGAR BRIGADA------------------
//                            case 2:
//                                JOptionPane.showMessageDialog(null, "Ha seleccionado Agregar Brigada");
//                                int idCuartelElegido = cua1.mostrarOpcionesYObtenerSeleccion(connection);
//
//                                Cuartel cuartel = cua1.buscarCuartelPorId(idCuartelElegido, connection); // Obtiene el cuartel por su ID
//
//                                if (cuartel != null) {
//                                    // Verificar si hay lugar para una nueva brigada en el cuartel
//                                    if (brig.hayCupoParaNuevaBrigada(idCuartelElegido)) {
//                                        String nombreBrigada = JOptionPane.showInputDialog("Ingrese el nombre de la brigada:");
//
//                                        // Verificar si el nombre de la brigada ya existe en ese cuartel
//                                        if (brig.existeBrigadaConNombreEnCuartel(nombreBrigada, idCuartelElegido)) {
//                                            JOptionPane.showMessageDialog(null, "Ya existe una brigada con el mismo nombre en este cuartel. No se puede agregar.");
//                                        } else {
//                                            String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad de la brigada:");
//
//                                            Brigada briga = new Brigada(nombreBrigada, especialidad, true, cuartel, true);
//                                            brig.guardarBrigada(briga);
//                                            JOptionPane.showMessageDialog(null, "Brigada agregada exitosamente.");
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "El cuartel está completo. No se puede agregar más brigadas.");
//                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "No se pudo obtener el cuartel. Asegúrate de que el cuartel seleccionado sea válido.");
//                                }
//                                break;
//
//                            //-------------------------------AGREGAR BOMBERO-------------------------------------    
//                            case 3:
//
//                                JOptionPane.showMessageDialog(null, "Ha seleccionado Agregar Bombero");
//                                int idBrigadaElegido = brig.mostrarOpciones(connection);
//
//                                Brigada idBrigada = brig.buscarBrigadaPorId(idBrigadaElegido);
//
//                                //Bombero bomb = bom.buscarBomberoId(idBrigadaElegido);
//                                if (idBrigada != null) {
//
//                                    if (bom.hayCupoParaNuevoBombero(idBrigadaElegido)) {
//                                        //String nombreBrigada = JOptionPane.showInputDialog("Ingrese el nombre de la brigada:");
//
//                                        int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del Bombero: "));
//                                        String nombreApellido = JOptionPane.showInputDialog("Ingrese nombre y apellido del Bombero");
//
//                                        //Verificar si el nombre del bombero ya existe en ese cuartel
//                                        if (bom.existeBomberoConNombre(nombreApellido, dni, connection)) {
//                                            JOptionPane.showMessageDialog(null, "Ya existe un bombero con el mismo nombre en esta brigada. No se puede agregar.");
//                                        } else {
//                                            String grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo Sanguineo: ");
//                                            LocalDate fechaNac = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del Bombero (AAAA-MM-DD):"));
//                                            String celular = JOptionPane.showInputDialog("Ingrese el número de celular del Bombero:");
//
//                                            Bombero bom1 = new Bombero(dni, nombreApellido, grupoSanguineo, fechaNac, celular, idBrigada, true);
//                                            bom.guardarBombero(bom1);
//
//                                            //JOptionPane.showMessageDialog(null, "Bombero agregado exitosamente.");
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "Brifada Completa. No se puede agregar más bomberos.");
//                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "No se pudo obtener la brigada. Asegúrate de que la brigada seleccionada sea válida.");
//                                }
//
//                                break;
//
//                            case 4:
//                                JOptionPane.showMessageDialog(null, "Ha seleccionado Salir. ¡Hasta luego!");
//                                System.exit(0);
//                                break;
//
//                            case 5:
//                                // Volver al menú anterior
//                                break;
//                            default:
//                                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 1, 2, 3, 4 o 5.");
//                        }
//                    }
//                    break;
//
////---------------------------------------MODIFICAR----------------------------------------------------------------------------------                    
////                
//              case 2:
//                    JOptionPane.showMessageDialog(null, "Ha seleccionado Modificar");
//
//                    int subOpcionModificar = 0;
//                    while (subOpcionModificar != 5) {
//                        String subInput = JOptionPane.showInputDialog("Elija qué modificar:\n1. Curtel\n2. Brigada\n3. Bombero\n4. Salir\n5. Volver al menú anterior");
//
//                        // Convierte la entrada del usuario a un número entero
//                        subOpcion = Integer.parseInt(subInput);
//
//                        switch (subOpcion) {
//                            case 1: // Modificar Cuartel
//                                JOptionPane.showMessageDialog(null, "Seleccione el cuartel que desea modificar:");
//
//                                int idCuartelAModificar = cua1.mostrarOpcionesYObtenerSeleccion(connection);
//                                    System.out.println(""+idCuartelAModificar);
//                                    String nuevoNombreCuartel = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cuartel:");
//                                    cua1.actualizarNombreCuartel(idCuartelAModificar, nuevoNombreCuartel);
//                                    
////                                Cuartel cuartelAModificar = cua1.buscarCuartelPorId(idCuartelAModificar);
////                                
////
////                                if (cuartelAModificar != null) {
////
////                                    String nuevoNombreCuartel = JOptionPane.showInputDialog("Ingrese el nuevo nombre del cuartel:");
////                                    if (!nuevoNombreCuartel.isEmpty()) {
////                                        cuartelAModificar.setNombreCuartel(nuevoNombreCuartel);
////                                    }
////
////                                    // Repite este proceso para otros atributos que desees modificar, como dirección, longitud, latitud, teléfono, correo, etc.
////                                    // Luego, actualiza el cuartel en la base de datos
////                                    cua1.modificarCuartel(cuartelAModificar);
//
//                                    JOptionPane.showMessageDialog(null, "Cuartel modificado exitosamente.");
////                                } else {
////                                    JOptionPane.showMessageDialog(null, "No se pudo encontrar el cuartel seleccionado. Asegúrate de que el cuartel sea válido.");
////                                }
//                                break;
//
//                            case 2:
//                                // Lógica para modificar brigada
//                                break;
//                            case 3:
//                                // Lógica para modificar bombero
//                                break;
//                            case 4:
//                                JOptionPane.showMessageDialog(null, "Ha seleccionado Salir. ¡Hasta luego!");
//                                System.exit(0);
//                                break;
//                            case 5:
//                                // Lógica para volver al menú anterior
//                                break;
//                            default:
//                                JOptionPane.showMessageDialog(null, "Opción no válida");
//                                break;
//                        }
//                    }
//
//                    break;
//                
//              //  case 2: // Modificar
////                    int subOpcionModificar = 0;
////                    while (subOpcionModificar != 4) {
////                        String subInputModificar = JOptionPane.showInputDialog("Elija qué modificar:\n1. Cuartel\n2. Brigada\n3. Bombero\n4. Volver al menú principal");
////
////                        try {
////                            subOpcionModificar = Integer.parseInt(subInputModificar);
////                        } catch (NumberFormatException e) {
////                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número válido.");
////                            continue; // Volver al inicio del bucle
////                        }
////
////                        switch (subOpcionModificar) {
////                            case 1: // Modificar Cuartel
////                                int idCuartelModificar = cua1.mostrarOpcionesYObtenerSeleccion(connection);
////
////                                break;
////                            case 2: // Modificar Brigada
////                                // Aquí puedes realizar la lógica para modificar una brigada
////                                break;
////                            case 3: // Modificar Bombero
////                                // Aquí puedes realizar la lógica para modificar un bombero
////                                break;
////                            case 4: // Volver al menú principal
////                                break;
////                            default:
////                                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 1, 2, 3 o 4.");
////                        }
////                    }
////                    break;
//
////----------------------------------------------ELIMINAR----------------------------------------------------------------------------
//               
//
//                            
//                case 3:
//                    JOptionPane.showMessageDialog(null, "Ha seleccionado Eliminar");
//                    // Aquí puedes realizar la lógica para eliminar
//
//                    int subOpcionEliminar = 0;
//                    while (subOpcionEliminar != 4) {
//                        String subInputEliminar = JOptionPane.showInputDialog("Elija qué eliminar:\n1. Cuartel\n2. Brigada\n3. Bombero\n4. Volver al menú principal");
//
//                        try {
//                            subOpcionEliminar = Integer.parseInt(subInputEliminar);
//                        } catch (NumberFormatException e) {
//                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número válido.");
//                            continue; // Volver al inicio del bucle
//                        }
//
//                        switch (subOpcionEliminar) {
//                            //--------------------Eliminar Cuartel-----------------------
//                            case 1: //ELIMINAR CUARTEL
//                                int idCuartelAEliminar= cua1.mostrarCuartelesAEliminar(connection);
//                                List<Integer> idsBrigadas = brig.obtenerIdsBrigadasPorIdCuartel(idCuartelAEliminar, connection);
//                                bom.cambiarEstadoBomberosPorBrigadas(idsBrigadas, connection);
//                                brig.cambiarEstadoBrigadas(idsBrigadas, connection);
//                                cua1.cambiarEstadoCuartel(idCuartelAEliminar, connection);
//                                
//                                break;
//
//                            //-----------------Eliminar Brigada---------------------
//                            case 2: //ELIMINAR BRIGADA
//                                int idBrigadaAEliminar = brig.mostrarBrigadasAEliminar(connection);
//                                List<Integer> idsBomberosAEliminar = bom.obtenerBomberosPorBrigada(idBrigadaAEliminar, connection);
//                                bom.cambiarEstadoBomberosPorBrigada(idBrigadaAEliminar, connection);
//                                brig.cambiarEstadoBrigada(idBrigadaAEliminar, connection);
//                                
//                                break;
//
//                            //---------------ELIMINAR BOMBERO------------------------    
//                            case 3: //ELIMINAR BOMBERO
//                                int idBomberoAEliminar = bom.mostrarBomberosAEliminar(connection);
//                                if (idBomberoAEliminar != -1) {
//                                    bom.cambiarEstadoBombero(idBomberoAEliminar, connection);
//                                }
//                                break;
//                            case 4:
//                                // Volver al menú principal
//                                break;
//                            default:
//                                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 1, 2, 3 o 4.");
//                        }
//                    }
//
//                    break;
//
//                case 4:
//                    JOptionPane.showMessageDialog(null, "Ha seleccionado Salir. ¡Hasta luego!");
//                    break;
//                default:
//                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 1, 2, 3 o 4.");
//            }
//        }
//
//    }
//
//}

// Clase BrigadaData (Proyecto BomberosGrupo5)
package bomberosgrupo5.accesoADatos;

import bomberosgrupo5.entidades.Brigada;
import bomberosgrupo5.entidades.Cuartel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class BrigadaData {
private Connection con;
 public BrigadaData(Connection con) {
    this.con = con;
}
   

//------------------------------------------------------------------------------
//método guardar Brigada:
 
 public void guardarBrigada(Brigada brigada) {
    String sql = "INSERT INTO brigada (nombreBrig, especialidad, libre, Cuartel, estadoBr) VALUES (?, ?, ?, ?, ?)";

    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, brigada.getNombreBrig());
        ps.setString(2, brigada.getEspecialidad());
        ps.setBoolean(3, brigada.isLibre());
        ps.setInt(4, brigada.getCuartel().getCuartel());
        ps.setBoolean(5, brigada.isEstadoBr());

        int rowsAffected = ps.executeUpdate();

        if (rowsAffected > 0) {
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                brigada.setIdBrigada(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Brigada Agregada Exitosamente");
            }
            ps.close();
        } else {
            JOptionPane.showMessageDialog(null, "La ID de brigada ya existe en la base de datos. No se pudo agregar la brigada.");
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla brigada: " + ex.getMessage());
    }
}

 
 
 
//    public void guardarBrigada(Brigada brigada) {
//        
//            
//            String sql = "INSERT INTO brigada (nombreBrig, especialidad, libre, Cuartel, estadoBr)"
//                    + " VALUES (?, ?, ?, ?, ?)";
//
//            try {
//                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//                ps.setString(1, brigada.getNombreBrig());
//                ps.setString(2, brigada.getEspecialidad());
//                ps.setBoolean(3, brigada.isLibre());
//                ps.setInt(4, brigada.getCuartel().getIdCuartel());
//                ps.setBoolean(5, brigada.isEstadoBr());
//
//                ps.executeUpdate();
//
//                ResultSet rs=ps.getGeneratedKeys();
//
//                if (rs.next()) {
//                    brigada.setIdBrigada(rs.getInt(1));
//                    JOptionPane.showMessageDialog(null, "Brigada Agregada Exitosamente ");
//                }
//                ps.close();
//                
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error al acceder a la Tabla brigada ");
//            }
//       
//        }
//    ---------------------------------------------------------------------------------------
    
    public int obtenerIdBrigada(String nombreBrigada) {
    int idBrigada = -1; // Valor predeterminado si no se encuentra ninguna coincidencia
    
//    String sql = "SELECT Brigada FROM brigada WHERE nombreBrig = ?";
        String sql = "SELECT Brigada FROM brigada WHERE nombreBrig = ?";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreBrigada);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            idBrigada = rs.getInt("Brigada");
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        // Manejo de errores
        ex.printStackTrace();
    }
    
    return idBrigada;
}



    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

//-------------------desde aca------------------------
    
public int contarBrigadasPorCuartel(int numeroCuartel) {
        int cantidadBrigadas = 0;

        try {
            String sql = "SELECT COUNT(*) AS cantidad FROM brigada WHERE Cuartel = ? AND estadoBr = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numeroCuartel);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cantidadBrigadas = rs.getInt("cantidad");
            }

            ps.close();
        } catch (SQLException ex) {
            // Manejar excepciones, por ejemplo, imprimir el error
            ex.printStackTrace();
        }
        System.out.println("cant "+cantidadBrigadas);
        return cantidadBrigadas;
    }





public boolean hayCupoParaNuevaBrigada(int numeroCuartel) {
    int cantidadBrigadas = contarBrigadasPorCuartel(numeroCuartel);
    int capacidadMaxima = 3; // Cambia esto según la capacidad máxima de brigadas por cuartel que desees

    return cantidadBrigadas < capacidadMaxima;
}

//brigadas con el mismo nombre
public boolean existeBrigadaConNombreEnCuartel(String nombreBrigada, int idCuartel) {
    String sql = "SELECT COUNT(*) FROM brigada WHERE nombreBrig = ? AND Cuartel = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nombreBrigada);
        ps.setInt(2, idCuartel);
        ResultSet rs = ps.executeQuery();

        if (rs.next() && rs.getInt(1) > 0) {
            return true; // Ya existe una brigada con el mismo nombre en el cuartel especificado
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al verificar la existencia de la brigada en el cuartel.");
    }
    return false; // No existe una brigada con el mismo nombre en el cuartel especificado
}


//-----------------------metodo listar brigadas-----------------------------------------

     public int mostrarOpciones(Connection con) {
     int idBrigadaElegida = -1; // Valor predeterminado para indicar que no se ha seleccionado ninguna brigada
    List<String> nombresBrigadas = new ArrayList<>();

    String sql = "SELECT idBrigada, nombreBrig FROM brigada WHERE estadoBr = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idBrigada = rs.getInt("idBrigada");
            String nombreBrigada = rs.getString("nombreBrig");

            nombresBrigadas.add(idBrigada + ". " + nombreBrigada);
        }
        ps.close();

        if (!nombresBrigadas.isEmpty()) {
            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Elija una brigada:\n" + String.join("\n", nombresBrigadas),
                    "Selección de Brigada",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    nombresBrigadas.toArray(),
                    nombresBrigadas.get(0));

            if (seleccion != null) {
                String[] parts = seleccion.split("\\. ");
                if (parts.length == 2) {
                    idBrigadaElegida = Integer.parseInt(parts[0]);
                    System.out.println(" id " + idBrigadaElegida);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener nombres de brigadas: " + ex.getMessage());
    }

    return idBrigadaElegida;
}
 
//-----------------------------------------------------------------------------------------


//-------------------buscar brigada por id-----------------
     public Brigada buscarBrigadaPorId(int idBrigada) {
    String sql = "SELECT nombreBrig, especialidad, libre, Cuartel, estadoBr FROM brigada WHERE idBrigada = ?";
    Brigada brigada = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idBrigada);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            brigada = new Brigada();
            brigada.setIdBrigada(idBrigada);
            brigada.setNombreBrig(rs.getString("nombreBrig"));
            brigada.setEspecialidad(rs.getString("especialidad"));
            brigada.setLibre(rs.getBoolean("libre"));
            brigada.setEstadoBr(rs.getBoolean("estadoBr"));
        } else {
            JOptionPane.showMessageDialog(null, "No existe la brigada con el ID indicado");
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla brigada: " + ex.getMessage());
    }
    
    return brigada;
}
//------------------------------------------------------------------------------
     
     
//----------------------------Eliminar Brigada----------------------------
     //-------------Lista brigadas disponibles a eliminar----------------
public int mostrarBrigadasAEliminar(Connection con) {
    int idBrigadaAEliminar = -1; // Valor predeterminado para indicar que no se ha seleccionado ninguna brigada
    List<String> brigadasAEliminar = new ArrayList<>();

    String sql = "SELECT idBrigada, nombreBrig FROM brigada WHERE estadoBr = 1";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idBrigada = rs.getInt("idBrigada");
            String nombreBrigada = rs.getString("nombreBrig");

            brigadasAEliminar.add(idBrigada + ". Nombre: " + nombreBrigada);
        }
        ps.close();

        if (!brigadasAEliminar.isEmpty()) {
            String seleccion = (String) JOptionPane.showInputDialog(null,
                    "Elija una brigada a eliminar:\n" + String.join("\n", brigadasAEliminar),
                    "Selección de Brigada a Eliminar",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    brigadasAEliminar.toArray(),
                    brigadasAEliminar.get(0));

            if (seleccion != null) {
                String[] parts = seleccion.split("\\. ");
                if (parts.length == 2) {
                    idBrigadaAEliminar = Integer.parseInt(parts[0]);
                    System.out.println("ID de la Brigada a eliminar: " + idBrigadaAEliminar);
                }
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la lista de brigadas a eliminar: " + ex.getMessage());
    }

    return idBrigadaAEliminar;
}

     
     //------------------------------------------------------------------
     
     




}






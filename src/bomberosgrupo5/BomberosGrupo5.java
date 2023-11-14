// Main para realizar la pruebas de clases Data
package bomberosgrupo5;

import java.sql.*;
import bomberosgrupo5.accesoADatos.BomberoData;
import bomberosgrupo5.accesoADatos.BrigadaData;
import bomberosgrupo5.accesoADatos.Conexion;
import bomberosgrupo5.accesoADatos.CuartelData;
import bomberosgrupo5.accesoADatos.SiniestroData;
import bomberosgrupo5.entidades.Bombero;
import bomberosgrupo5.entidades.Brigada;
import bomberosgrupo5.entidades.Cuartel;
import bomberosgrupo5.entidades.Siniestro;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
//import org.mariadb.jdbc.Connection;

//** @author Asus
public class BomberosGrupo5 {

    private static Brigada idBrigada;

    public static void main(String[] args) throws ParseException {
        Conexion con = new Conexion();
        Connection connection = (Connection) con.getConexion(); // Obtener la conexión válida

        BrigadaData brig = new BrigadaData(connection);
        CuartelData cua1 = new CuartelData(connection);
        BomberoData bom = new BomberoData(connection);
        SiniestroData sin = new SiniestroData(connection);

        int opcion = 0;

        while (opcion != 5) {

            String input = JOptionPane.showInputDialog("Elija una acción:\n1. Agregar\n2. Modificar\n3. Eliminar\n4. Siniestro\n5. Salir");
            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número válido.");
                continue; // Volver al inicio del bucle
            }

            switch (opcion) {
                case 1:
                    int subOpcion = 0;
                    while (subOpcion != 5) {
                        String subInput = JOptionPane.showInputDialog("Elija qué agregar:\n1. Cuartel\n2. Brigada\n3. Bombero\n4. Salir\n5. Volver al menú anterior");

                        try {
                            subOpcion = Integer.parseInt(subInput);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número válido.");
                            continue; // Volver al inicio del bucle
                        }
//-------------------------------------------------------AGREGAR----------------------------------------------------------------------------

                        switch (subOpcion) {
                            //--------------------AGREGAR CUARTEL---------------
                            case 1:

                                JOptionPane.showMessageDialog(null, "Complete los datos para agregar un nuevo cuartel");
                                String nombreCuartel = JOptionPane.showInputDialog("Ingrese el nombre del cuartel:");

                                if (cua1.existeCuartelConNombre(nombreCuartel)) {
                                    JOptionPane.showMessageDialog(null, "Ya existe un cuartel con el mismo nombre. No se puede agregar.");
                                } else {
                                    String direccion = JOptionPane.showInputDialog("Ingrese la dirección del cuartel:");
                                    int longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud del cuartel (entero):"));
                                    int latitud = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la latitud del cuartel (entero):"));
                                    String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del cuartel:");
                                    String correo = JOptionPane.showInputDialog("Ingrese el correo del cuartel:");

                                    Cuartel cuar2 = new Cuartel(nombreCuartel, direccion, longitud, latitud, telefono, correo, true);
                                    cua1.guardarCuartel(cuar2);
                                }
                                break;
                            //--------------------------------------AGREGAR BRIGADA------------------
                            case 2:
                                JOptionPane.showMessageDialog(null, "Ha seleccionado Agregar Brigada");
                                int idCuartelElegido = cua1.mostrarOpcionesYObtenerSeleccion(connection);

                                Cuartel cuartel = cua1.buscarCuartelPorId(idCuartelElegido); // Obtiene el cuartel por su ID

                                if (cuartel != null) {
                                    // Verificar si hay lugar para una nueva brigada en el cuartel
                                    if (brig.hayCupoParaNuevaBrigada(idCuartelElegido)) {
                                        String nombreBrigada = JOptionPane.showInputDialog("Ingrese el nombre de la brigada:");

                                        // Verificar si el nombre de la brigada ya existe en ese cuartel
                                        if (brig.existeBrigadaConNombreEnCuartel(nombreBrigada, idCuartelElegido)) {
                                            JOptionPane.showMessageDialog(null, "Ya existe una brigada con el mismo nombre en este cuartel. No se puede agregar.");
                                        } else {
                                            String especialidad = JOptionPane.showInputDialog("Ingrese la especialidad de la brigada:");

                                            Brigada briga = new Brigada(nombreBrigada, especialidad, true, cuartel, true);
                                            brig.guardarBrigada(briga);
                                            JOptionPane.showMessageDialog(null, "Brigada agregada exitosamente.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "El cuartel está completo. No se puede agregar más brigadas.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo obtener el cuartel. Asegúrate de que el cuartel seleccionado sea válido.");
                                }
                                break;

                            //-------------------------------AGREGAR BOMBERO-------------------------------------    
                            case 3:

                                JOptionPane.showMessageDialog(null, "Ha seleccionado Agregar Bombero");
                                int idBrigadaElegido = brig.mostrarOpciones(connection);

                                Brigada idBrigada = brig.buscarBrigadaPorId(idBrigadaElegido, connection);

                                //Bombero bomb = bom.buscarBomberoId(idBrigadaElegido);
                                if (idBrigada != null) {

                                    if (bom.hayCupoParaNuevoBombero(idBrigadaElegido)) {
                                        //String nombreBrigada = JOptionPane.showInputDialog("Ingrese el nombre de la brigada:");

                                        int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del Bombero: "));
                                        String nombreApellido = JOptionPane.showInputDialog("Ingrese nombre y apellido del Bombero");

                                        //Verificar si el nombre del bombero ya existe en ese cuartel
                                        if (bom.existeBomberoConNombre(nombreApellido, dni, connection)) {
                                            JOptionPane.showMessageDialog(null, "Ya existe un bombero con el mismo nombre en esta brigada. No se puede agregar.");
                                        } else {
                                            String grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo Sanguineo: ");
                                            LocalDate fechaNac = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del Bombero (AAAA-MM-DD):"));
                                            String celular = JOptionPane.showInputDialog("Ingrese el número de celular del Bombero:");

                                            Bombero bom1 = new Bombero(dni, nombreApellido, grupoSanguineo, fechaNac, celular, idBrigada, true);
                                            bom.guardarBombero(bom1);

                                            //JOptionPane.showMessageDialog(null, "Bombero agregado exitosamente.");
                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Brifada Completa. No se puede agregar más bomberos.");
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo obtener la brigada. Asegúrate de que la brigada seleccionada sea válida.");
                                }

                                break;

                            case 4:
                                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                                System.exit(0);
                                break;

                            case 5:
                                // Volver al menú anterior
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 1, 2, 3, 4 o 5.");
                        }
                    }
                    break;

//-----------------------------------------------------FIN AGREGAR----------------------------------------------------------------------------
//---------------------------------------MODIFICAR----------------------------------------------------------------------------------                    
//                
                case 2:
                    JOptionPane.showMessageDialog(null, "Ha seleccionado Modificar");

                    int subOpcionModificar = 0;
                    while (subOpcionModificar != 5) {
                        String subInput = JOptionPane.showInputDialog("Elija qué modificar:\n1. Cuartel\n2. Brigada\n3. Bombero\n4. Salir");
                        subOpcion = Integer.parseInt(subInput);

                        //-----------------------------modificar cuartel-------------------------------------------------
                        switch (subOpcion) {
                            case 1:
                                int idCuartelAModificar = cua1.mostrarOpcionesYObtenerSeleccion(connection);
                                Cuartel cuartelAModificar = cua1.buscarCuartelPorId(idCuartelAModificar);

                                if (cuartelAModificar != null) {
                                    int atributoSeleccionado = 0;

                                    while (atributoSeleccionado != 7) {
                                        String opcionesAtributos = "Seleccione el atributo que desea modificar:\n"
                                                + "1. Nombre\n"
                                                + "2. Dirección\n"
                                                + "3. Coordenada X\n"
                                                + "4. Coordenada Y\n"
                                                + "5. Teléfono\n"
                                                + "6. Correo\n"
                                                + "7. Salir";

                                        String atributoInput = JOptionPane.showInputDialog(opcionesAtributos);
                                        atributoSeleccionado = Integer.parseInt(atributoInput);

                                        if (atributoSeleccionado >= 1 && atributoSeleccionado <= 6) {
                                            switch (atributoSeleccionado) {
                                                case 1:
                                                    cua1.modificarNombre(idCuartelAModificar, connection);
                                                    break;
                                                case 2:
                                                    cua1.modificarDireccion(idCuartelAModificar, connection);
                                                    break;
                                                case 3:
                                                    cua1.modificarCoordX(idCuartelAModificar, connection);
                                                    break;
                                                case 4:
                                                    cua1.modificarCoordY(idCuartelAModificar, connection);
                                                    break;
                                                case 5:
                                                    cua1.modificarTelefono(idCuartelAModificar, connection);
                                                    break;
                                                case 6:
                                                    cua1.modificarCorreo(idCuartelAModificar, connection);
                                                    break;
//                                            case 7:
//                                                // Opción para salir
//                                                break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opción no válida");
                                                    break;
                                            }
                                        } else if (atributoSeleccionado != 7) {
                                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija un número del 1 al 7.");
                                        }
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo obtener el cuartel. Asegúrate de que el cuartel seleccionado sea válido.");
                                }
                                break;

                            //--------------------------------------------MODIFICAR BRIGADA---------------------------------- 
                            case 2://Modificar Brigada

                                int idBrigadaAModificar = brig.mostrarOpciones(connection);
                                Brigada brigadaAModificar = brig.buscarBrigadaPorId(idBrigadaAModificar, connection);

                                if (brigadaAModificar != null) {
                                    int atributoSeleccionado = 0;

                                    while (atributoSeleccionado != 4) {
                                        String opcionesAtributos = "Seleccione el atributo que desea modificar:\n"
                                                + "1. Nombre\n"
                                                + "2. Especialidad\n"
                                                + "3. Estado (Ocupada o Desocupada)\n"
                                                + "4. Salir";

                                        String atributoInput = JOptionPane.showInputDialog(opcionesAtributos);
                                        atributoSeleccionado = Integer.parseInt(atributoInput);

                                        if (atributoSeleccionado >= 1 && atributoSeleccionado <= 3) {
                                            switch (atributoSeleccionado) {
                                                case 1:
                                                    brig.modificarNombreBrigada(idBrigadaAModificar, connection);

                                                    break;
                                                case 2:
                                                    brig.modificarEspecialidad(idBrigadaAModificar, connection);
                                                    break;
                                                case 3:
                                                    boolean nuevoEstado = brig.obtenerEstado();

                                                    brig.modificarEstado(idBrigadaAModificar, nuevoEstado, connection);

                                                    break;

                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opción no válida");
                                                    break;
                                            }
                                        } else if (atributoSeleccionado != 4) {
                                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija un número del 1 al 7.");
                                        }
                                    }

                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo obtener el cuartel. Asegúrate de que el cuartel seleccionado sea válido.");
                                }

                                break;

                            //-------------------------------------MODIFICAR BOMBERO----------------------     
                            case 3:

                                int idBomberoAModificar = bom.mostrarOpcionesBomberos(connection);
                                Bombero bomberoAModificar = bom.buscarBomberoPorId(idBomberoAModificar, connection);
                                if (bomberoAModificar != null) {
                                    int atributoSeleccionadoBombero = 0;

                                    while (atributoSeleccionadoBombero != 5) {
                                        String opcionesAtributosBombero = "Seleccione el atributo que desea modificar:\n"
                                                + "1. Nombre y Apellido\n"
                                                + "2. Grupo Sanguíneo\n"
                                                + "3. Fecha de Nacimiento\n"
                                                + "4. Celular\n"
                                                + "5. Salir";

                                        String atributoInputBombero = JOptionPane.showInputDialog(opcionesAtributosBombero);
                                        atributoSeleccionadoBombero = Integer.parseInt(atributoInputBombero);

                                        if (atributoSeleccionadoBombero >= 1 && atributoSeleccionadoBombero <= 4) {
                                            switch (atributoSeleccionadoBombero) {
                                                case 1:
                                                    bom.modificarNombreBombero(idBomberoAModificar, connection);
                                                    break;
                                                case 2:
                                                    bom.modificarGrupoSanguineoBombero(idBomberoAModificar, connection);
                                                    break;
                                                case 3:
                                                    bom.modificarFechaNacimientoBombero(idBomberoAModificar, connection);
                                                    break;
                                                case 4:
                                                    bom.modificarNumeroCelularBombero(idBomberoAModificar, connection);
                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opción no válida");
                                                    break;
                                            }
                                        } else if (atributoSeleccionadoBombero != 5) {
                                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija un número del 1 al 5.");
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo obtener el bombero. Asegúrate de que el bombero seleccionado sea válido.");
                                }
                                break;

                            case 4:
                                JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                                System.exit(0);
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida");
                                break;
                        }
                    }

                    break;

//--------------------------------------- FIN MODIFICAR-----------------------------------------------------------------------------                     
//----------------------------------------------ELIMINAR----------------------------------------------------------------------------
                case 3:
                    JOptionPane.showMessageDialog(null, "Ha seleccionado Eliminar");

                    int subOpcionEliminar = 0;

                    while (subOpcionEliminar != 4) {
                        String subInputEliminar = JOptionPane.showInputDialog("Elija qué eliminar:\n1. Cuartel\n2. Brigada\n3. Bombero\n4. Volver al menú principal");
                        subOpcionEliminar = Integer.parseInt(subInputEliminar);

                        switch (subOpcionEliminar) {
                            //--------------------Eliminar Cuartel-----------------------
                            case 1: // ELIMINAR CUARTEL
                                int idCuartelAEliminar = cua1.mostrarCuartelesAEliminar(connection);
                                List<Integer> idsBrigadas = brig.obtenerIdsBrigadasPorIdCuartel(idCuartelAEliminar, connection);
                                bom.cambiarEstadoBomberosPorBrigadas(idsBrigadas, connection);
                                brig.cambiarEstadoBrigadas(idsBrigadas, connection);
                                cua1.cambiarEstadoCuartel(idCuartelAEliminar, connection);
                                break;

                            //-----------------Eliminar Brigada---------------------
                            case 2: // ELIMINAR BRIGADA
                                int idBrigadaAEliminar = brig.mostrarBrigadasAEliminar(connection);
                                List<Integer> idsBomberosAEliminar = bom.obtenerBomberosPorBrigada(idBrigadaAEliminar, connection);
                                bom.cambiarEstadoBomberosPorBrigada(idBrigadaAEliminar, connection);
                                brig.cambiarEstadoBrigada(idBrigadaAEliminar, connection);
                                break;

                            //---------------ELIMINAR BOMBERO------------------------    
                            case 3: // ELIMINAR BOMBERO
                                int idBomberoAEliminar = bom.mostrarBomberosAEliminar(connection);
                                if (idBomberoAEliminar != -1) {
                                    bom.cambiarEstadoBombero(idBomberoAEliminar, connection);
                                }
                                break;

                            case 4:
                                // Volver al menú principal
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida");
                                break;
                        }
                    }

                    break;

//---------------------------------------------- FIN ELIMINAR-----------------------------------------------------------------------                    
//----------------------------------------------SINIESTRO----------------------------------------------------------------------------                    
                case 4:
                    JOptionPane.showMessageDialog(null, "Ha seleccionado Siniestros");

                    int subOpcionSiniestro = 0;
                    while (subOpcionSiniestro != 4) {
                        String subInputSiniestro = JOptionPane.showInputDialog("Elija qué hacer con los siniestros:\n1. Agregar\n2. Modificar\n3. Eliminar\n4. Volver al menú principal");

                        try {
                            subOpcionSiniestro = Integer.parseInt(subInputSiniestro);
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, ingrese un número válido.");
                            continue;
                        }

                        switch (subOpcionSiniestro) {
                            //--------------------Agregar Siniestro-----------------------
                            case 1:
                                JOptionPane.showMessageDialog(null, "Selecciona a que brigada vas a cargar este siniestro");
                                int idBrigadaElegido = brig.brigadasLibres(connection);
                                brig.brigadaOcupada(idBrigadaElegido, connection);
                                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de siniestro:");
                                String fechaHoraSiniestroI = JOptionPane.showInputDialog("Ingrese la fecha y hora del siniestro (dd/MM/yyyy HH:mm):");
                                int coordx = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la coordenada x:"));
                                int coordy = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la coordenada y:"));
                                String detalles = JOptionPane.showInputDialog("Ingrese los detalles del siniestro:");
                                String fechaHoraResolI = JOptionPane.showInputDialog("Ingrese la fecha de resolución en caso de tener o deje el campo en blanco:");
                                int puntuacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la puntuación:"));

                                try {
                                    Timestamp fechaHoraSiniestro = sin.convertirAFechaHora(fechaHoraSiniestroI);
                                    Timestamp fechaHoraResol = (fechaHoraResolI.isEmpty()) ? null : sin.convertirAFechaHora(fechaHoraResolI);

                                    sin.insertarSiniestro(connection, idBrigadaElegido, tipo, fechaHoraSiniestro, coordx, coordy, detalles, fechaHoraResol, puntuacion);

                                    JOptionPane.showMessageDialog(null, "Siniestro registrado con éxito.");
                                } catch (ParseException | SQLException e) {
                                    e.printStackTrace();
                                    JOptionPane.showMessageDialog(null, "Error al convertir la fecha y hora o al insertar el siniestro en la base de datos.");
                                }
                                break;

                            //-----------------Modificar Siniestro---------------------
                            case 2:
                                int idSiniestroAModificar = sin.mostrarOpcionesSiniestros(connection);

                                // Verifica si el idSiniestroAModificar es válido
                                if (idSiniestroAModificar != -1) {
                                    int atributoSeleccionadoSiniestro = 0;

                                    while (atributoSeleccionadoSiniestro != 8) {
                                        String opcionesAtributosSiniestro = "Seleccione el atributo que desea modificar:\n"
                                                + "1. Tipo\n"
                                                + "2. Fecha de Siniestro\n"
                                                + "3. Coordenada X\n"
                                                + "4. Coordenada Y\n"
                                                + "5. Detalles\n"
                                                + "6. Fecha de Resolución\n"
                                                + "7. Puntuación\n"
                                                + "8. Salir";

                                        String atributoInputSiniestro = JOptionPane.showInputDialog(opcionesAtributosSiniestro);
                                        atributoSeleccionadoSiniestro = Integer.parseInt(atributoInputSiniestro);

                                        if (atributoSeleccionadoSiniestro >= 1 && atributoSeleccionadoSiniestro <= 7) {
                                            switch (atributoSeleccionadoSiniestro) {
                                                case 1:
                                                    sin.modificarTipoSiniestro(idSiniestroAModificar, connection);
                                                    break;
                                                case 2:
                                                    sin.modificarFechaSiniestro(idSiniestroAModificar, connection);
                                                    break;
                                                case 3:
                                                    sin.modificarCoordenadaX(idSiniestroAModificar, connection);
                                                    break;
                                                case 4:
                                                    sin.modificarCoordenadaY(idSiniestroAModificar, connection);
                                                    break;
                                                case 5:
                                                    sin.modificarDetallesSiniestro(idSiniestroAModificar, connection);
                                                    break;
//                                                case 6:
//                                                    sin.modificarFechaResolucion(idSiniestroAModificar, connection);
//                                                    break;
//                                                case 7:
//                                                    sin.modificarPuntuacion(idSiniestroAModificar, connection);
//                                                    break;
                                                default:
                                                    JOptionPane.showMessageDialog(null, "Opción no válida");
                                                    break;
                                            }
                                        } else if (atributoSeleccionadoSiniestro != 8) {
                                            JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija un número del 1 al 8.");
                                        }
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se pudo obtener el id del siniestro. Asegúrate de que el siniestro seleccionado sea válido.");
                                }
                                break;

                            //---------------Eliminar Siniestro------------------------
                            case 3:
                                // Código para eliminar un siniestro
                                // Puedes utilizar un método similar a sin1.mostrarSiniestrosAEliminar(connection)
                                // Asegúrate de obtener el ID del siniestro que se va a eliminar del usuario
                                break;

                            case 4:
                                // Volver al menú principal
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 1, 2, 3 o 4.");
                        }
                    }

                    break;
//---------------------------------------------- FIN SINIESTRO-----------------------------------------------------------------------                    
//----------------------------------------------SALIR----------------------------------------------------------------------------                                     
                case 5:
                    JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    opcion = 5;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor, elija 1, 2, 3, 4 o 5.");
            }
        }

    }

}

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

public class BomberosGrupo5 {

    // private static Brigada idBrigada;
    public static void main(String[] args) throws ParseException {
        Connection con = Conexion.getConexion();

        BrigadaData brig = new BrigadaData();
        CuartelData cua1 = new CuartelData();
        BomberoData bom = new BomberoData();
        SiniestroData sin = new SiniestroData();

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
//                            case 2:
//                                JOptionPane.showMessageDialog(null, "Ha seleccionado Agregar Brigada");
//
//                                // Obtener el cuartel por su ID
//                                //int idCuartelElegido = cua1.mostrarOpcionesYObtenerSeleccion();
//
//                                // Verificar si hay lugar para una nueva brigada en el cuartel
//                                if (brig.hayCupoParaNuevaBrigada(idCuartelElegido)) {
//                                    String nombreBrigada = JOptionPane.showInputDialog("Ingrese el nombre de la brigada:");
//
//                                    // Verificar si el nombre de la brigada es válido
//                                    if (nombreBrigada != null && !nombreBrigada.isEmpty()) {
//                                        // Verificar si el nombre de la brigada ya existe en ese cuartel
//                                        if (brig.existeBrigadaConNombreEnCuartel(nombreBrigada, idCuartelElegido)) {
//                                            JOptionPane.showMessageDialog(null, "Ya existe una brigada con el mismo nombre en este cuartel. No se puede agregar.");
//                                        } else {
//                                            String especialidad = brig.elegirEspecialidad();
//
//                                            // Crear y guardar la brigada
//                                            Brigada briga = new Brigada(nombreBrigada, especialidad, true, idCuartelElegido, true);
//                                            brig.guardarBrigada(briga);
//                                            System.out.println("" + briga);
//
////                                        }else {
////                                    JOptionPane.showMessageDialog(null, "El cuartel está completo. No se puede agregar más brigadas.");
//                                }
//                                    }
//                                }
//                                        break;
////                            case 2:
//                                        //                                JOptionPane.showMessageDialog(null, "Ha seleccionado Agregar Brigada");
//                                        //                                int idCuartelElegido = cua1.mostrarOpcionesYObtenerSeleccion(connection);
//                                        //                                Cuartel cuartel1 = cua1.buscarCuartelPorId(idCuartelElegido); // Obtiene el cuartel por su ID
//                                        //                                if (cuartel1 != null) {
//                                        //                                    // Verificar si hay lugar para una nueva brigada en el cuartel
//                                        //                                    if (brig.hayCupoParaNuevaBrigada(idCuartelElegido)) {
//                                        //                                        String nombreBrigada = JOptionPane.showInputDialog("Ingrese el nombre de la brigada:");
//                                        //
//                                        //                                        // Verificar si el nombre de la brigada ya existe en ese cuartel
//                                        //                                        if (brig.existeBrigadaConNombreEnCuartel(nombreBrigada, idCuartelElegido)) {
//                                        //                                            JOptionPane.showMessageDialog(null, "Ya existe una brigada con el mismo nombre en este cuartel. No se puede agregar.");
//                                        //                                        } else {
//                                        //                                           String especialidad = brig.elegirEspecialidad(connection);
//                                        //
//                                        //                                            Brigada briga = new Brigada(nombreBrigada, especialidad, true, cuartel1, true);
//                                        //                                            brig.guardarBrigada(briga);
//                                        //                                            JOptionPane.showMessageDialog(null, "Brigada agregada exitosamente.");
//                                        //                                        }
//                                        //                                    } else {
//                                        //                                        JOptionPane.showMessageDialog(null, "El cuartel está completo. No se puede agregar más brigadas.");
//                                        //                                    }
//                                        //                                } else {
//                                        //                                    JOptionPane.showMessageDialog(null, "No se pudo obtener el cuartel. Asegúrate de que el cuartel seleccionado sea válido.");
//                                        //                                }
//                                        //                                break;
//                                        //-------------------------------AGREGAR BOMBERO-------------------------------------    
//                                    

//                            case 3:
//
//                                JOptionPane.showMessageDialog(null, "Ha seleccionado Agregar Bombero");
//                                int idBrigadaElegido = brig.mostrarOpciones();
//
//                                Brigada idBrigada = brig.buscarBrigadaPorId(idBrigadaElegido);
//
//                                if (idBrigada != null) {
//
//                                    if (bom.hayCupoParaNuevoBombero(idBrigadaElegido)) {
//
//                                        int dni = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el DNI del Bombero: "));
//                                        String nombreApellido = JOptionPane.showInputDialog("Ingrese nombre y apellido del Bombero");
//
//                                        //Verificar si el nombre del bombero ya existe en ese cuartel
//                                        if (bom.existeBomberoConNombre(nombreApellido, dni)) {
//                                            JOptionPane.showMessageDialog(null, "Ya existe un bombero con el mismo nombre en esta brigada. No se puede agregar.");
//                                        } else {
//                                            String grupoSanguineo = JOptionPane.showInputDialog("Ingrese el grupo Sanguineo: ");
//                                            LocalDate fechaNac = LocalDate.parse(JOptionPane.showInputDialog("Ingrese la fecha de nacimiento del Bombero (AAAA-MM-DD):"));
//                                            String celular = JOptionPane.showInputDialog("Ingrese el número de celular del Bombero:");
//
//                                            Bombero bom1 = new Bombero(dni, nombreApellido, grupoSanguineo, fechaNac, celular, idBrigada, true);
//                                            bom.guardarBombero(bom1);
//
//                                        }
//                                    } else {
//                                        JOptionPane.showMessageDialog(null, "Brigada Completa. No se puede agregar más bomberos.");
//                                    }
//                                } else {
//                                    JOptionPane.showMessageDialog(null, "No se pudo obtener la brigada. Asegúrate de que la brigada seleccionada sea válida.");
//                                }
//
//                                break;

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
                                int idCuartelAModificar = cua1.mostrarOpcionesYObtenerSeleccion();
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
                                                    cua1.modificarNombre(idCuartelAModificar);
                                                    break;
                                                case 2:
                                                    cua1.modificarDireccion(idCuartelAModificar);
                                                    break;
                                                case 3:
                                                    cua1.modificarCoordX(idCuartelAModificar);
                                                    break;
                                                case 4:
                                                    cua1.modificarCoordY(idCuartelAModificar);
                                                    break;
                                                case 5:
                                                    cua1.modificarTelefono(idCuartelAModificar);
                                                    break;
                                                case 6:
                                                    cua1.modificarCorreo(idCuartelAModificar);
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

                                int idBrigadaAModificar = brig.mostrarOpciones();
                                Brigada brigadaAModificar = brig.buscarBrigadaPorId(idBrigadaAModificar);

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
                                                    brig.modificarNombreBrigada(idBrigadaAModificar);

                                                    break;
                                                case 2:
                                                    String especialidad = brig.elegirEspecialidad();
                                                    brig.modificarEspecialidad(idBrigadaAModificar, especialidad);

                                                    break;
                                                case 3:
                                                    boolean nuevoEstado = brig.obtenerEstado();

                                                    brig.modificarEstado(idBrigadaAModificar, nuevoEstado);

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

                                int idBomberoAModificar = bom.mostrarOpcionesBomberos();
                                Bombero bomberoAModificar = bom.buscarBomberoPorId(idBomberoAModificar);
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
                                                    bom.modificarNombreBombero(idBomberoAModificar);
                                                    break;
                                                case 2:
                                                    bom.modificarGrupoSanguineoBombero(idBomberoAModificar);
                                                    break;
                                                case 3:
                                                    bom.modificarFechaNacimientoBombero(idBomberoAModificar);
                                                    break;
                                                case 4:
                                                    bom.modificarNumeroCelularBombero(idBomberoAModificar);
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
//                            //--------------------Eliminar Cuartel-----------------------
//                            case 1: // ELIMINAR CUARTEL
//                                int idCuartelAEliminar = cua1.mostrarCuartelesAEliminar();
//                                List<Integer> idsBrigadas = brig.obtenerIdsBrigadasPorIdCuartel(idCuartelAEliminar);
//                                bom.cambiarEstadoBomberosPorBrigadas(idsBrigadas);
//                                brig.cambiarEstadoBrigadas(idsBrigadas);
//                                cua1.cambiarEstadoCuartel(idCuartelAEliminar);
//                                break;

//                            //-----------------Eliminar Brigada---------------------
//                            case 2: // ELIMINAR BRIGADA
//                                int idBrigadaAEliminar = brig.mostrarBrigadasAEliminar();
//                                List<Integer> idsBomberosAEliminar = bom.obtenerBomberosPorBrigada(idBrigadaAEliminar);
//                                bom.cambiarEstadoBomberosPorBrigada(idBrigadaAEliminar);
//                                brig.cambiarEstadoBrigada(idBrigadaAEliminar);
//                                break;

//                            //---------------ELIMINAR BOMBERO------------------------    
//                            case 3: // ELIMINAR BOMBERO
//                                int idBomberoAEliminar = bom.mostrarBomberosAEliminar();
//                                if (idBomberoAEliminar != -1) {
//                                    bom.cambiarEstadoBombero(idBomberoAEliminar);
//                                }
//                                break;
//
//                            case 4:
//                                // Volver al menú principal
//                                break;
//
//                            default:
//                                JOptionPane.showMessageDialog(null, "Opción no válida");
//                                break;
//                        }
//                    }
//
//                    break;

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
//                            //--------------------Agregar Siniestro-----------------------
//                            case 1:
//                                JOptionPane.showMessageDialog(null, "Selecciona a qué brigada vas a cargar este siniestro");
//                                int idBrigadaElegido = brig.brigadasLibres();
//                                brig.brigadaOcupada(idBrigadaElegido);
//                                String tipo = JOptionPane.showInputDialog("Ingrese el tipo de siniestro:");
//                                String fechaHoraSiniestroI = JOptionPane.showInputDialog("Ingrese la fecha y hora del siniestro (dd/MM/yyyy HH:mm):");
//
//                                try {
//                                    LocalDateTime fechaHoraSiniestro = sin.convertirAFechaHora(fechaHoraSiniestroI);
//
//                                    int coordx;
//                                    while (true) {
//                                        String coordXInput = JOptionPane.showInputDialog("Ingrese la coordenada x:");
//                                        if (coordXInput.isEmpty()) {
//                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico para la coordenada x.");
//                                        } else {
//                                            try {
//                                                coordx = Integer.parseInt(coordXInput);
//                                                break; // Salir del bucle si la conversión fue exitosa
//                                            } catch (NumberFormatException e) {
//                                                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para la coordenada x.");
//                                            }
//                                        }
//                                    }
//
//                                    int coordy;
//                                    while (true) {
//                                        String coordYInput = JOptionPane.showInputDialog("Ingrese la coordenada y:");
//                                        if (coordYInput.isEmpty()) {
//                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico para la coordenada y.");
//                                        } else {
//                                            try {
//                                                coordy = Integer.parseInt(coordYInput);
//                                                break; // Salir del bucle si la conversión fue exitosa
//                                            } catch (NumberFormatException e) {
//                                                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para la coordenada y.");
//                                            }
//                                        }
//                                    }
//
//                                    String detalles = JOptionPane.showInputDialog("Ingrese los detalles del siniestro:");
//
//                                    int puntuacion;
//                                    while (true) {
//                                        String puntuacionInput = JOptionPane.showInputDialog("Ingrese la puntuación si finalizo siniestro o un cero si lo carga por primera vez:");
//                                        if (puntuacionInput.isEmpty()) {
//                                            JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico para la puntuación.");
//                                        } else {
//                                            try {
//                                                puntuacion = Integer.parseInt(puntuacionInput);
//                                                break; // Salir del bucle si la conversión fue exitosa
//                                            } catch (NumberFormatException e) {
//                                                JOptionPane.showMessageDialog(null, "Por favor, ingrese un valor numérico válido para la puntuación.");
//                                            }
//                                        }
//                                    }
//
//                                    try {
//                                        String fechaHoraResolI = JOptionPane.showInputDialog("Ingrese la fecha de resolución en caso de tener o deje el campo en blanco:");
//                                        LocalDateTime fechaHoraResol = (fechaHoraResolI.isEmpty()) ? null : sin.convertirAFechaHora(fechaHoraResolI);
//
//                                        sin.insertarSiniestro(idBrigadaElegido, tipo, fechaHoraSiniestro, coordx, coordy, detalles, fechaHoraResol, puntuacion);
//
//                                        JOptionPane.showMessageDialog(null, "Siniestro registrado con éxito.");
//                                    } catch (SQLException | ParseException e) {
//                                        e.printStackTrace();
//                                        JOptionPane.showMessageDialog(null, "Error al insertar el siniestro en la base de datos.");
//                                    }
//
//                                } catch (ParseException e) {
//                                    e.printStackTrace();
//                                    JOptionPane.showMessageDialog(null, "Error al convertir la fecha y hora.");
//                                }
//                                break;

                            //-----------------Modificar Siniestro---------------------
                            case 2:
                                int idSiniestroAModificar = sin.mostrarOpcionesSiniestros();

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
                                                    sin.modificarTipoSiniestro(idSiniestroAModificar);
                                                    break;
                                                case 2:
                                                    sin.modificarFechaSiniestro(idSiniestroAModificar);
                                                    break;
                                                case 3:
                                                    sin.modificarCoordenadaX(idSiniestroAModificar);
                                                    break;
                                                case 4:
                                                    sin.modificarCoordenadaY(idSiniestroAModificar);
                                                    break;
                                                case 5:
                                                    sin.modificarDetallesSiniestro(idSiniestroAModificar);
                                                    break;
                                                case 6:
                                                    sin.modificarFechaResolucion(idSiniestroAModificar);
                                                    break;
                                                case 7:
                                                    sin.modificarPuntuacion(idSiniestroAModificar);
                                                    break;
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
                                int idSiniestroSeleccionado = sin.mostrarSiniestros();
                                int idBrigadaAsociada = sin.obtenerIdBrigadaPorIdSiniestro(idSiniestroSeleccionado);
                                brig.marcarBrigadaComoLibre(idBrigadaAsociada);
                                sin.eliminarSiniestro(idSiniestroSeleccionado);

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

package Ingas;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Configuracion {
    public static Scanner leer = new Scanner(System.in);
    private static String formatoFechayHora;
    private static String idioma;

    public Configuracion(String formatoFechaHora, String idioma) {
        Configuracion.formatoFechayHora = formatoFechaHora;
        Configuracion.idioma = idioma;
    }

    public String getFormatoFechaHora() {
        return formatoFechayHora;
    }

    public void setFormatoFechaHora(String formatoFechaHora) {
        this.formatoFechayHora = formatoFechaHora;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String fechaHora(LocalDateTime fechaHoraActual) {
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(formatoFechayHora);
        String fechaHoraFormateada = fechaHoraActual.format(formatoFechaHora);
        return fechaHoraFormateada;
    }

    public static LocalDateTime horaFecha(String fechaYHora){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(fechaYHora, formatter);
        return dateTime;
    }

    public void calendarioMostrarEvento(String titulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinal) {
        if (idioma == "en") {
            System.out.println("Event [title: " + titulo + ", Start date and time: " + fechaHoraInicio
                    + ", End date and time: " + fechaHoraFinal + "]");
        } else {
            System.out.println("Evento [titulo: " + titulo + ", Fecha y Hora de inicio: " + fechaHoraInicio
                    + ", Fecha y hora de Fin: " + fechaHoraFinal + "]");
        }
    }

    public void calendarioMostrarRecordatorios(String titulo, String mensaje, LocalDateTime fechaHora) {
        if (idioma == "en") {
            System.out.println("Reminder [title: " + titulo + ", message: " + mensaje + ", Date and Time: " + fechaHora + "]");
        } else {
            System.out.println("Recordatorio [titulo: " + titulo + ", mensaje: " + mensaje + ", Fecha y Hora: " + fechaHora + "]");
        }
    }

    public static void imprimirMostrarContactos(String nombre, String apellido, String telefono, String correo) {
        if (idioma == "en") {
            System.out.println("Contact [name: " + nombre + ", last name: " + apellido + ", phone: " + telefono
                    + ", email: " + correo + "]");
        } else {
            System.out.println("Contacto [nombre: " + nombre + ", apellido: " + apellido + ", telefono: " + telefono
                    + ", correo: " + correo + "]");
        }
    }

    public void agendaMostrarGrupo(String nombre) {
        if (idioma == "en") {
            System.out.println("Group [name: " + nombre + "]");
        } else {
            System.out.println("Grupo [nombre: " + nombre + "]");
        }
    }

    public void listaNulo() {
        if (idioma == "en") {
            System.out.println("The list not exist");
        } else {
            System.out.println("La lista no existe");
        }
    }

    public void menu() {
        Boolean seguir = true;
        int opcion = 0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.println("Welcome to the Agenda menu");
                System.out.print(
                        "Type the option you want\n1) Contacts Options\n2) Group Options\n3) Calendar Options\n4) Settings\n5) Close Program \nChoice: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Entering the Contacts menu");
                        leer.nextLine();
                        menuContactos(opcion);
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Entering the Groups menu");
                        leer.nextLine();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Entering the Calendar menu");
                        leer.nextLine();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Entering the Settings menu");
                        leer.nextLine();
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Closing...");
                        leer.nextLine();
                        seguir = false;
                        break;

                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.println("Bienvenido al menu de Agenda");
                System.out.print(
                        "Escribe la opcion que desea\n1) Opciones de Contactos\n2) Opciones de Grupo\n3) Opciones de Calendario\n4) Configuracion\n5) Cerrar Programa \nEleccion: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingresando al menu de Contactos");
                        leer.nextLine();
                        menuContactos(opcion);
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingresando al menu de Grupos");
                        leer.nextLine();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingresando al menu de Calendario");
                        leer.nextLine();
                        menuCalendario(opcion);
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingresando al menu de Configuracion");
                        leer.nextLine();
                        menuConfiguracion(opcion);
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Cerrando...");
                        leer.nextLine();
                        seguir = false;
                        break;

                    default:
                        System.out.println("Opcion no valida");
                        leer.nextLine();
                        break;
                }
            }
        }
    }

    public static void menuContactos(int opcion) {
        Boolean seguir = true;
        String nombre, apellido, correo, telefono;
        Contacto conta;
        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.println("Type the option you want\n1) Enter Contact\n2) Search Contact\n3) Show Contact\n4) Remove Contactor\n5) Return to \nElection: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Creating contact\nEnter the name: ");
                        nombre = leer.nextLine();
                        System.out.print("Enter last name: ");
                        apellido = leer.nextLine();
                        System.out.print("Enter your email address: ");
                        correo = leer.nextLine();
                        System.out.print("Enter the phone number: ");
                        telefono = leer.nextLine();
                        Agenda.insertarContacto(nombre, apellido, correo, telefono);
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Seeking contact\nEnter the name: ");
                        nombre = leer.nextLine();
                        System.out.print("Enter last name: ");
                        apellido = leer.nextLine();
                        conta = Agenda.buscarContacto(nombre, apellido);
                        imprimirMostrarContactos(conta.getNombre(), conta.getApellido(), conta.getCorreo(),
                                conta.getTelefono());
                        leer.nextLine();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Contact list");
                        Agenda.mostrarContacto();
                        leer.nextLine();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Deleting contacts\nEnter the name: ");
                        nombre = leer.nextLine();
                        System.out.print("Enter last name: ");
                        apellido = leer.nextLine();
                        Agenda.eliminarContacto(nombre, apellido);
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Returning...");
                        seguir = false;
                        leer.nextLine();
                        break;

                    default:
                        System.out.println("Invalid option");
                        break;
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.println(
                        "Escribe la opcion que desea\n1) Ingresar Contacto\n2) Buscar Contacto\n3) Mostrar Contacto\n4) Eliminar Contactor\n5) Regresar \nEleccion: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Creando contacto\nIngresa el nombre: ");
                        nombre = leer.nextLine();
                        System.out.print("Ingresar el apellido: ");
                        apellido = leer.nextLine();
                        System.out.print("Ingresa el correo: ");
                        correo = leer.nextLine();
                        System.out.print("Ingresa el telefono: ");
                        telefono = leer.nextLine();
                        Agenda.insertarContacto(nombre, apellido, correo, telefono);
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Buscando contacto\nIngresa el nombre: ");
                        nombre = leer.nextLine();
                        System.out.print("Ingresar el apellido: ");
                        apellido = leer.nextLine();
                        conta = Agenda.buscarContacto(nombre, apellido);
                        imprimirMostrarContactos(conta.getNombre(), conta.getApellido(), conta.getCorreo(),
                                conta.getTelefono());
                        leer.nextLine();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Lista de contactos");
                        Agenda.mostrarContacto();
                        leer.nextLine();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Eliminando contactos\nIngresa el nombre: ");
                        nombre = leer.nextLine();
                        System.out.print("Ingresar el apellido: ");
                        apellido = leer.nextLine();
                        Agenda.eliminarContacto(nombre, apellido);
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Regresando...");
                        seguir = false;
                        leer.nextLine();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
        }
    }

    public static void gestorContactos(int opcion){
        Boolean seguir = true;
        String nombreG ,nombreC ,apellidoC ;
        
        while (seguir) {
            if (idioma == "en"){
                System.out.println("Gringo");
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print("Escribe la opcion que desea\n1) Mostrar Contactos\n2) Agregar Contacto a Grupo\n3) Sacar Contacto de Grupo\n4) Regresar \nEleccion: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Lista de Contactos");
                        Agenda.mostrarContacto();
                        leer.nextLine();
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Ingresando Contacto a Grupo\nIngresa el nombre del Grupo: ");
                        nombreG = leer.nextLine();
                        System.out.println("Ingresa el nombre del Contacto: ");
                        nombreC = leer.nextLine();
                        System.out.println("Ingresa el apellido del Contacto: ");
                        apellidoC = leer.nextLine();
                        Agenda.insertarAGrupo(nombreG, nombreC, apellidoC);
                        leer.nextLine();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Sacando Contacto de Grupo\nIngresa el nombre del Grupo: ");
                        nombreG = leer.nextLine();
                        System.out.println("Ingresa el nombre del Contacto: ");
                        nombreC = leer.nextLine();
                        System.out.println("Ingresa el apellido del Contacto: ");
                        apellidoC = leer.nextLine();
                        Agenda.eliminarDeGrupo(nombreG, nombreC, apellidoC);
                        leer.nextLine();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Regresando...");
                        seguir = false;
                        leer.nextLine();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
        }
    }

    public static void menuCalendario(int opcion){
        Boolean seguir = true;
        String titulo, mensaje;
        LocalDateTime fechaInicio,fechaFin,fechaReco;
        while (seguir) {
            if (idioma == "en"){
                System.out.println("Gringo");
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print("Escribe la opcion que deseas\n1) Crear Evento\n2) Eliminar Evento\n3) Crear Recordatorio\n4) Eliminar recordatorio\n5) Mostrar\n6) Regresar\nEleccion: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Creando Evento\nIngresa el Titulo del evento: ");
                        titulo = leer.nextLine();
                        System.out.print("Ingrese la fecha de inicio en formato " + formatoFechayHora + ": ");
                        fechaInicio = horaFecha(leer.nextLine());
                        System.out.print("Ingrese la fecha de Fin en formato " + formatoFechayHora + ": ");
                        fechaFin = horaFecha(leer.nextLine());
                        Agenda.calendario.insertarEventos(titulo, fechaInicio, fechaFin);
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Eliminando Evento\nIngrese el Titulo del Evento: ");
                        Agenda.calendario.eliminarEvento(leer.nextLine());
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Creando Recordatorio\nIngrese el Titulo del Recordatorio: ");
                        titulo = leer.nextLine();
                        System.out.println("Ingrese el Mensaje del Recordatorio: ");
                        mensaje = leer.nextLine();
                        System.out.println("Ingrese la fecha del Recordatorio en formato " + formatoFechayHora + ": ");
                        fechaReco = horaFecha(leer.nextLine());
                        Agenda.calendario.insertarRecordatorios(titulo, mensaje, fechaReco);
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Eliminando Recordatorio\nIngrese el Titulo del Recordatorio: ");
                        Agenda.calendario.eliminarRecordatorios(leer.nextLine());
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Lista de Eventos");
                        Agenda.calendario.mostrarEventos();
                        System.out.println("===================\nLista de Recordatorios");
                        Agenda.calendario.mostrarRecordatorios();
                        break;
                    case 6:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Regresando...");
                        seguir = false;
                        leer.nextLine();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
        }
    }

    public static void menuConfiguracion(int opcion){
        Boolean seguir = true;
        int id = 0;
        while (seguir) {
            if (idioma == "en"){
                System.out.println("Gringo");
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print("Escribe la opcion que desea\n1) Elegir Idioma\n2) Elegir Formato de Fecha y Hora\n3) Regresar \nEleccion: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.println("1) Español\n2) Ingles");
                        id = Integer.parseInt(leer.nextLine());
                        if (id == 1) {
                            idioma = "es";
                        } else if (id == 2) {
                            idioma = "en";
                        } else {
                            System.out.println("Opcion no valida");
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Regresando...");
                        seguir = false;
                        leer.nextLine();
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
        }
    }
}

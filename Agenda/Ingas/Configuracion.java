package Ingas;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Configuracion {
    public static Scanner leer = new Scanner (System.in);
    private String formatoFechayHora;
    private static String idioma;

    public Configuracion(String formatoFechaHora, String idioma){
        this.formatoFechayHora = formatoFechaHora;
        this.idioma = idioma;
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

    public void calendarioMostrarEvento(String titulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinal) {
        if (idioma == "en") {
            System.out.println("Event [title: " + titulo + ", Start date and time: " + fechaHoraInicio + ", End date and time: " + fechaHoraFinal + "]");
        } else {
            System.out.println("Evento [titulo: " + titulo + ", Fecha y Hora de inicio: " + fechaHoraInicio + ", Fecha y hora de Fin: " + fechaHoraFinal + "]");
        }
    }

    public void calendarioMostrarRecordatorios(String mensaje, LocalDateTime fechaHora) {
        if (idioma == "en") {
            System.out.println("Reminder [message: " + mensaje + ", Date and Time: " + fechaHora + "]");
        } else {
            System.out.println("Recordatorio [mensaje: " + mensaje + ", Fecha y Hora: " + fechaHora + "]");
        }
    }

    public static void imprimirMostrarContactos(String nombre, String apellido, String telefono, String correo) {
        if (idioma == "en") {
            System.out.println("Contact [name: " + nombre + ", last name: " + apellido + ", phone: " + telefono + ", email: " + correo + "]");
        } else {
            System.out.println("Contacto [nombre: " + nombre + ", apellido: " + apellido + ", telefono: " + telefono + ", correo: " + correo + "]");
        }
    }



    public void agendaMostrarGrupo(String nombre) {
        if (idioma == "en") {
            System.out.println("Group [name: " + nombre + "]");
        } else {
            System.out.println("Grupo [nombre: " + nombre + "]");
        }
    }

    public void listaNulo(){
        if (idioma == "en"){
            System.out.println("The list not exist");
        } else {
            System.out.println("La lista no existe");
        }
    }

    public void menu(){
        Boolean seguir = true;
        int opcion = 0;
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        if (idioma == "en"){

        } else {
            while (seguir) {
                System.out.print("\033[H\033[2J");
                System.out.println("Bienvenido al menu de Agenda");
                System.out.print("Escribe la opcion que desea\n1) Opciones de Contactos\n2) Opciones de Grupo\n3) Opciones de Calendario\n4) Configuracion\n5) Cerrar Programa \nEleccion: ");
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
                        menuGrupo(opcion);
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J"); 
                        System.out.println("Ingresando al menu de Calendario");
                        leer.nextLine();
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J"); 
                        System.out.println("Ingresando al menu de Configuracion");
                        leer.nextLine();
                        break;
                    case 5:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Cerrando..."); 
                        leer.nextLine();
                        seguir = false;
                        break;
                
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
            }
        }
    }

    public static void menuContactos(int opcion){
        Boolean seguir = true;
        String nombre, apellido, correo, telefono;
        Contacto conta;
        
        if (idioma == "en") {
            
        } else {
            while (seguir) {
                System.out.print("\033[H\033[2J");
                System.out.println("Escribe la opcion que desea\n1) Ingresar Contacto\n2) Buscar Contacto\n3) Mostrar Contacto\n4) Eliminar Contactor\n5) Regresar \nEleccion: ");
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
                        if (conta != null){
                            imprimirMostrarContactos(conta.getNombre(),conta.getApellido(),conta.getCorreo(),conta.getTelefono());
                        }
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
                        System.out.println("Eliminando...");
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
            System.out.flush(); 
        }
    }

    public static void menuGrupo(int opcion){
        Boolean seguir = true;
        String nombreG;
        if (idioma == "en"){

        } else {
            while (seguir) {
                System.out.print("\033[H\033[2J");
                System.out.println("Escribe la opcion que desea\n1) Crear Grupo\n2) Mostrar Grupos\n3) Eliminar Grupo\n4) Gestor de Contactos\n5) Regresar \nEleccion: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Creando Grupo\nIngresa nombre: ");
                        Agenda.agregarGrupos(leer.nextLine());
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Lista de Grupos");
                        Agenda.mostrarGrupos();
                        leer.nextLine();
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.print("Eliminando Grupos\nIngrese el nombre: ");
                        Agenda.eliminarGrupos(leer.nextLine());
                        break;
                    case 4:
                        System.out.print("\033[H\033[2J");
                        System.out.println("Ingresando al gestor de Contactos...");
                        leer.nextLine();
                        gestorContactos(opcion);
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
        String nombreG = "",nombreC = "",apellidoC = "";
        if (idioma == "en"){

        } else {
            while (seguir) {
                System.out.print("\033[H\033[2J");
                System.out.println("Escribe la opcion que desea\n1) Agregar Contacto a Grupo\n2) Sacar Contacto de Grupo\n3) Regresar \nEleccion: ");
                opcion = Integer.parseInt(leer.nextLine());
                switch (opcion) {
                    case 1:
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
                    case 2:
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

    public static void menuConfiguracion(int opcion){
        Boolean seguir = true;
        if (idioma == "en"){

        } else {
            System.out.print("\033[H\033[2J");
            System.out.println("Escribe la opcion que desea\n1) Elegir Idioma\n2) Elegir Formato de Fecha y Hora\n3) Regresar \nEleccion: ");
            opcion = Integer.parseInt(leer.nextLine());
            switch (opcion) {
                case 1:
                    
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
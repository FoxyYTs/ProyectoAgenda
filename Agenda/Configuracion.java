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
        Configuracion.formatoFechayHora = formatoFechaHora;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        Configuracion.idioma = idioma;
    }

    public String fechaHora(LocalDateTime fechaHoraActual) {
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(formatoFechayHora);
        String fechaHoraFormateada = fechaHoraActual.format(formatoFechaHora);
        return fechaHoraFormateada;
    }

    public static LocalDateTime horaFecha(String fechaYHora) {
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(formatoFechayHora);
        LocalDateTime fechaHoraFormateada = LocalDateTime.parse(fechaYHora, formatoFechaHora);
        return fechaHoraFormateada;
    }

    public static String formatos(String id) {
        if (idioma.equals("en")) {
            if (id.equals("d/M/y H:m")) {
                return "day/month/year 24H:minute";
            } else if (id.equals("M/d/y H:m")) {
                return "month/day/year 24H:minute";
            } else if (id.equals("d/M/y h:m a")) {
                return "day/month/year 12H:minute a.m./p.m.";
            } else if (id.equals("M/d/y h:m a")) {
                return "month/day/year 12H:minute a.m./p.m.";
            }
        } else {
            if (id.equals("d/M/y H:m")) {
                return "dia/mes/año 24H:minuto";
            } else if (id.equals("M/d/y H:m")) {
                return "mes/dia/año 24H:minuto";
            } else if (id.equals("d/M/y h:m a")) {
                return "dia/mes/año 12H:minuto a.m./p.m.";
            } else if (id.equals("M/d/y h:m a")) {
                return "mes/dia/año 12H:minuto a.m./p.m.";
            }
        }
        return "";
    }

    public void calendarioMostrarEvento(String titulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinal) {
        if (idioma == "en") {
            System.out.println("Event [title: " + titulo + ", Start date and time: " + fechaHora(fechaHoraInicio)
                    + ", End date and time: " + fechaHora(fechaHoraFinal) + "]");
        } else {
            System.out.println("Evento [titulo: " + titulo + ", Fecha y Hora de inicio: " + fechaHora(fechaHoraInicio)
                    + ", Fecha y hora de Fin: " + fechaHora(fechaHoraFinal) + "]");
        }
    }

    public void calendarioMostrarRecordatorios(String titulo, String mensaje, LocalDateTime fechaHora) {
        if (idioma == "en") {
            System.out.println("Reminder [title: " + titulo + ", message: " + mensaje + ", Date and Time: "
                    + fechaHora(fechaHora) + "]");
        } else {
            System.out.println("Recordatorio [titulo: " + titulo + ", mensaje: " + mensaje + ", Fecha y Hora: "
                    + fechaHora(fechaHora) + "]");
        }
    }

    public static void imprimirMostrarContactos(String nombre, String apellido, String correo, String telefono) {
        if (idioma == "en") {
            System.out.println("Contact [name: " + nombre + ", last name: " + apellido + ", email: " + correo
                    + ", phone: " + telefono + "]");
        } else {
            System.out.println("Contacto [nombre: " + nombre + ", apellido: " + apellido + ", correo: " + correo
                    + ", telefono: " + telefono + "]");
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

    public void Nulo() {
        if (idioma == "en") {
            System.out.println("Not Exist");
        } else {
            System.out.println("No Existe");
        }
    }

    public void menu() {
        if (idioma == "en") {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Starting Program...");
            leer.nextLine();
        } else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Iniciando Programa...");
            leer.nextLine();
        }
        Boolean seguir = true;
        String opcion;
        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print(
                        "Welcome to the Agenda menu\n========================================\nType the option you want\n1) Contacts Options\n2) Group Options\n3) Calendar Options\n4) Settings\n5) Close Program \nChoice: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Entering the Contacts menu");
                    leer.nextLine();
                    menuContactos();
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Entering the Groups menu");
                    leer.nextLine();
                    menuGrupo();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Entering the Calendar menu");
                    leer.nextLine();
                    menuCalendario();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Entering the Settings menu");
                    leer.nextLine();
                    menuConfiguracion();
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Closing...");
                    System.out.println("\nCreated by\nJose Manuel and Jose Andres");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Invalid option");
                    leer.nextLine();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.print(
                        "Bienvenido al menu de Agenda\n========================================\nEscribe la opcion que desea\n1) Opciones de Contactos\n2) Opciones de Grupo\n3) Opciones de Calendario\n4) Configuracion\n5) Cerrar Programa \nEleccion: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Ingresando al menu de Contactos");
                    leer.nextLine();
                    menuContactos();
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Ingresando al menu de Grupos");
                    leer.nextLine();
                    menuGrupo();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Ingresando al menu de Calendario");
                    leer.nextLine();
                    menuCalendario();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Ingresando al menu de Configuracion");
                    leer.nextLine();
                    menuConfiguracion();
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Cerrando...");
                    System.out.println("\nCreado por\nJose Manuel y Jose Andres");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Opcion no valida");
                    leer.nextLine();
                }
            }
        }
    }

    public static void menuContactos() {
        String opcion;
        Boolean seguir = true;
        String nombre, apellido, correo, telefono;
        Contacto conta;
        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Type the option you want\n1) Enter Contact\n2) Search Contact\n3) Show Contact\n4) Remove Contactor\n5) Return to \nElection: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
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
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Seeking contact\nEnter the name: ");
                    nombre = leer.nextLine();
                    System.out.print("Enter last name: ");
                    apellido = leer.nextLine();
                    conta = Agenda.buscarContacto(nombre, apellido);
                    imprimirMostrarContactos(conta.getNombre(), conta.getApellido(), conta.getCorreo(),
                            conta.getTelefono());
                    leer.nextLine();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Contact list");
                    Agenda.mostrarContacto();
                    leer.nextLine();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Deleting contacts\nEnter the name: ");
                    nombre = leer.nextLine();
                    System.out.print("Enter last name: ");
                    apellido = leer.nextLine();
                    Agenda.eliminarContacto(nombre, apellido);
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Returning...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Invalid option");
                    leer.nextLine();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print("Escribe la opcion que desea\n1) Ingresar Contacto\n2) Buscar Contacto\n3) Mostrar Contacto\n4) Eliminar Contactor\n5) Regresar \nEleccion: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
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
                    /*
                     * for (int i = 1; i <= 5; i++) {
                     * Agenda.insertarContacto("nombre" + i, "apellido" + i, "correo" + i,
                     * "telefono" + i);
                     * }
                     */
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Buscando contacto\nIngresa el nombre: ");
                    nombre = leer.nextLine();
                    System.out.print("Ingresar el apellido: ");
                    apellido = leer.nextLine();
                    conta = Agenda.buscarContacto(nombre, apellido);
                    imprimirMostrarContactos(conta.getNombre(), conta.getApellido(), conta.getCorreo(),conta.getTelefono());
                    leer.nextLine();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Lista de contactos");
                    Agenda.mostrarContacto();
                    leer.nextLine();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Eliminando contactos\nIngresa el nombre: ");
                    nombre = leer.nextLine();
                    System.out.print("Ingresar el apellido: ");
                    apellido = leer.nextLine();
                    Agenda.eliminarContacto(nombre, apellido);
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Regresando...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Opcion no valida");
                    leer.nextLine();
                }
            }
        }
    }

    public static void menuGrupo() {
        String opcion;
        Boolean seguir = true;
        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Type the option you want\n1) Create Group\n2) Show Groups\n3) Delete Group\n4) Contact Manager\n5) Return to \nChoice: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Creating Group\nEnter name: ");
                    Agenda.agregarGrupos(leer.nextLine());
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Group List");
                    Agenda.mostrarGrupos();
                    leer.nextLine();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Deleting Groups\nEnter the name: ");
                    Agenda.eliminarGrupos(leer.nextLine());
                    leer.nextLine();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Entering the Contact Manager...");
                    leer.nextLine();
                    gestorContactos();
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Returning...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Invalid option");
                    leer.nextLine();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Escribe la opcion que desea\n1) Crear Grupo\n2) Mostrar Grupos\n3) Eliminar Grupo\n4) Gestor de Contactos\n5) Regresar \nEleccion: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Creando Grupo\nIngresa nombre: ");
                    Agenda.agregarGrupos(leer.nextLine());
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Lista de Grupos");
                    Agenda.mostrarGrupos();
                    leer.nextLine();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Eliminando Grupos\nIngrese el nombre: ");
                    Agenda.eliminarGrupos(leer.nextLine());
                    leer.nextLine();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Ingresando al gestor de Contactos...");
                    leer.nextLine();
                    gestorContactos();
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Regresando...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Opcion no valida");
                    leer.nextLine();
                }
            }
        }
    }

    public static void gestorContactos() {
        String opcion;
        Boolean seguir = true;
        String nombreG, nombreC, apellidoC;

        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Type the option you want\n1) Show Contacts\n2) Add Contact to Group\n3) Remove Group Contact\n4) Return to \nChoice: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Contact List");
                    Agenda.mostrarContacto();
                    leer.nextLine();
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Enter Group Contact\nEnter the Group name: ");
                    nombreG = leer.nextLine();
                    System.out.print("Enter the name of the Contact: ");
                    nombreC = leer.nextLine();
                    System.out.print("Enter the Contact's last name: ");
                    apellidoC = leer.nextLine();
                    Agenda.insertarAGrupo(nombreG, nombreC, apellidoC);
                    leer.nextLine();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Removing Group Contact\nEnter the Group name: ");
                    nombreG = leer.nextLine();
                    System.out.print("Enter the name of the Contact: ");
                    nombreC = leer.nextLine();
                    System.out.print("Enter the Contact's last name: ");
                    apellidoC = leer.nextLine();
                    Agenda.eliminarDeGrupo(nombreG, nombreC, apellidoC);
                    leer.nextLine();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Returning...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Invalid option");
                    leer.nextLine();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Escribe la opcion que desea\n1) Mostrar Contactos\n2) Agregar Contacto a Grupo\n3) Sacar Contacto de Grupo\n4) Regresar \nEleccion: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Lista de Contactos");
                    Agenda.mostrarContacto();
                    leer.nextLine();
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Ingresando Contacto a Grupo\nIngresa el nombre del Grupo: ");
                    nombreG = leer.nextLine();
                    System.out.print("Ingresa el nombre del Contacto: ");
                    nombreC = leer.nextLine();
                    System.out.print("Ingresa el apellido del Contacto: ");
                    apellidoC = leer.nextLine();
                    Agenda.insertarAGrupo(nombreG, nombreC, apellidoC);
                    leer.nextLine();
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Sacando Contacto de Grupo\nIngresa el nombre del Grupo: ");
                    nombreG = leer.nextLine();
                    System.out.print("Ingresa el nombre del Contacto: ");
                    nombreC = leer.nextLine();
                    System.out.print("Ingresa el apellido del Contacto: ");
                    apellidoC = leer.nextLine();
                    Agenda.eliminarDeGrupo(nombreG, nombreC, apellidoC);
                    leer.nextLine();
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Regresando...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Opcion no valida");
                    leer.nextLine();
                }
            }
        }
    }

    public static void menuCalendario() {
        String opcion;
        Boolean seguir = true;
        String titulo, mensaje;
        LocalDateTime fechaInicio, fechaFin, fechaReco;
        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Type the option you want\n1) Create Event\n2) Delete Event\n3) Create Reminder\n4) Delete reminder\n5) Show\n6) Return to\nChoice: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Creating Event\nEnter the Title of the event: ");
                    titulo = leer.nextLine();
                    System.out.print(
                            "Enter the start date in the following format " + formatos(formatoFechayHora) + ": ");
                    fechaInicio = horaFecha(leer.nextLine());
                    System.out.print("Enter the End date in the format" + formatos(formatoFechayHora) + ": ");
                    fechaFin = horaFecha(leer.nextLine());
                    Agenda.calendario.insertarEventos(titulo, fechaInicio, fechaFin);
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Deleting Event\nEnter the Event Title: ");
                    Agenda.calendario.eliminarEvento(leer.nextLine());
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Creating Reminder\nEnter the Reminder Title: ");
                    titulo = leer.nextLine();
                    System.out.print("Enter Reminder Message: ");
                    mensaje = leer.nextLine();
                    System.out.print("Enter the date of the Reminder in the following format '"
                            + formatos(formatoFechayHora) + "' : ");
                    fechaReco = horaFecha(leer.nextLine());
                    Agenda.calendario.insertarRecordatorios(titulo, mensaje, fechaReco);
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Removing Reminder\nEnter the Reminder Title: ");
                    Agenda.calendario.eliminarRecordatorios(leer.nextLine());
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Events list");
                    Agenda.calendario.mostrarEventos();
                    System.out.println("===================\nReminder List");
                    Agenda.calendario.mostrarRecordatorios();
                    leer.nextLine();
                } else if (opcion.equals("6")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Returning...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Invalid option");
                    leer.nextLine();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Escribe la opcion que deseas\n1) Crear Evento\n2) Eliminar Evento\n3) Crear Recordatorio\n4) Eliminar recordatorio\n5) Mostrar\n6) Regresar\nEleccion: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Creando Evento\nIngresa el Titulo del evento: ");
                    titulo = leer.nextLine();
                    System.out.print("Ingrese la fecha de inicio en formato " + formatos(formatoFechayHora) + ": ");
                    fechaInicio = horaFecha(leer.nextLine());
                    System.out.print("Ingrese la fecha de Fin en formato " + formatos(formatoFechayHora) + ": ");
                    fechaFin = horaFecha(leer.nextLine());
                    Agenda.calendario.insertarEventos(titulo, fechaInicio, fechaFin);
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Eliminando Evento\nIngrese el Titulo del Evento: ");
                    Agenda.calendario.eliminarEvento(leer.nextLine());
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Creando Recordatorio\nIngrese el Titulo del Recordatorio: ");
                    titulo = leer.nextLine();
                    System.out.print("Ingrese el Mensaje del Recordatorio: ");
                    mensaje = leer.nextLine();
                    System.out.print(
                            "Ingrese la fecha del Recordatorio en formato '" + formatos(formatoFechayHora) + "' : ");
                    fechaReco = horaFecha(leer.nextLine());
                    Agenda.calendario.insertarRecordatorios(titulo, mensaje, fechaReco);
                } else if (opcion.equals("4")) {
                    System.out.print("\033[H\033[2J");
                    System.out.print("Eliminando Recordatorio\nIngrese el Titulo del Recordatorio: ");
                    Agenda.calendario.eliminarRecordatorios(leer.nextLine());
                } else if (opcion.equals("5")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Lista de Eventos");
                    Agenda.calendario.mostrarEventos();
                    System.out.println("===================\nLista de Recordatorios");
                    Agenda.calendario.mostrarRecordatorios();
                    leer.nextLine();
                } else if (opcion.equals("6")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Regresando...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Opcion no valida");
                    leer.nextLine();
                }
            }
        }
    }

    public static void menuConfiguracion() {
        String opcion;
        Boolean seguir = true;
        int id = 0;
        while (seguir) {
            if (idioma == "en") {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Type the option you want\n1) Choose Language\n2) Choose Date and Time Format\n3) Return to \nChoice: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("In which language do you want\n1) Spanish\n2) English");
                    id = Integer.parseInt(leer.nextLine());
                    if (id == 1) {
                        idioma = "es";
                    } else if (id == 2) {
                        idioma = "en";
                    } else {
                        System.out.println("Invalid option");
                    }
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println(
                            "Which date and time format do you prefer?\n1) dd/mm/yyyy 24H\n2) mm/dd/yyyy 24H\n3) dd/mm/yyyy 12H\n4) mm/dd/yyyy 12H");
                    id = Integer.parseInt(leer.nextLine());
                    if (id == 1) {
                        formatoFechayHora = "d/M/y H:m";
                    } else if (id == 2) {
                        formatoFechayHora = "M/d/y H:m";
                    } else if (id == 3) {
                        formatoFechayHora = "d/M/y h:m a";
                    } else if (id == 4) {
                        formatoFechayHora = "M/d/y h:m a";
                    } else {
                        System.out.println("Invalid option");
                    }

                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Returning...");
                    seguir = false;
                    leer.nextLine();

                } else {
                    System.out.println("Invalid option");
                    leer.nextLine();
                }
            } else {
                System.out.print("\033[H\033[2J");
                System.out.print(
                        "Escribe la opcion que desea\n1) Elegir Idioma\n2) Elegir Formato de Fecha y Hora\n3) Regresar \nEleccion: ");
                opcion = leer.nextLine();
                if (opcion.equals("1")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("En que idioma quieres\n1) Español\n2) Ingles");
                    id = Integer.parseInt(leer.nextLine());
                    if (id == 1) {
                        idioma = "es";
                    } else if (id == 2) {
                        idioma = "en";
                    } else {
                        System.out.println("Opcion no valida");
                    }
                } else if (opcion.equals("2")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println(
                            "Que formato de fecha prefieres\n1) dd/mm/yyyy 24H\n2) mm/dd/yyyy 24H\n3) dd/mm/yyyy 12H\n4) mm/dd/yyyy 12H");
                    id = Integer.parseInt(leer.nextLine());
                    if (id == 1) {
                        formatoFechayHora = "d/M/y H:m";
                    } else if (id == 2) {
                        formatoFechayHora = "M/d/y H:m";
                    } else if (id == 3) {
                        formatoFechayHora = "d/M/y h:m a";
                    } else if (id == 4) {
                        formatoFechayHora = "M/d/y h:m a";
                    } else {
                        System.out.println("Opcion no valida");
                    }
                } else if (opcion.equals("3")) {
                    System.out.print("\033[H\033[2J");
                    System.out.println("Regresando...");
                    seguir = false;
                    leer.nextLine();
                } else {
                    System.out.println("Opcion no valida");
                    leer.nextLine();
                }
            }
        }
    }
}
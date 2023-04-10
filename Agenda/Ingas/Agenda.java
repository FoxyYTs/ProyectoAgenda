package Ingas;

public class Agenda {
    public static Contacto hContacto;
    private static Grupo hGrupo;
    private static String formatoFechaHora = "dd/MM/yyyy", idioma = "es";
    public static Configuracion configuracion = new Configuracion(formatoFechaHora, idioma);
    public static Calendario calendario = new Calendario();

    public Agenda() {
        Agenda.hContacto = null;
    }

    public void menu() {
        configuracion.menu();
    }

    // Funciones Contactos
    public static void insertarContacto(String nombre, String apellido, String correo, String telefono) {
        Contacto nuevo = new Contacto(nombre, apellido, correo, telefono);
        if (hContacto == null) {
            hContacto = nuevo;
        } else {
            Contacto pContacto = hContacto;
            while (pContacto.next != null) {
                pContacto = pContacto.next;
            }
            pContacto.next = nuevo;
        }
    }

    public static void eliminarContacto(String nombre, String apellido) {
        if (hContacto == null) {
            return;
        }
        if (hContacto.getNombre().equals(nombre) && hContacto.getApellido().equals(apellido)) {
            hContacto = hContacto.next;
            return;
        }
        Contacto pContacto = hContacto;
        while (!pContacto.next.getNombre().equals(nombre) && !pContacto.next.getApellido().equals(apellido)
                && pContacto.next != null) {
            pContacto = pContacto.next;
        }
        if (pContacto.next != null) {
            pContacto.next = pContacto.next.next;
        }
    }

    public static void mostrarContacto() {
        if (hContacto == null) {
            System.out.println("No existe");
            return;
        }
        Contacto pContacto = hContacto;
        while (pContacto != null) {
            configuracion.imprimirMostrarContactos(pContacto.getNombre(), pContacto.getApellido(),
                    pContacto.getTelefono(), pContacto.getCorreo());
            pContacto = pContacto.next;
        }
        System.out.println();
    }

    public static Contacto buscarContacto(String nombre, String apellido) {
        if (hContacto == null) {
            System.out.println("No existe");
            return null;
        }
        Contacto pContacto = hContacto;
        while (pContacto != null) {
            if (pContacto.getNombre().equals(nombre) && pContacto.getApellido().equals(apellido)) {
                return pContacto;
            }
            pContacto = pContacto.next;
        }
        return null;
    }

    // Funciones Grupos

    public static void agregarGrupos(String nombre) {
        Grupo nuevo = new Grupo(nombre);
        if (hGrupo == null) {
            hGrupo = nuevo;
        } else {
            Grupo pointerGrupos = hGrupo;
            while (pointerGrupos.next != null) {
                pointerGrupos = pointerGrupos.next;
            }
            pointerGrupos.next = nuevo;
        }
    }

    public static void eliminarGrupos(String nombre) {
        if (hGrupo == null) {
            return;
        }
        if (hGrupo.getNombre().equals(nombre)) {
            hGrupo = hGrupo.next;
            return;
        }
        Grupo pointerGrupos = hGrupo;
        while (!pointerGrupos.next.getNombre().equals(nombre) && pointerGrupos.next != null) {
            pointerGrupos = pointerGrupos.next;
        }
        if (pointerGrupos.next != null) {
            pointerGrupos.next = pointerGrupos.next.next;
        }
    }

    public static void mostrarGrupos() {
        Grupo pointerGrupos = hGrupo;
        while (pointerGrupos != null) {
            configuracion.agendaMostrarGrupo(pointerGrupos.getNombre());
            pointerGrupos = pointerGrupos.next;
        }
        System.out.println();
    }

    public static void insertarAGrupo(String nombreG, String nombreC, String apellido) {
        Grupo pGrupo = hGrupo;
        while (pGrupo != null) {
            if (pGrupo.getNombre().equals(nombreG)) {
                pGrupo.agregarContactoGrupo(buscarContacto(nombreC, apellido));
                return;
            }
            pGrupo = pGrupo.next;
        }
        return;
    }

    public static void eliminarDeGrupo(String nombreG, String nombreC, String apellido) {
        Grupo pGrupo = hGrupo;
        while (pGrupo != null) {
            if (pGrupo.getNombre().equals(nombreG)) {
                pGrupo.eliminarContactoGrupo(nombreC, apellido);
                return;
            }
            pGrupo = pGrupo.next;
        }
        return;
    }

    public static void mostrarGrupo(String nombreG) {
        Grupo pGrupo = hGrupo;
        while (pGrupo != null) {
            if (pGrupo.getNombre().equals(nombreG)) {
                configuracion.agendaMostrarGrupo(pGrupo.getNombre());
                pGrupo.mostrarContactoGrupo();
                return;
            }
            pGrupo = pGrupo.next;
        }
        return;
    }

    public static void mostrarContactosEnGrupo(String nombreG) {
        Grupo pGrupo = hGrupo;
        while (pGrupo != null) {
            if (pGrupo.getNombre().equals(nombreG)) {
                pGrupo.mostrarContactoGrupo();
                return;
            }
            pGrupo = pGrupo.next;
        }
        return;
    }
}

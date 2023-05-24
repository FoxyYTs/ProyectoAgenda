public class Agenda {
    public static Contacto hContacto, tContacto;
    public static Grupo hGrupo, tGrupo;
    private static String formatoFechaHora = "d/M/y h:mm a", idioma = "es";
    public static Configuracion configuracion = new Configuracion(formatoFechaHora, idioma);
    public static Calendario calendario = new Calendario();

    public Agenda() {
    }

    public void menu() {
        configuracion.menu();
    }

    // Funciones Contactos
    public static void insertarContacto(String nombre, String apellido, String correo, String telefono) {
        Contacto nuevo = new Contacto(nombre, apellido, correo, telefono);
        if (hContacto == null && tContacto == null) {
            hContacto = nuevo;
            tContacto = nuevo;
        } else {
            Contacto pContacto = hContacto;
            while (pContacto.next != null) {
                pContacto = pContacto.next;
            }
            tContacto = pContacto.next = nuevo;
            nuevo.back = pContacto;
        }
    }

    public static void eliminarContacto(String nombre, String apellido) {
        if ((hContacto == null && tContacto == null) || nombre == null || apellido == null) {
            Configuracion.Nulo();
            return;
        }
        if (hContacto.getNombre().equals(nombre) && hContacto.getApellido().equals(apellido)) {
            hContacto = hContacto.next;
            hContacto.back = null;
            Grupo pGrupo = hGrupo;
            while (pGrupo != null) {
                pGrupo.eliminarContactoGrupo(nombre, apellido);
                pGrupo = pGrupo.next;
            }
            return;
        }
        Contacto pContacto = hContacto;
        while (!pContacto.next.getNombre().equals(nombre) && !pContacto.next.getApellido().equals(apellido)
                && pContacto.next != null) {
            pContacto = pContacto.next;
        }
        if (pContacto.next != null) {
            pContacto.back.next = pContacto.next;
            pContacto.next.back = pContacto.back;
        }
        if (hGrupo == null && tGrupo == null) {
            return;
        }
        Grupo pGrupo = hGrupo;
        while (pGrupo != null) {
            pGrupo.eliminarContactoGrupo(nombre, apellido);
            pGrupo = pGrupo.next;
        }
        return;
    }

    public static void mostrarContacto() {
        if (hContacto == null && tContacto == null) {
            Configuracion.Nulo();
            return;
        }
        Contacto pContacto = hContacto;
        while (pContacto != null) {
            Configuracion.imprimirMostrarContactos(pContacto.getNombre(), pContacto.getApellido(), pContacto.getCorreo(), pContacto.getTelefono());
            pContacto = pContacto.next;
        }
        System.out.println();
    }

    public static Contacto buscarContacto(String nombre, String apellido) {
        if (hContacto == null && tContacto == null) {
            Configuracion.Nulo();
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
        if (hGrupo == null && tGrupo == null) {
            hGrupo = nuevo;
            tGrupo = nuevo;
        } else {
            Grupo pGrupos = hGrupo;
            while (pGrupos.next != null) {
                pGrupos = pGrupos.next;
            }
            tGrupo = pGrupos.next = nuevo;
            nuevo.back = pGrupos;
        }
    }

    public static void eliminarGrupos(String nombre) {
        if ((hGrupo == null && tGrupo == null) || nombre == null) {
            Configuracion.Nulo();
            return;
        }
        if (hGrupo.getNombre().equals(nombre)) {
            hGrupo = hGrupo.next;
            hGrupo.back = null;
            return;
        }
        Grupo pGrupos = hGrupo;
        while (!pGrupos.next.getNombre().equals(nombre) && pGrupos.next != null) {
            pGrupos = pGrupos.next;
        }
        if (pGrupos.next != null) {
            pGrupos.back.next = pGrupos.next;
            pGrupos.next.back = pGrupos.back;
        }
    }

    public static void mostrarGrupos() {
        if (hGrupo == null && tGrupo == null) {
            Configuracion.Nulo();
            return;
        }
        Grupo pGrupos = hGrupo;
        while (pGrupos != null) {
            configuracion.agendaMostrarGrupo(pGrupos.getNombre());
            mostrarGrupo(pGrupos.getNombre());
            pGrupos = pGrupos.next;
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
        if ((hGrupo == null && tGrupo == null)  || nombreG == null|| nombreC == null || apellido == null) {
            Configuracion.Nulo();
            return;
        }
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

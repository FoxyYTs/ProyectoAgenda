public class Agenda {
    public static Contacto hContacto, tContacto;
    public static Grupo hGrupo, tGrupo;
    public static Nota hNota, tNota;
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
            Contacto pContacto = tContacto;
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
        mostrarContactoRecu(pContacto);
        System.out.println();
    }

    public static void mostrarContactoRecu(Contacto pContacto){
        if (pContacto != null){
            mostrarContactoRecu(pContacto.next);
            Configuracion.imprimirMostrarContactos(pContacto.getNombre(), pContacto.getApellido(), pContacto.getCorreo(), pContacto.getTelefono());
        }
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
            Grupo pGrupos = tGrupo;
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
    // Funciones Notas

    public static void insertarNota(String titulo) {
        Nota nuevo = new Nota(titulo);
        if (hNota == null && tNota == null) {
            hNota = nuevo;
            tNota = nuevo;
        } else {
            Nota pNota = tNota;
            tNota = pNota.next = nuevo;
            nuevo.back = pNota;
        }
    }

    public static void eliminarNota(String titulo) {
        if ((hNota == null && tNota == null) || titulo == null) {
            Configuracion.Nulo();
            return;
        }
        if (hNota.getTitulo().equals(titulo)) {
            hNota = hNota.next;
            hNota.back = null;
            return;
        }
        Nota pNota = hNota;
        while (!pNota.next.getTitulo().equals(titulo) && pNota.next != null) {
            pNota = pNota.next;
        }
        if (pNota.next != null) {
            pNota.back.next = pNota.next;
            pNota.next.back = pNota.back;
        }
    }

    public static void mostrarNota() {
        if (hNota == null && tNota == null) {
            Configuracion.Nulo();
            return;
        }
        Nota pointer = hNota;
        while (pointer != null) {
            System.out.println(pointer.getTitulo() + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public static Nota buscarNota(String titulo) {
        if (hContacto == null && tContacto == null) {
            Configuracion.Nulo();
            return null;
        }
        Nota pNota = hNota;
        while (pNota != null) {
            if (pNota.getTitulo().equals(titulo)) {
                return pNota;
            }
            pNota = pNota.next;
        }
        return null;
    }
}

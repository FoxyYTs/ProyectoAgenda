public class Agenda {

    public Contactos headContactos;
    public Contactos pointerContactos = headContactos;
    public Grupos headGrupos;
    public Grupos pointerGrupos = headGrupos;
    public Calendario calendario;
    public Configuracion configuracion;

    public void agregarContactos(String nombre, String apellido, String correo, String telefono) {
        Contactos nuevo = new Contactos(nombre, apellido, correo, telefono);
        if (headContactos == null) {
            headContactos = nuevo;
        } else {
            Contactos pointerContactos = headContactos;
            while (pointerContactos.next != null) {
                pointerContactos = pointerContactos.next;
            }
            pointerContactos.next = nuevo;
        }
    }

    public void eliminarContactos(String nombre) {
        if (headContactos == null) {
            return;
        }
        if (headContactos.getNombre() == nombre) {
            headContactos = headContactos.next;
            return;
        }
        Contactos pointerContactos = headContactos;
        while (pointerContactos.next.getNombre() != nombre && pointerContactos.next != null) {
            pointerContactos = pointerContactos.next;
        }
        if (pointerContactos.next != null) {
            pointerContactos.next = pointerContactos.next.next;
        }
    }

    public void buscarContactos(String nombre) {
        if (headContactos == null) {
            return;
        }
        if (headContactos.getNombre() == nombre) {
            System.out.println(headContactos.getNombre() + headContactos.getApellido() + headContactos.getCorreo()
                    + headContactos.getTelefono());
        }
        Contactos pointerContactos = headContactos;
        while (pointerContactos.next.getNombre() != nombre && pointerContactos.next != null) {
            pointerContactos = pointerContactos.next;
        }
    }

    public void mostrarContactos() {
        Contactos pointerContactos = headContactos;
        while (pointerContactos != null) {
            System.out.print("Contacto [nombre: " + pointerContactos.getNombre() + ", apellido: "
                    + pointerContactos.getApellido()
                    + ", telefono: " + pointerContactos.getTelefono() + ", correo: " + pointerContactos.getCorreo()
                    + "]");
            pointerContactos = pointerContactos.next;
        }
        System.out.println();
    }

    public void agregarGrupos(String nombre) {
        Grupos nuevo = new Grupos(nombre);
        if (headGrupos == null) {
            headGrupos = nuevo;
        } else {
            Grupos pointerGrupos = headGrupos;
            while (pointerContactos.next != null) {
                pointerGrupos = pointerGrupos.next;
            }
            pointerGrupos.next = nuevo;
        }
    }

    public void eliminarGrupos(String nombre) {
        if (headGrupos == null) {
            return;
        }
        if (headGrupos.getNombre() == nombre) {
            headGrupos = headGrupos.next;
            return;
        }
        Grupos pointerGrupos = headGrupos;
        while (pointerGrupos.next.getNombre() != nombre && pointerGrupos.next != null) {
            pointerGrupos = pointerGrupos.next;
        }
        if (pointerGrupos.next != null) {
            pointerGrupos.next = pointerGrupos.next.next;
        }
    }

    public void mostrarGrupos() {
        Grupos pointerGrupos = headGrupos;
        while (pointerGrupos != null) {
            System.out.print("Contacto [nombre: " + pointerGrupos.getNombre() + "]");
            pointerGrupos = pointerGrupos.next;
        }
        System.out.println();
    }

    String apellido, correo, telefono;

    public void agregarContactoAGrupo(String nombre) {
        if (headGrupos == null) {
            return;
        }
        if (headGrupos.getNombre() == nombre) {
            System.out.println(headGrupos.getNombre());
        }
        Grupos pointerGrupos = headGrupos;
        while (pointerGrupos.next.getNombre() != nombre && pointerGrupos.next != null) {
            pointerGrupos = pointerGrupos.next;
            pointerGrupos.insertarContacto(nombre, apellido, correo, telefono);
        }
    }

    public void elimininarContactoDeGrupo(String nombre) {
        if (headGrupos == null) {
            return;
        }
        if (headGrupos.getNombre() == nombre) {
            System.out.println(headGrupos.getNombre());
        }
        Grupos pointerGrupos = headGrupos;
        while (pointerGrupos.next.getNombre() != nombre && pointerGrupos.next != null) {
            pointerGrupos = pointerGrupos.next;
            pointerGrupos.eliminarContacto(nombre);
        }
    }
}
public class Grupo extends Agenda {
    private String nombre;
    private static Contacto head, tail;
    public Grupo next, back;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.next = null;
        this.back = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarContactoGrupo(Contacto conta) {
        Contacto nuevo = new Contacto(conta.getNombre(), conta.getApellido(), conta.getTelefono(), conta.getCorreo());
        if (head == null && tail == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            Contacto pointer = tail;
            tail = pointer.next = nuevo;
            nuevo.back = pointer;
        }
    }

    public void eliminarContactoGrupo(String nombre, String apellido) {
        if ((head == null && tail == null) || nombre == null || apellido == null) {
            Configuracion.Nulo();
            return;
        }
        if (head.getNombre().equals(nombre) && head.getApellido().equals(apellido)) {
            head = head.next;
            head.back = null;
            return;
        }
        Contacto pointer = head;
        while (!pointer.next.getNombre().equals(nombre) && pointer.next.getApellido().equals(apellido)
                && pointer.next != null) {
            pointer = pointer.next;
        }
        if (pointer.next != null) {
            pointer.back.next = pointer.next;
            pointer.next.back = pointer.back;
        }
        return;
    }

    public void mostrarContactoGrupo() {
        Contacto pointer = head;
        while (pointer != null) {
            Configuracion.imprimirMostrarContactos(pointer.getNombre(), pointer.getApellido(), pointer.getTelefono(),
                    pointer.getCorreo());
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void buscarContactoGrupo(String nombre, String apellido) {
        if ((hContacto == null && tContacto == null) || nombre == null || apellido == null) {
            Configuracion.Nulo();
        }
        Contacto pContacto = hContacto;
        while (pContacto != null) {
            if (pContacto.getNombre().equals(nombre) && pContacto.getApellido().equals(apellido)) {
                Configuracion.imprimirMostrarContactos(pContacto.getNombre(), pContacto.getApellido(),
                        pContacto.getTelefono(), pContacto.getCorreo());
            }
            pContacto = pContacto.next;
        }
    }

}

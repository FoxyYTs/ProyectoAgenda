public class Grupo extends Agenda {
    private String nombre;
    private static Contacto head;
    public Grupo next;

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.next = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarContactoGrupo(Contacto conta) {
        Contacto nuevo = new Contacto(conta.getNombre(), conta.getApellido(), conta.getTelefono(), conta.getCorreo());
        if (head == null) {
            head = nuevo;
        } else {
            Contacto pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = nuevo;
        }
    }

    public void eliminarContactoGrupo(String nombre, String apellido) {
        if (head == null || nombre == null || apellido == null) {
            Configuracion.Nulo();
            return;
        }
        if (head.getNombre().equals(nombre) && head.getApellido().equals(apellido)) {
            head = head.next;
            return;
        }
        Contacto pointer = head;
        while (!pointer.next.getNombre().equals(nombre) && pointer.next.getApellido().equals(apellido)
                && pointer.next != null) {
            pointer = pointer.next;
        }
        if (pointer.next != null) {
            pointer.next = pointer.next.next;
        }

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
        if (hContacto == null || nombre == null || apellido == null) {
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

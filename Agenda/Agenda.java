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
}
public class Agenda {

    public Eventos headContactos;
    public Eventos pointerContactos = headContactos;
    public Recordatorios headGrupos;
    public Recordatorios pointerGrupos = headGrupos;
    public Calendario calendario;
    public Configuracion configuracion;

    public void agregarContactos(String nombre, String apellido, String correo, String telefono) {
        Contactos nuevo = new Contactos(nombre, apellido, correo, telefono);
        if (headContactos == null) {
            headContactos = nuevo;
        } else {
            Eventos pointerContactos = headContactos;
            while (pointerContactos.next != null) {
                pointerContactos = pointerContactos.next;
            }
            pointerContactos.next = nuevo;
        }
    }

    public void eliminarContacto(String nombre) {
        if (headContactos == null) {
            return;
        }
        if (headContactos.getTitulo() == nombre) {
            headContactos = headContactos.next;
            return;
        }
        Eventos pointerContactos = headContactos;
        while (pointerContactos.next.getTitulo() != nombre && pointerContactos.next != null) {
            pointerContactos = pointerContactos.next;
        }
        if (pointerContactos.next != null) {
            pointerContactos.next = pointerContactos.next.next;
        }
    }
}
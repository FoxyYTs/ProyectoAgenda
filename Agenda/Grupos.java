import java.util.ArrayList;

public class Grupos {

    private String nombre;
    private ArrayList<Contactos> contactos;

    public Grupos(String nombre) {
        this.nombre = nombre;
        contactos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregarContacto(Contactos contacto) {
        contactos.add(contacto);
    }

    public void eliminarContacto(Contactos contacto) {
        contactos.remove(contacto);
    }

    public ArrayList<Contactos> getContactos() {
        return contactos;
    }
}
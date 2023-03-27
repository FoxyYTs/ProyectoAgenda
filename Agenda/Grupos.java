import java.util.ArrayList;

public class Grupos {

    private String nombre;
    public Contactos head;
    public Contactos pointer = head;
    public Grupos next;

    public void insertar (String nombre,String apellido,String correo,String telefono){
        Contactos nuevo = new Contactos(nombre,apellido,correo,telefono);
        if(head == null){
            head = nuevo;
        }else{
            Contactos pointer = head;
            while(pointer.next != null){
                pointer = pointer.next;
            }
            pointer.next = nuevo;
        }
    }

    public void eliminar (String nombre){
        while(pointer.getNombre() == nombre && pointer.next != null){

        }
    }

    public void mostrar() {
        Contactos pointer = head;
        while (pointer != null) {
            System.out.print("Contacto [nombre: " + pointer.getNombre() + ", apellido: " + pointer.getApellido() + ", telefono: " + pointer.getTelefono() + ", correo: " + pointer.getCorreo() + "]");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public Grupos(String nombre) {
        this.nombre = nombre;
        this.head = null;
        this.next = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
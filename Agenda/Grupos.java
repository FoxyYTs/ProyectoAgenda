public class Grupos {

    private String nombre;
    public Contactos head;
    public Contactos pointer = head;
    public Grupos next;

<<<<<<< HEAD
    public void insertar(String nombre, String apellido, String correo, String telefono) {
        Contactos nuevo = new Contactos(nombre, apellido, correo, telefono);
        if (head == null) {
=======
    public void insertarContacto (String nombre,String apellido,String correo,String telefono){
        Contactos nuevo = new Contactos(nombre,apellido,correo,telefono);
        if(head == null){
>>>>>>> 377e1370ec0ad9c88bc295a1a4c3ea30a5f0d5dc
            head = nuevo;
        } else {
            Contactos pointer = head;
            while (pointer.next != null) {
                pointer = pointer.next;
            }
            pointer.next = nuevo;
        }
    }

<<<<<<< HEAD
    public void eliminar(String nombre) {
        while (pointer.getNombre() == nombre && pointer.next != null) {

=======
    public void eliminarContacto (String nombre){
        if (head == null) {
            return;
        }          
        if (head.getNombre() == nombre) {
            head = head.next;
            return;
        }
        Contactos pointer = head;
        while(pointer.next.getNombre() != nombre && pointer.next != null){
            pointer = pointer.next;
        }
        if (pointer.next != null) {
            pointer.next = pointer.next.next;
>>>>>>> 377e1370ec0ad9c88bc295a1a4c3ea30a5f0d5dc
        }
    }

    public void mostrarContacto () {
        Contactos pointer = head;
        while (pointer != null) {
            System.out.print("Contacto [nombre: " + pointer.getNombre() + ", apellido: " + pointer.getApellido()
                    + ", telefono: " + pointer.getTelefono() + ", correo: " + pointer.getCorreo() + "]");
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
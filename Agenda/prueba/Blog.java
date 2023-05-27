package prueba;
public class Blog {
    public Nota head, tail;

    public Blog(){
        this.head = null;
        this.tail = null;
    }

    public void insertar(String titulo) {
        Nota nuevo = new Nota(titulo);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            Nota pointer = tail;
            tail = pointer.next = nuevo;
            nuevo.back = pointer;
        }
    } 

    public void mostrar() {
        System.out.println("Mostrar: ");
        Nota pointer = head;
        while (pointer != null) {
            System.out.print(pointer.titulo + " ");
            pointer = pointer.next;
        }
        System.out.println();
        System.out.println("Cabeza: " + head.titulo + " Cola: " + tail.titulo);
    }
}

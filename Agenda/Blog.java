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
        Nota pointer = head;
        while (pointer != null) {
            System.out.println(pointer.getTitulo() + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public Nota selec(String titulo){
        Nota pointer = head;
        while(pointer != null){
            if (pointer.getTitulo().equals(titulo)){
                return pointer;

            }
            pointer = pointer.next;
        }
        return null;
    }
}

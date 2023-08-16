public class Buzon {
    public Mensaje head, tail;

    public void insertar(String destino, String mensaje){
        Mensaje nuevo = new Mensaje(destino, mensaje);
        if (head == null && tail == null) {
            head = nuevo;
            tail = nuevo;
        }
        head.back = nuevo;
        nuevo.next = head;
        head = head.back;
    }

    public void leer(){
        
        if (tail.back == null){
            Configuracion.Nulo();
        } else {
            tail = tail.back;
            tail.next = null;
        }

        Configuracion.mensaje(tail.getDestino(), tail.getMensaje());
    }
}
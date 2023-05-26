package prueba;
public class Notas {
    String titulo, nota;
    Notas next, back;
    public Notas(String titulo, String nota){
        this.titulo = titulo;
        this.next = null;
        this.back = null;
    }
}
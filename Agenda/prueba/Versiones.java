package prueba;

public class Versiones {
    private String nota;
    public Versiones next,back;
    public Versiones (String nota){
        this.next = null;
        this.back = null;
        this.nota = nota;
    }
}

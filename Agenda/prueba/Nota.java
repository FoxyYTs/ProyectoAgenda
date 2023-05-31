package prueba;
public class Nota {
    private String titulo;
    public Nota next, back;
    public Version top;
    public Nota(String titulo){
        this.titulo = titulo;
        this.next = null;
        this.back = null;
        this.top = new Version("");
    }

    public void insertar(String texto){
        Version nuevo = new Version(texto);
        if (top == null) {
            top = nuevo;
        } else {
            top.back = nuevo;
            nuevo.next = top;
            top = top.back;
        }
    }

    public void volver(){
        if (top.next == null){
            System.out.println("No hay mas versiones");
        } else {
            top.next = top;
            top.back = null;
        }
    }

    public void mostrar(){
        System.out.println();
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
}
package prueba;
public class Nota {
    private String titulo;
    public Nota next, back;
    public Version top;
    public Nota(String titulo){
        this.titulo = titulo;
        this.next = null;
        this.back = null;
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
        if (top.back == null){
            System.out.println("No hay mas versiones");
        } else {
            top.back = top;
            top.next = null;
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
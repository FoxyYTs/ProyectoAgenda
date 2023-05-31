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
        top.back = nuevo;
        nuevo.next = top;
        top = top.back;
    }

    public void volver(){
        if (top.next == null){
            Configuracion.Nulo();
        } else {
            top = top.next;
            top.back = null;
        }
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
}

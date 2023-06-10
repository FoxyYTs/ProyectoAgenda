public class Mensaje {
    private String mensaje, destino;
    public Mensaje next,back;

    public Mensaje(String destino, String mensaje){
        this.mensaje = mensaje;
        this.destino = destino;
        this.next = null;
        this.back = null;
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public String getDestino(){
        return destino;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }
}

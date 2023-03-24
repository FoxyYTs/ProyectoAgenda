import java.time.LocalDateTime;

public class Recordatorios {
    private String mensaje;
    private LocalDateTime fechaHora;

    public Recordatorios(String mensaje, LocalDateTime fechaHora){
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
    }

    public String getMensaje(){
        return mensaje;
    }

    public LocalDateTime getfechaHora(){
        return fechaHora;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public void setFechaHora(LocalDateTime fechaHora){
        this.fechaHora = fechaHora;
    }
}

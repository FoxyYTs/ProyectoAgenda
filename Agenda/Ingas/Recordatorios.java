package Ingas;

import java.time.LocalDateTime;

public class Recordatorios {
    private String mensaje, titulo;
    private LocalDateTime fechaHora;
    public Recordatorios next;

    public Recordatorios(String titulo, String mensaje, LocalDateTime fechaHora){
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaHora = fechaHora;
        this.next = null;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getMensaje(){
        return mensaje;
    }

    public LocalDateTime getFechaHora(){
        return fechaHora;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public void setFechaHora(LocalDateTime fechaHora){
        this.fechaHora = fechaHora;
    }
}

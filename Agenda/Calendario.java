import java.util.Calendar;
import java.time.LocalDateTime;

public class Calendario {

    public Eventos headEvento = eventos;
    public Eventos pointerEvento = headEvento;
    public Recordatorios headRecordatorio = recordatorios;
    public Recordatorios pointerRecordatorio = headRecordatorio;

    public void insertarEvento(String titulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Eventos nuevo = new Eventos(titulo, fechaHoraInicio, fechaHoraFin);
        if (headEvento == null) {
            headEvento = nuevo;
        } else {
            Eventos pointerEventos = headEvento;
            while (pointerEventos.next != null) {
                pointerEventos = pointerEventos.next;
            }
            pointerEventos.next = nuevo;
        }
    }

    public void mostrar() {
        Eventos pointerEventos = headEvento;
        while (pointerEventos != null) {
            System.out.print("Evento [titulo: " + pointerEventos.getTitulo() + ", Fecha y Hora de inicio: "
                    + pointerEventos.getFechaHoraInicio() + ", Fecha y hora de Fin: " + pointerEventos.getFechaHoraFin()
                    + "]");
            pointerEventos = pointerEventos.next;
        }
        System.out.println();
    }

    public ArrayList getEvento() {
        return eventos;
    }

    public ArrayList getRecordatorio() {
        return recordatorios;
    }

}

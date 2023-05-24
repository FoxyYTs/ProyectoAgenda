import java.time.LocalDateTime;

public class Calendario extends Agenda {

    private Eventos headEvento, tailEvento;
    private Recordatorios headRecordatorio, tailRecordatirio;

    public void insertarEventos(String titulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Eventos nuevo = new Eventos(titulo, fechaHoraInicio, fechaHoraFin);
        if (headEvento == null && tailEvento == null) {
            headEvento = nuevo;
            tailEvento = nuevo;
        } else {
            Eventos pEventos = headEvento;
            while (pEventos.next != null) {
                pEventos = pEventos.next;
            }
            tailEvento = pEventos.next = nuevo;
            nuevo.back = pEventos;
        }
    }

    public void eliminarEvento(String titulo) {
        if ((headEvento == null && tailEvento == null) || titulo == null) {
            Configuracion.Nulo();
            return;
        }
        if (headEvento.getTitulo().equals(titulo)) {
            headEvento = headEvento.next;
            headEvento.back = null;
            return;
        }
        Eventos pEvento = headEvento;
        while (!pEvento.next.getTitulo().equals(titulo) && pEvento.next != null) {
            pEvento = pEvento.next;
        }
        if (pEvento.next != null) {
            pEvento.back.next = pEvento.next;
            pEvento.next.back = pEvento.back;
        }
        return;
    }

    public void mostrarEventos() {
        Eventos pEventos = headEvento;
        while (pEventos != null) {
            configuracion.calendarioMostrarEvento(pEventos.getTitulo(), pEventos.getFechaHoraInicio(),
                    pEventos.getFechaHoraFin());
            pEventos = pEventos.next;
        }
        System.out.println();
    }

    public void insertarRecordatorios(String titulo, String mensaje, LocalDateTime fechaHora) {
        Recordatorios nuevo = new Recordatorios(titulo, mensaje, fechaHora);
        if (headRecordatorio == null && tailRecordatirio == null) {
            headRecordatorio = nuevo;
            tailRecordatirio = nuevo;
        } else {
            Recordatorios pRecordatorio = headRecordatorio;
            while (pRecordatorio.next != null) {
                pRecordatorio = pRecordatorio.next;
            }
            tailRecordatirio = pRecordatorio.next = nuevo;
            nuevo.back = pRecordatorio;
        }
    }

    public void eliminarRecordatorios(String titulo) {
        if ((headRecordatorio == null && tailRecordatirio == null)|| titulo == null) {
            Configuracion.Nulo();
            return;
        }
        if (headRecordatorio.getTitulo().equals(titulo)) {
            headRecordatorio = headRecordatorio.next;
            headRecordatorio = null;
            return;
        }
        Recordatorios pRecordatorio = headRecordatorio;
        while (!pRecordatorio.next.getTitulo().equals(titulo) && pRecordatorio.next != null) {
            pRecordatorio = pRecordatorio.next;
        }
        if (pRecordatorio.next != null) {
            pRecordatorio.back.next = pRecordatorio.next;
            pRecordatorio.next.back = pRecordatorio.back;
        }
        return;
    }

    public void mostrarRecordatorios() {
        Recordatorios pRecordatorio = headRecordatorio;
        while (pRecordatorio != null) {
            configuracion.calendarioMostrarRecordatorios(pRecordatorio.getTitulo(), pRecordatorio.getMensaje(),
                    pRecordatorio.getFechaHora());
            pRecordatorio = pRecordatorio.next;
        }
        System.out.println();
    }

}
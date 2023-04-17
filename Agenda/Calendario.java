import java.time.LocalDateTime;

public class Calendario extends Agenda {

    private Eventos headEvento;
    private Recordatorios headRecordatorio;

    public void insertarEventos(String titulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        Eventos nuevo = new Eventos(titulo, fechaHoraInicio, fechaHoraFin);
        if (headEvento == null) {
            headEvento = nuevo;
        } else {
            Eventos pEventos = headEvento;
            while (pEventos.next != null) {
                pEventos = pEventos.next;
            }
            pEventos.next = nuevo;
        }
    }

    public void eliminarEvento(String titulo) {
        if (headEvento == null || titulo == null) {
            Configuracion.Nulo();
            return;
        }
        if (headEvento.getTitulo().equals(titulo)) {
            headEvento = headEvento.next;
            return;
        }
        Eventos pEvento = headEvento;
        while (!pEvento.next.getTitulo().equals(titulo) && pEvento.next != null) {
            pEvento = pEvento.next;
        }
        if (pEvento.next != null) {
            pEvento.next = pEvento.next.next;
        }
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
        if (headRecordatorio == null) {
            headRecordatorio = nuevo;
        } else {
            Recordatorios pRecordatorio = headRecordatorio;
            while (pRecordatorio.next != null) {
                pRecordatorio = pRecordatorio.next;
            }
            pRecordatorio.next = nuevo;
        }
    }

    public void eliminarRecordatorios(String titulo) {
        if (headRecordatorio == null || titulo == null) {
            Configuracion.Nulo();
            return;
        }
        if (headRecordatorio.getTitulo().equals(titulo)) {
            headRecordatorio = headRecordatorio.next;
            return;
        }
        Recordatorios pRecordatorio = headRecordatorio;
        while (!pRecordatorio.next.getTitulo().equals(titulo) && pRecordatorio.next != null) {
            pRecordatorio = pRecordatorio.next;
        }
        if (pRecordatorio.next != null) {
            pRecordatorio.next = pRecordatorio.next.next;
        }
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
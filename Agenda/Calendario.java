import java.util.ArrayList;
import java.util.Calendar;

public class Calendario {
    private ArrayList<Eventos> eventos;
    private ArrayList<Recordatorios> recordatorios;

    public Calendario() {
        eventos = new ArrayList<>();
        recordatorios = new ArrayList<>();
    }

    public void agregarEvento(Eventos evento) {
        eventos.add(evento);
    }

    public void eliminarEvento(Eventos evento) {
        recordatorios.remove(evento);
    }

    public void agregarRecordatorio(Recordatorios recordatorio) {
        recordatorios.add(recordatorio);
    }

    public void eliminarRecordatorio(Recordatorios recordatorio) {
        recordatorios.remove(recordatorio);
    }

    public ArrayList getEvento() {
        return eventos;
    }

    public ArrayList getRecordatorio() {
        return recordatorios;
    }

}

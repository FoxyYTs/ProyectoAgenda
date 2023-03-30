import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Configuracion {
    private static String formatoFecha;
    private DateTimeFormatter formatoFechaHora;
    private static String idioma;

    Calendario calendario = new Calendario();

    public Configuracion(String formatoFecha, String idioma) {
        this.formatoFecha = formatoFecha;
        this.idioma = idioma;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setFormatoFecha(String formatoFecha) {
        this.formatoFecha = formatoFecha;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public static String fechaHora(LocalDateTime fechaHoraActual) {
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(formatoFecha);
        String fechaHoraFormateada = fechaHoraActual.format(formatoFechaHora);
        return fechaHoraFormateada;
    }

    public void calendarioMostrarEvento(String titulo, LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFinal) {
        if (idioma == "en") {
            System.out.print("Event [title: " + titulo + ", Start date and time: " + fechaHoraInicio
                    + ", End date and time: " + fechaHoraFinal + "]");
        } else {
            System.out.print("Evento [titulo: " + titulo + ", Fecha y Hora de inicio: " + fechaHoraInicio
                    + ", Fecha y hora de Fin: " + fechaHoraFinal + "]");
        }
    }

    public void calendarioMostrarRecordatorios(String mensaje, LocalDateTime fechaHora) {
        if (idioma == "en") {
            System.out.println("");
        } else {
            System.out.print("Recordatorio [mensaje: " + mensaje + ", Fecha y Hora: " + fechaHora + "]");
        }
    }

}
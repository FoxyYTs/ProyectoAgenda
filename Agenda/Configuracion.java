import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Configuracion {
    private String formatoFecha = "dd/MM/yyyy HH:mm";
    private DateTimeFormatter formatoFechaHora;
    private String idioma;

    public Configuracion(String formatoFecha, String idioma) {
        this.formatoFecha = formatoFecha;
        this.idioma = idioma;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formaFecha) {
        formatoFechaHora = DateTimeFormatter.ofPattern(formatoFecha);
    }

    public String cambiarHora(LocalDateTime fechaHora){
        String fechaHoraFormateada = fechaHora.format(formatoFechaHora);
        return fechaHoraFormateada;
    }
}
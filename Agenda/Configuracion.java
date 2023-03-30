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

    public static String fechaHora(LocalDateTime fechaHoraActual){
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(formatoFecha);
        String fechaHoraFormateada = fechaHoraActual.format(formatoFechaHora);
        return fechaHoraFormateada;
    }

    public void calendarioMostrarEvento(){
        String saludo = null;
        if (idioma == "es"){
            System.out.print("Evento [titulo: " + calendario.pointerEventos.getTitulo() + ", Fecha y Hora de inicio: " + pointerEventos.getFechaHoraInicio() + ", Fecha y hora de Fin: " + pointerEventos.getFechaHoraFin() + "]");
        }else if(idioma == "en"){
            saludo = "Hello";
        }
    }

}
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaFormato {
    public static void main(String[] args) {
        // Crear un objeto LocalDateTime con la fecha y hora actual
        LocalDateTime fechaHoraActual = LocalDateTime.now();

        // Crear un objeto DateTimeFormatter con un patrón de formato personalizado
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Formatear la fecha y hora utilizando el objeto DateTimeFormatter
        String fechaHoraFormateada = fechaHoraActual.format(formatoFechaHora);

        // Imprimir la fecha y hora formateada
        System.out.println("Fecha y hora formateada: " + fechaHoraFormateada);
    }
}

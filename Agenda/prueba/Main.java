package prueba;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String a = "d/M/y h:m a";
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d/M/y H:m a");
        String fechaHoraActualFormateada = fechaHoraActual.format(formato);
        System.out.println("Fecha y hora actual: " + fechaHoraActualFormateada);

        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(a);
        LocalDateTime fechaHoraFormateada = LocalDateTime.parse("17/01/2004 8:30", formatoFechaHora);
    }
}   



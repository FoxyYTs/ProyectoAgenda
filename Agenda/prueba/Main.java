package prueba;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) {
        String a = "d/M/y h:mm a";
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern(a);
        String fechaHoraActualFormateada = fechaHoraActual.format(formato);
        LocalDateTime fechaHoraFormatead = LocalDateTime.parse("23/4/2023 10:06 AM", formato);
        String fechaHoraFormateada = fechaHoraFormatead.format(formato);

        System.out.println("Fecha y hora actual: " + fechaHoraActualFormateada);
        System.out.println("Fecha y hora actual: " + fechaHoraFormateada);
    }
}   



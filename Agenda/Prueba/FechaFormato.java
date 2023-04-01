import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;  

public class FechaFormato {
    
    /*
    public static void main(String[] args) {
        String hola = null;
        System.out.println(hola);
        hola = "hola";
        System.out.println(hola);
        hola = null;
        System.out.println(hola);
    } */




    public static String hora(String formato, LocalDateTime fechaHoraActual){
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(formato);
        String fechaHoraFormateada = fechaHoraActual.format(formatoFechaHora);
        return fechaHoraFormateada;
    }
    
}

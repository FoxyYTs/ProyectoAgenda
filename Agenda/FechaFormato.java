import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;  

public class FechaFormato {
    

    public static void main(String[] args) {
        String hola = null;
        System.out.println(hola);
        hola = "hola";
        System.out.println(hola);
        hola = null;
        System.out.println(hola);
    }




    /*public static String hora(String formato, LocalDateTime fechaHoraActual){
        DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern(formato);
        String fechaHoraFormateada = fechaHoraActual.format(formatoFechaHora);
        return fechaHoraFormateada;
    }
    public static void main(String[] args) {
        String formato = "dd/MM/yyyy HH:mm:ss",idioma = "es";
        Configuracion confi = new Configuracion(formato, idioma);
        Scanner leer = new Scanner(System.in);
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("Hora Actual: " + confi.fechaHora(fechaHoraActual));
        System.out.println("Ingresa el formato de hora");
        confi.setFormatoFecha(leer.nextLine());
        System.out.println("Hora Actual: " + confi.fechaHora(fechaHoraActual));
        
    }*/
}

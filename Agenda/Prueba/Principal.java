import java.util.Scanner;
import java.time.LocalDateTime;

public class Principal {
    FechaFormato fachero = new FechaFormato();
    Scanner leer = new Scanner(System.in);
    private String formato,idioma;

    public Principal(String formato, String idioma) {
        this.formato = formato;
        this.idioma = idioma;
    }

    Configuracion confi = new Configuracion(formato, idioma);



    public void pedro() {
        
        
        LocalDateTime fechaHoraActual = LocalDateTime.now();
        System.out.println("Hora Actual: " + confi.fechaHora(fechaHoraActual));
        System.out.println("Ingresa el formato de hora");
        confi.setFormatoFecha(leer.nextLine());
        System.out.println("Hora Actual: " + confi.fechaHora(fechaHoraActual));
        
    }

    public String getFormato() {
        return formato;
    }



    public void setFormato(String formato) {
        this.formato = formato;
    }



    public String getIdioma() {
        return idioma;
    }



    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
}

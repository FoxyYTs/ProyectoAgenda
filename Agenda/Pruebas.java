import java.time.LocalDateTime;

public class Pruebas {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        LocalDateTime fechaYHora = LocalDateTime.now();
        for (int i = 0; i < 100; i++) {
            System.out.println(fechaYHora);
            
        }
    }
}

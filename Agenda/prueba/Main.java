package prueba;

import java.util.Scanner;

public class Main {
    private static Blog blog = new Blog();
    private static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        int opc;
        boolean x = true;

        System.out.println("Bienvenido a la prueba de notas");
        while (x == true){
            System.out.println("1) para crear una nueva nota\n2) para editar una nota ya creada\n3) para cerrar");

            opc = Integer.parseInt(leer.nextLine());
            if (opc == 1){
                for (int i = 0; i < 5; i++) {
                    blog.insertar("hola" + i);
                }
            } else if (opc == 2) {
                menu2LaVenganza(opc);
            } else if (opc == 3) {
                x = false;
            } else {
                System.out.println("opcion no valida");
            }
        }
        
    }

    public static void menu2LaVenganza(int opc){
        System.out.println("Las notas actuales son");
        blog.mostrar();

        System.out.println("Ingresa el nombre de la nota que quieres editar: ");
        blog.selec(leer.nextLine());
    }
}   


 
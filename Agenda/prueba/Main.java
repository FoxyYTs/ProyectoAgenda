package prueba;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Blog blog = new Blog();
        int opc;
        boolean x = true;

        System.out.println("Bienvenido a la prueba de notas");
        while (x == true){
            System.out.println("1) para crear una nueva nota\n2) para editar una nota ya creada\n3) para cerrar");

            opc = Integer.parseInt(leer.nextLine());
            if (opc == 1){
                System.out.print("Titulo de la nota: ");
                blog.insertar(leer.nextLine());
            } else if (opc == 2) {
                
            } else if (opc == 3) {
                x = false;
            } else {
                System.out.println("opcion no valida");
            }
        }
        
    }

    public static void menu2LaVenganza(int opc){

    }
}   


 
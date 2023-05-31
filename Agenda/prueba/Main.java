package prueba;

import java.util.Scanner;

public class Main {
    private static Blog blog = new Blog();
    private static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        String opc;
        boolean x = true;

        System.out.println("Bienvenido a la prueba de notas");
        while (x == true){
            System.out.println("1) para crear una nueva nota\n2) para editar una nota ya creada\n3) para cerrar");

            opc = leer.nextLine();
            if (opc.equals("1")){
                for (int i = 1; i <= 5; i++) {
                    blog.insertar("hola" + i);
                }
            } else if (opc .equals("2")) {
                menu2LaVenganza();
            } else if (opc.equals("3")) {
                x = false;
            } else {
                System.out.println("opcion no valida");
            }
        }
        
    }

    public static void menu2LaVenganza(){
        System.out.println("Las notas actuales son");
        blog.mostrar();

        System.out.println("Ingresa el nombre de la nota que quieres editar: ");
        editar(blog.selec(leer.nextLine()));
    }

    public static void editar(Nota nota){
        boolean seguir = true;
        String opc;
        System.out.println("Titulo: " + nota.getTitulo() + "\nNota\n" + nota.top.getNota());

        while (seguir == true){
            System.out.println("1) agregar contenido a la nota\n2) Ver la version actual\n3) Ver la version anterior\n4) Volver a la version anterior\n5) Cerrar");
            opc = leer.nextLine();
            if (opc.equals("1")){
                if(!nota.top.getNota().equals("")){
                    nota.insertar(nota.top.getNota() + "\n" + leer.nextLine());
                }else {
                    nota.insertar(leer.nextLine());
                }
            } else if (opc.equals("2")){
                System.out.println("Titulo: " + nota.getTitulo() + "\nNota\n" + nota.top.getNota());
            } else if (opc.equals("3")){
                System.out.println("Titulo: " + nota.getTitulo() + "\nNota\n" + nota.top.next.getNota());
            } else if (opc.equals("4")){
                System.out.println("Volviendo a la version anterior");
                nota.volver();
            }else if (opc.equals("5")){
                seguir = false;
            } else {
                System.out.println("Opcion no valida");
            }
        }

    }
}   


 
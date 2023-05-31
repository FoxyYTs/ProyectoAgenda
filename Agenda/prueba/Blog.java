package prueba;

import java.util.Scanner;

public class Blog {
    public Nota head, tail;
    static Scanner leer = new Scanner(System.in);
    public Blog(){
        this.head = null;
        this.tail = null;
    }

    public void insertar(String titulo) {
        Nota nuevo = new Nota(titulo);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            Nota pointer = tail;
            tail = pointer.next = nuevo;
            nuevo.back = pointer;
        }
    } 

    public void mostrar() {
        System.out.println("Mostrar: ");
        Nota pointer = head;
        while (pointer != null) {
            System.out.println(pointer.getTitulo() + " ");
            pointer = pointer.next;
        }
        System.out.println();
    }

    public void selec(String titulo){
        Nota pointer = head;
        while(pointer != null){
            if (pointer.getTitulo().equals(titulo)){
                editar(pointer);

            }
            pointer = pointer.next;
        }
    }

    public static void editar(Nota nota){
        boolean seguir = true;
        int opc;
        System.out.println("Titulo: " + nota.getTitulo() + "\n" + nota.top.getNota());

        while (seguir == true){
            System.out.println("1) agregar contenido a la nota\n2) Ver la version anterior\n3) Cerrar");
            opc = Integer.parseInt(leer.nextLine());
            if (opc == 1){
                nota.insertar(nota.top.getNota() + " " + leer.nextLine());
            } else if (opc == 2){
                System.out.println("Titulo: " + nota.getTitulo() + "\n" + nota.top.getNota());
            } else if (opc == 3){
                seguir = false;
            } else {
                System.out.println("Opcion no valida");
            }
        }

    }
}

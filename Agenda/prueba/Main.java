package prueba;

public class Main {
    public static void main(String[] args) {
        Blog blog = new Blog();

        blog.insertar("Harry Potter");

        blog.head.insertar("Un texto super cool");

        blog.mostrar();

        System.out.println(blog.head.get + "   " + blog.head.top.nota);
    }
}   


 
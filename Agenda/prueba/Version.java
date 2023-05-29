package prueba;

public class Version {
    private String nota;
    public Version next,back;
    public Version (String nota){
        this.next = null;
        this.back = null;
        this.nota = nota;
    }

    public String getNota(){
        return nota;
    }

    public void setNota(String nota){
        this.nota = nota;
    }
}

public class Configuracion {
    private String formatoFecha;
    private String idioma;

    public Configuracion(String formatoFecha, String idioma) {
        this.formatoFecha = formatoFecha;
        this.idioma = idioma;
    }

    public String getFormatoFecha() {
        return formatoFecha;
    }

    public void setFormatoFecha(String formaFecha) {
        this.formatoFecha = formatoFecha;
    }

}

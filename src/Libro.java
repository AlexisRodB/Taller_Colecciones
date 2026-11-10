public class Libro extends Material {

    private final String autor;
    private final String isbn;

    public Libro(String codigo, String titulo, int anio, String autor, String isbn) {
        super(codigo, titulo, anio);
        this.autor = autor;
        this.isbn = isbn;
    }

    @Override
    public String getTipo() {
        return "Libro";
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

}

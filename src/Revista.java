public class Revista extends Material {

    private final int edicion;
    private final String tematica;

    public Revista(String codigo, String titulo, int anio, int edicion, String tematica) {
        super(codigo, titulo, anio);
        this.edicion = edicion;
        this.tematica = tematica;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    public int getEdicion() {
        return edicion;
    }

    public String getTematica() {
        return tematica;
    }

}

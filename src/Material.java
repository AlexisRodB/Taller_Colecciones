public abstract class Material implements Catalogable {

    private final String codigo;
    private final String titulo;
    private final int anio;
    private boolean disponible;

    public Material(String codigo, String titulo, int anio) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = true;
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnio() {
        return anio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public abstract String getTipo();

    public void mostrarInfo() {
        String estado = disponible ? "disponible" : "prestado";
        System.out.println("[" + getTipo() + "] " + titulo + " (" + anio + ") — " + estado);
    }

}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SistemaBiblioteca {

    private final Map<String, Material> catalogo = new HashMap<>();
    private final Map<String, List<String>> listaEspera = new HashMap<>();
    private final Set<String> miembros = new HashSet<>();

    public void registrarMaterial(Material m) {
        catalogo.put(m.getCodigo(), m);
    }

    public Material buscarMaterial(String codigo) {
        return catalogo.get(codigo);
    }

    public void mostrarCatalogo() {
        for (Map.Entry<String, Material> entrada : catalogo.entrySet()) {
            entrada.getValue().mostrarInfo();
        }
    }

    public void agregarEspera(String codigoMaterial, String usuario) {
        List<String> fila = listaEspera.get(codigoMaterial);
        if (fila == null) {
            fila = new ArrayList<>();
            listaEspera.put(codigoMaterial, fila);
        }
        fila.add(usuario);
    }

    public String siguienteEnEspera(String codigoMaterial) {
        List<String> fila = listaEspera.get(codigoMaterial);
        if (fila == null || fila.isEmpty()) {
            return null;
        }
        return fila.remove(0);
    }

    public boolean registrarMiembro(String usuario) {
        return miembros.add(usuario);
    }

    public boolean tieneMembresia(String usuario) {
        return miembros.contains(usuario);
    }
}

public class Main {

    public static void main(String[] args) {
        SistemaBiblioteca biblioteca = new SistemaBiblioteca();

        registrarMateriales(biblioteca);
        probarBusquedas(biblioteca);
        probarListaDeEspera(biblioteca);
        probarMembresias(biblioteca);

        System.out.println();
        System.out.println("=== Catálogo completo (polimorfismo sin if ni instanceof) ===");
        biblioteca.mostrarCatalogo();
    }

    private static void registrarMateriales(SistemaBiblioteca biblioteca) {
        System.out.println("=== Paso 3: registro de materiales en el HashMap ===");
        biblioteca.registrarMaterial(new Libro("L-001", "Clean Code", 2008, "Robert C. Martin", "978-0132350884"));
        biblioteca.registrarMaterial(new Libro("L-002", "Effective Java", 2018, "Joshua Bloch", "978-0134685991"));
        biblioteca.registrarMaterial(new Revista("R-001", "Scientific American", 2024, 12, "Ciencia"));
        biblioteca.registrarMaterial(new Revista("R-002", "National Geographic", 2025, 3, "Naturaleza"));
        System.out.println("Registrados 2 libros y 2 revistas.");
    }

    private static void probarBusquedas(SistemaBiblioteca biblioteca) {
        System.out.println();
        System.out.println("=== Paso 3: búsquedas O(1) por código ===");

        Material encontrado = biblioteca.buscarMaterial("L-001");
        if (encontrado != null) {
            encontrado.mostrarInfo();
        }

        Material inexistente = biblioteca.buscarMaterial("X-999");
        System.out.println("Buscar X-999 (no existe): " + inexistente);
    }

    private static void probarListaDeEspera(SistemaBiblioteca biblioteca) {
        System.out.println();
        System.out.println("=== Paso 4: lista de espera FIFO con ArrayList ===");

        Material prestado = biblioteca.buscarMaterial("L-001");
        prestado.setDisponible(false);
        prestado.mostrarInfo();

        biblioteca.agregarEspera("L-001", "Ana");
        biblioteca.agregarEspera("L-001", "Luis");
        biblioteca.agregarEspera("L-001", "Marta");
        System.out.println("En espera por L-001: Ana, Luis, Marta (en ese orden de llegada)");

        System.out.println("Siguiente en espera (1a llamada): " + biblioteca.siguienteEnEspera("L-001"));
        System.out.println("Siguiente en espera (2a llamada): " + biblioteca.siguienteEnEspera("L-001"));
    }

    private static void probarMembresias(SistemaBiblioteca biblioteca) {
        System.out.println();
        System.out.println("=== Paso 5: membresías en HashSet ===");

        System.out.println("Registrar a Ana: " + biblioteca.registrarMiembro("Ana"));
        System.out.println("Registrar a Luis: " + biblioteca.registrarMiembro("Luis"));
        System.out.println("Registrar a Sofía: " + biblioteca.registrarMiembro("Sofía"));
        System.out.println("Registrar a Ana otra vez (duplicado): " + biblioteca.registrarMiembro("Ana"));
        System.out.println("Ana tiene membresía: " + biblioteca.tieneMembresia("Ana"));
        System.out.println("Pedro tiene membresía: " + biblioteca.tieneMembresia("Pedro"));
    }
}

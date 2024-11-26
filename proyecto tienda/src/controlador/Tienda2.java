package controlador;

import modelo.Libro;
import modelo.Tienda;
import java.util.List;

public class Tienda2 {
    private Tienda tienda;

    public Tienda2() {
        tienda = new Tienda();
        // Agregar algunos libros de ejemplo a la tienda
        tienda.agregarLibro(new Libro("Java para principiantes", "Juan Pérez", 29.99, 5));
        tienda.agregarLibro(new Libro("Aprendiendo Python", "Ana Gómez", 24.99, 3));
        tienda.agregarLibro(new Libro("Patrones de diseño", "Carlos Fernández", 39.99, 2));
    }

    public List<Libro> obtenerLibros() {
        return tienda.getLibros();
    }

    public Libro buscarLibro(String titulo) {
        return null;
    }

    public void agregarLibro(Libro libro) {
        tienda.agregarLibro(libro);
    }
}


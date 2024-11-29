package controlador;

import java.util.ArrayList;
import java.util.List;

public class tienda {
    private List<libro> libros;

    public tienda() {
        libros = new ArrayList<>();
    }

    public List<libro> getLibros() {
        return libros;
    }

    public void agregarLibro(libro libro) {
        libros.add(libro);
    }

    public void eliminarLibro(String titulo) {
        libros.removeIf(libro -> libro.getTitulo().equalsIgnoreCase(titulo));
    }

    public void editarLibro(String titulo, String nuevoTitulo, String nuevoAutor, double nuevoPrecio, int nuevaCantidad) {
        for (libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!nuevoTitulo.isEmpty()) libro.setTitulo(nuevoTitulo);
                if (!nuevoAutor.isEmpty()) libro.setAutor(nuevoAutor);
                if (nuevoPrecio >= 0) libro.setPrecio(nuevoPrecio);
                if (nuevaCantidad >= 0) libro.setCantidad(nuevaCantidad);
                break;
            }
        }
    }

    public libro buscarLibro(String titulo) {
        for (libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }
}

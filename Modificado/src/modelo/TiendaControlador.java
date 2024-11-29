package modelo;

import controlador.libro;
import controlador.tienda;

import java.util.List;

public class TiendaControlador {
    private tienda tienda;

    public TiendaControlador() {
        tienda = new tienda();
        // Agregar libros iniciales
        tienda.agregarLibro(new libro("Java Básico", "Juan Pérez", 19.99, 10));
        tienda.agregarLibro(new libro("Aprendiendo Python", "Ana Gómez", 24.99, 5));
        tienda.agregarLibro(new libro("Patrones de Diseño", "Carlos López", 29.99, 7));
    }

    public List<libro> obtenerLibros() {
        return tienda.getLibros();
    }

    public void agregarLibro(libro libro) {
        tienda.agregarLibro(libro);
    }

    public void eliminarLibro(String titulo) {
        tienda.eliminarLibro(titulo);
    }

    public void editarLibro(String titulo, String nuevoTitulo, String nuevoAutor, double nuevoPrecio, int nuevaCantidad) {
        tienda.editarLibro(titulo, nuevoTitulo, nuevoAutor, nuevoPrecio, nuevaCantidad);
    }

    public libro buscarLibro(String titulo) {
        return tienda.buscarLibro(titulo);
    }

}

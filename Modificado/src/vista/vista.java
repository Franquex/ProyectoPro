package vista;

import controlador.libro;
import modelo.TiendaControlador;

import java.util.List;
import java.util.Scanner;

public class vista {
    private TiendaControlador controlador;

    public vista() {
        controlador = new TiendaControlador();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n*** Tienda de Libros ***");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Agregar libro");
            System.out.println("4. Eliminar libro");
            System.out.println("5. Editar libro");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    mostrarLibros();
                    break;
                case 2:
                    buscarLibro(scanner);
                    break;
                case 3:
                    agregarLibro(scanner);
                    break;
                case 4:
                    eliminarLibro(scanner);
                    break;
                case 5:
                    editarLibro(scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private void mostrarLibros() {
        List<libro> libros = controlador.obtenerLibros();
        System.out.println("\nLibros disponibles:");
        for (libro libro : libros) {
            System.out.println(libro);
        }
    }

    private void buscarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        libro libro = controlador.buscarLibro(titulo);
        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("No se encontró un libro con ese título.");
        }
    }

    private void agregarLibro(Scanner scanner) {
        System.out.print("Ingrese el título: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        controlador.agregarLibro(new libro(titulo, autor, precio, cantidad));
        System.out.println("Libro agregado exitosamente.");
    }

    private void eliminarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro a eliminar: ");
        String titulo = scanner.nextLine();
        controlador.eliminarLibro(titulo);
        System.out.println("Si el libro existía, fue eliminado.");
    }

    private void editarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro a editar: ");
        String titulo = scanner.nextLine();
        System.out.print("Nuevo título (deje vacío para no cambiar): ");
        String nuevoTitulo = scanner.nextLine();
        System.out.print("Nuevo autor (deje vacío para no cambiar): ");
        String nuevoAutor = scanner.nextLine();
        System.out.print("Nuevo precio (-1 para no cambiar): ");
        double nuevoPrecio = scanner.nextDouble();
        System.out.print("Nueva cantidad (-1 para no cambiar): ");
        int nuevaCantidad = scanner.nextInt();
        scanner.nextLine();

        controlador.editarLibro(
                titulo,
                nuevoTitulo.isEmpty() ? titulo : nuevoTitulo,
                nuevoAutor.isEmpty() ? null : nuevoAutor,
                nuevoPrecio < 0 ? -1 : nuevoPrecio,
                nuevaCantidad < 0 ? -1 : nuevaCantidad
        );

        System.out.println("Libro actualizado correctamente.");
    }
}

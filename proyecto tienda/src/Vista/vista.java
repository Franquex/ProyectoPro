package Vista;
import controlador.Tienda2;
import modelo.Libro;
import java.util.List;
import java.util.Scanner;

public class vista {
    private Tienda2 controlador;

    public vista() {
        controlador = new Tienda2();
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        while (opcion != 4) {
            System.out.println("\n*** Tienda de Libros ***");
            System.out.println("1. Ver todos los libros");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Agregar libro (solo administrador)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

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
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void mostrarLibros() {
        List<Libro> libros = controlador.obtenerLibros();
        System.out.println("\nLibros disponibles:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    private void buscarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del libro: ");
        String titulo = scanner.nextLine();
        Libro libro = controlador.buscarLibro(titulo);

        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("El libro no se encuentra disponible.");
        }
    }

    private void agregarLibro(Scanner scanner) {
        System.out.print("Ingrese el título del nuevo libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el precio: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad disponible: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        controlador.agregarLibro(new Libro(titulo, autor, precio, cantidad));
        System.out.println("Libro agregado correctamente.");
    }
}

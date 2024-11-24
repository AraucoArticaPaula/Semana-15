package registro;

import java.util.Scanner;

public class SistemaRegistro {

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        GestionLenguaje gestionLenguaje = new GestionLenguaje();

        while (true) {
            System.out.printf("""
        1. Agregar Lenguaje
        2. Buscar Lenguaje
        3. Eliminar Lenguaje
        4. Imprimir Lenguajes
        5. Salir
        """);
            System.out.print("Selecciona una opcion: ");
            int opcion = lector.nextInt();
            lector.nextLine();
            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = lector.nextLine();
                    System.out.print("Año de Creacion: ");
                    int anioCreacion = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Caracteristica Principal: ");
                    String caracteristica = lector.nextLine();
                    System.out.print("Utilizacion: ");
                    String utilizacion = lector.nextLine();
                    gestionLenguaje.agregarLenguaje(anioCreacion, caracteristica, nombre, utilizacion);
                    break;
                case 2:
                    System.out.print("Nombre del Lenguaje a Buscar: ");
                    String buscarNombre = lector.nextLine();
                    LenguajeProgramacion lenguaje = gestionLenguaje.buscarLenguaje(buscarNombre);
                    if (lenguaje != null) {
                        System.out.println(lenguaje);
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Nombre del Lenguaje a Eliminar: ");
                    String eliminarNombre = lector.nextLine();
                    boolean eliminado = gestionLenguaje.eliminarLenguaje(eliminarNombre);
                    if (eliminado) {
                        System.out.println("Lenguaje eliminado.");
                    } else {
                        System.out.println("Lenguaje no encontrado.");
                    }
                    break;
                case 4:
                    gestionLenguaje.imprimirLenguajes();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    lector.close();
                    return;
                default:
                    System.out.println("Opcion no valida.");
            }
        }
    }
}

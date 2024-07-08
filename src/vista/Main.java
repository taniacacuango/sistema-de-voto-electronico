package Vista;

import controlador.VotanteController;
import java.util.Scanner;
import modelo.Votante;

public class Main {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            VotanteController votanteController = new VotanteController(); // Controlador para el votante
            Votante votanteIngresado = null; // Votante que ha iniciado sesión
            
            do {
                System.out.println("|-----------------------------------------------------------------------------------------------------------|");
                System.out.println("|                                       SISTEMA DE VOTO ELECTRÓNICO                                         |");
                System.out.println("|-----------------------------------------------------------------------------------------------------------|");
                System.out.println("|                         Bienvenido(a) al Sistema de Voto Electrónico                                      |");
                System.out.println("|-----------------------------------------------------------------------------------------------------------|");
                System.out.println("| Seleccione una opción:                                                                                    |");
                System.out.println("|                                                                                                           |");
                System.out.println("| 1. Iniciar sesión como votante                                                                            |");
                System.out.println("| 2. Ver resultados                                                                                         |");
                System.out.println("| 3. Salir                                                                                                  |");
                System.out.println("|-----------------------------------------------------------------------------------------------------------|");
                System.out.println("");
                System.out.print("Ingrese su opción: ");
                opcion = scanner.nextInt();
                
                switch (opcion) {
                    case 1:
                        if (votanteIngresado == null) {
                            System.out.print("Ingrese su ID de votante: ");
                            int idVotante = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer
                            
                            System.out.print("Ingrese su clave de votante: ");
                            String claveVotante = scanner.nextLine();
                            
                            votanteIngresado = votanteController.loginVotante(idVotante, claveVotante);
                            
                            if (votanteIngresado != null) {
                                System.out.println("Inicio de sesión exitoso como votante.");
                                // Mostrar menú del votante utilizando la clase MenuVotante
                                MenuVotante menuVotante = new MenuVotante(votanteController, scanner);
                                menuVotante.mostrarMenu(votanteIngresado);
                            } else {
                                System.out.println("Credenciales incorrectas. Por favor, inténtelo de nuevo.");
                            }
                        } else {
                            System.out.println("Ya has iniciado sesión como votante.");
                        }
                        break;
                    case 2:
                        System.out.println("Mostrando resultados...");
                        // Aquí iría la lógica para mostrar los resultados de la votación
                        // Por ejemplo: resultados.mostrarResultados();
                        break;
                    case 3:
                        System.out.println("¡Gracias por usar el Sistema de Voto Electrónico!");
                        break;
                    default:
                        System.out.println("""
                                           Opción inválida. Por favor, seleccione una opción válida." + "\n"
                                           """);
                        break;
                }
            } while (opcion != 3);
        }
    }
}

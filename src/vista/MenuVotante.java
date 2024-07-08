
package Vista;

import controlador.VotanteController;
import java.util.Scanner;
import modelo.Votante;

public class MenuVotante {

    private VotanteController votanteController;
    private Scanner scanner;

    public MenuVotante(VotanteController votanteController, Scanner scanner) {
        this.votanteController = votanteController;
        this.scanner = scanner;
    }

    public void mostrarMenu(Votante votante) {
        int opcion;
        do {
            System.out.println("|-----------------------------------------------------------------------------------------------------------|");
            System.out.println("|                                         MENÚ DEL VOTANTE                                                 |");
            System.out.println("|-----------------------------------------------------------------------------------------------------------|");
            System.out.println("| Selecciona una opción:                                                                                    |");
            System.out.println("|                                                                                                           |");
            System.out.println("| 1. Votar                                                                                                  |");
            System.out.println("| 2. Ver mi información                                                                                     |");
            System.out.println("| 3. Cerrar sesión                                                                                          |");
            System.out.println("|-----------------------------------------------------------------------------------------------------------|");
            System.out.println("");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Aquí iría la lógica para votar
                    // Ejemplo: votar(votante);
                    System.out.println("¡Gracias por votar!");
                    break;
                case 2:
                    // Aquí iría la lógica para ver la información del votante
                    // Ejemplo: mostrarInformacionVotante(votante);
                    System.out.println("Mostrando información del votante...");
                    break;
                case 3:
                    System.out.println("Cerrando sesión del votante.");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida." + "\n");
            }
        } while (opcion != 3);
    }
}

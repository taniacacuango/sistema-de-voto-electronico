/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;
//TODOS LAS IMPORTACIONES DE CLASES Y DEMAS//

import controlador.AdministradorControlador;
import controlador.ConexionBDD;

import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import modelo.CandidatoModelo;
import modelo.UsuariosModelo;
import modelo.VotosModelo;



public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static AdministradorControlador adminControlador = new AdministradorControlador();

    public static void main(String[] args) {
        ConexionBDD conexion = new ConexionBDD();
        conexion.conectar();

        int rol;
        do {
            System.out.println("INGRESE SU ROL(1: Administrador, 2: Usuario): ");
            rol = scanner.nextInt();
            scanner.nextLine();

            switch (rol) {
                case 1:
                    System.out.println("INGRESE SU CONTRASEÑA");
                    String contrasena = scanner.nextLine();
                    if (adminControlador.validarAdministrador("1050246329", contrasena)) { 
                        menuAdministrador(scanner);
                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }
                    break;
                case 2:
                    System.out.println("INGRESE SU CEDULA");
                    String cedulaUsuario = scanner.nextLine();
                    System.out.println("INGRESE SU CONTRASEÑA");
                    String contrasenaUsuario = scanner.nextLine();
                    if (adminControlador.validarUsuario(cedulaUsuario, contrasenaUsuario)) {
                        System.out.println("AUTENTIFICACION EXITOSA, !!BIENBENIDO!!");
                        menuUsuario(scanner, cedulaUsuario); // Pasar cédula al menú
                    } else {
                        System.out.println("Credenciales incorrectas.");
                    }
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (rol < 1 || rol > 2);

        conexion.cerrarConexion();
        scanner.close();
    }  

    private static void menuAdministrador(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Agregar candidato");
            System.out.println("2. Eliminar candidato");
            System.out.println("3. Registrar usuario votante");
            System.out.println("4. Eliminar usuario votante");
            System.out.println("5. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarCandidato(scanner);
                    break;
                case 2:
                    eliminarCandidato(scanner);
                    break;
                case 3:
                    registrarUsuario(scanner);
                    break;
                case 4:
                    eliminarUsuario(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 5);    
    }

    private static void agregarCandidato(Scanner scanner) {
        System.out.println("Ingrese nombres del candidato:");
        String nombres = scanner.nextLine();
        System.out.println("Ingrese apellidos del candidato:");
        String apellidos = scanner.nextLine();

        CandidatoModelo candidato = new CandidatoModelo(nombres, apellidos);
        adminControlador.agregarCandidato(candidato);
        System.out.println("Candidato agregado exitosamente.");
    }
    
    private static void eliminarCandidato(Scanner scanner) {
        System.out.println("Ingrese el ID del candidato a eliminar:");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        adminControlador.eliminarCandidato(id);
        System.out.println("Candidato eliminado exitosamente.");
    }

    private static void registrarUsuario(Scanner scanner) {
        System.out.println("Ingrese cédula del usuario:");
        String cedula = scanner.nextLine();
        System.out.println("Ingrese nombres del usuario:");
        String nombres = scanner.nextLine();
        System.out.println("Ingrese apellidos del usuario:");
        String apellidos = scanner.nextLine();

        UsuariosModelo usuario = new UsuariosModelo();
        usuario.setPer_cedula(cedula);
        usuario.setPer_nombres(nombres);
        usuario.setPer_apellidos(apellidos);
        usuario.setPer_contraseña(cedula); // Contraseña igual a la cédula

        adminControlador.registrarUsuario(usuario);
        System.out.println("Usuario votante registrado exitosamente.");
    }

    private static void eliminarUsuario(Scanner scanner) {
        System.out.println("Ingrese la cédula del usuario a eliminar:");
        String cedula = scanner.nextLine();

        try {
            adminControlador.eliminarUsuario(cedula);
            System.out.println("Usuario votante eliminado exitosamente.");
        } catch (Exception e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    private static void menuUsuario(Scanner scanner, String userCedula) {
        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Ver candidatos");
            System.out.println("2. Votar");
            System.out.println("3. Ver resultados de votos");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    verCandidatos();
                    break;
                case 2:
                    votar(scanner, userCedula);
                    break;
                case 3:
                    verResultados();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
        } while (opcion != 4);
    }

    private static void verCandidatos() {
        System.out.println("Lista de candidatos:");
        for (CandidatoModelo candidato : adminControlador.obtenerCandidatos()) {
            System.out.println("ID: " + candidato.getCandId() + ", Nombre: " + candidato.getCandNombres() + " " + candidato.getCandApellidos());
        }
    }

    private static void verResultados() {
        System.out.println("Resultados de las votaciones:");
        for (Map.Entry<CandidatoModelo, Integer> entry : adminControlador.obtenerResultados().entrySet()) {
            CandidatoModelo candidato = entry.getKey();
            Integer votos = entry.getValue();
            System.out.println("Candidato: " + candidato.getCandNombres() + " " + candidato.getCandApellidos() + ", Votos: " + votos);
        }
    }

    private static void votar(Scanner scanner, String userCedula) {
        System.out.println("Ingrese el ID del candidato por el que desea votar:");
        int candId = scanner.nextInt();
        scanner.nextLine();

        VotosModelo voto = new VotosModelo(candId, userCedula); 
        if (adminControlador.registrarVoto(voto)) {
            System.out.println("Voto registrado exitosamente.");
        } else {
            System.out.println("Error al registrar el voto.");
        }
    }
}
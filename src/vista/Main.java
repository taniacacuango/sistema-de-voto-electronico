
package vista;

import controlador.AdministradorControlador;
import controlador.CandidatoControlador;
import controlador.ConexionBDD;
import controlador.PersonaControlador;
import controlador.ResultadosControlador;
import controlador.VotanteControlador;
import modelo.CandidatoModelo;
import modelo.VotosModelo;
import java.util.Map;
import java.util.Scanner;
import modelo.PersonaModelo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import modelo.AdministradorModelo;
import modelo.VotanteModelo;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    private static final AdministradorControlador adminControlador = new AdministradorControlador();
    
    public static void main(String[] args) {
        ConexionBDD conexion = new ConexionBDD();
        conexion.conectar();

        autenticarUsuario(scanner);

        conexion.cerrarConexion();
    }

    private static void autenticarUsuario(Scanner scanner) {
        boolean autenticado = false;

        while (!autenticado) {
            System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺");
            System.out.println("🌺    ＢＩＥＮＢＥＮＩＶＯ ＡＬ ＳＩＳＴＥＭＡ ＤＥ ＶＯＴＯＳ ＥＬＥＣＴＲＯＮＩＣＯＳ     🌺");
            System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺");
            System.out.println("*Ingrese nombre de usuario:                                                  *");
            String usuario = scanner.nextLine(); 
            System.out.println("*Ingrese la contraseña del usuario:                                          *");
            String contrasena = scanner.nextLine();
            System.out.println("*----------------------------------------------------------------------------*"); 
           
            AdministradorControlador administradorControlador = new AdministradorControlador();
            VotanteControlador votanteControlador = new VotanteControlador();

            Map<String, String> userInfo = administradorControlador.validarAdministrador(usuario, contrasena);
            if (userInfo == null) {
                userInfo = votanteControlador.validarVotante(usuario, contrasena);
            }

            if (userInfo != null) {
                autenticado = true;
                System.out.println("USTED SE HA IDENTIFICADO COMO " + userInfo.get("rol"));
                System.out.println("Nombre: " + userInfo.get("nombres") + " " + userInfo.get("apellidos"));
                System.out.println("Cédula: " + userInfo.get("cedula"));
            System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺"); 
                if (userInfo.get("rol").equals("Administrador")) {
                    menuAdministrador(scanner);
                } else {
                    menuVotante(scanner);
                }
            } else {
                System.out.println("Autenticación fallida. ¿Desea intentarlo de nuevo? (Sí=1 / No=2)");
                int opcion = scanner.nextInt();
                scanner.nextLine();
                if (opcion == 2) {
                    System.out.println("Saliendo...");
                    break;
                }
            }
        }
    }
    
    private static void menuAdministrador(Scanner scanner) {
        int opcion;
        do {

            System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺");
            System.out.println("🌺 Seleccione una opción:             🌺");
            System.out.println("🌺1. Agregar candidato                🌺");
            System.out.println("🌺2. Registrar  votante               🌺");
            System.out.println("🌺3. Agregar Admnistrador             🌺");
            System.out.println("🌺4. Eliminar Admnistrador            🌺");
            System.out.println("🌺5. Salir                            🌺");
            System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarCandidato(scanner);
                    
                    break;
                case 2:
                    registrarVotante(scanner);
                    
                    break;
                case 3:
                    registrarAdministrador(scanner);
                    
                    break;
                case 4:
                    eliminaradmnistrador(scanner);
                    
                    break;
                case 5:
                    System.out.println("Saliendo al Menu...");
                   
                    return;
                default:
                    System.out.println("Opción inválida, intente nuevamente.");
            }
                         
        } while (opcion != 5);

    }
    
    private static void agregarCandidato(Scanner scanner) {
        
    CandidatoControlador candidatoControlador = new CandidatoControlador();
    PersonaControlador personaControlador = new PersonaControlador();
    System.out.println("--------------------------------------------------------");
    System.out.println("--Ingrese la cédula del candidato:                  --");
    String cedula = scanner.nextLine();

    PersonaModelo persona = new PersonaModelo();
    persona.setPer_cedula(cedula);

    System.out.println("--Ingrese nombres de la persona:                    --");
    persona.setPer_nombres(scanner.nextLine());

    System.out.println("--Ingrese apellidos de la persona:                  --");
    persona.setPer_apellidos(scanner.nextLine());

    System.out.println("--Ingrese fecha de nacimiento (YYYY-MM-DD):         --");
    String fechaNacimiento = scanner.nextLine();
    try {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date sqlDate = new Date(sdf.parse(fechaNacimiento).getTime());
        persona.setPer_fecha_nacimiento(sqlDate);
    } catch (ParseException e) {
        System.out.println("Error al parsear la fecha: " + e.getMessage());
        return;
    }
    
    System.out.println("--Ingrese dirección de la persona:                  --");
    persona.setPer_direccion(scanner.nextLine());

    System.out.println("--Ingrese teléfono de la persona:                   --");
    persona.setPer_telefono(scanner.nextLine());

    System.out.println("--Ingrese correo electrónico de la persona:         --");
    persona.setPer_email(scanner.nextLine());

    personaControlador.registrarPersona(persona);
    System.out.println("--Persona registrada exitosamente.                  --");

    CandidatoModelo candidato = new CandidatoModelo();
    candidato.setPer_cedula(cedula);

    System.out.println("--Ingrese el partido político del candidato:        --");
    String partido = scanner.nextLine();
    candidato.setPartido_politico(partido);

    candidatoControlador.agregarCandidato(candidato);
    System.out.println("--Candidato agregado exitosamente.                  --");
    
    System.out.println("--------------------------------------------------------");     
}
    
    private static void registrarVotante(Scanner scanner) {
    try {
       
        System.out.println("-------------------------------------------------");  
        System.out.println("-- Ingrese cédula del votante:                 --");
        String cedula = scanner.nextLine();

        System.out.println("--Ingrese nombres del votante:                 --");
        String nombres = scanner.nextLine();

        System.out.println("--Ingrese apellidos del votante:               --");
        String apellidos = scanner.nextLine();

        System.out.println("--Ingrese fecha de nacimiento (YYYY-MM-DD):    --");
        String fechaNacimiento = scanner.nextLine();

        System.out.println("--Ingrese dirección del votante:               --");
        String direccion = scanner.nextLine();

        System.out.println("--Ingrese teléfono del votante:                --");
        String telefono = scanner.nextLine();

        System.out.println("--Ingrese correo electrónico del votante:      --");
        String email = scanner.nextLine();

        System.out.println("--Ingrese nombre de usuario:                   --");
        String usuario = scanner.nextLine();

        System.out.println("--Ingrese la contraseña del votante:           --");
        String contrasena = scanner.nextLine();
        
        System.out.println("-------------------------------------------------");  
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(fechaNacimiento);
        Date sqlDate = new Date(utilDate.getTime());

        
        PersonaControlador personaControlador = new PersonaControlador();
        PersonaModelo persona = new PersonaModelo();
        persona.setPer_cedula(cedula);
        persona.setPer_nombres(nombres);
        persona.setPer_apellidos(apellidos);
        persona.setPer_fecha_nacimiento(sqlDate);
        persona.setPer_direccion(direccion);
        persona.setPer_telefono(telefono);
        persona.setPer_email(email);
        persona.setPer_usuario(usuario);
        persona.setPer_password(contrasena);

        personaControlador.registrarPersona(persona);

      
        VotanteModelo votante = new VotanteModelo();
        votante.setPer_cedula(cedula);

        VotanteControlador votanteControlador = new VotanteControlador();
        if (votanteControlador.registrarVotante(votante)) {
            System.out.println("Votante registrado exitosamente.");
        } else {
            System.out.println("Error al registrar votante.");
        }
    } catch (ParseException e) {
        System.out.println("Error fecha incorrecta: " + e.getMessage());
    }
}
    
    private static void registrarAdministrador(Scanner scanner) {
    try {        
        
    System.out.println("--------------------------------------------------------");  
        System.out.println(" --Ingrese cédula del usuario:                  --");
        String cedula = scanner.nextLine();

        System.out.println(" --Ingrese nombres del usuario:                 --");
        String nombres = scanner.nextLine();
        
        System.out.println(" --Ingrese apellidos del usuario:               --");
        String apellidos = scanner.nextLine();
        
        System.out.println(" --Ingrese fecha de nacimiento (YYYY-MM-DD):    --");
        String fechaNacimiento = scanner.nextLine();
        
        System.out.println(" --Ingrese dirección del usuario:               --");
        String direccion = scanner.nextLine();
        
        System.out.println(" --Ingrese teléfono del usuario:                --");
        String telefono = scanner.nextLine();
        
        System.out.println(" --Ingrese correo electrónico:                  --");
        String email = scanner.nextLine();
        
        System.out.println(" --Ingrese nombre de usuario:                   --");
        String usuario = scanner.nextLine();

        System.out.println(" --Ingrese la contraseña del usuario:           --");
        String contrasena = scanner.nextLine();
        
        System.out.println("----------------------------------------------------");  
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = sdf.parse(fechaNacimiento);
        Date sqlDate = new Date(utilDate.getTime());

       PersonaControlador personaControlador = new PersonaControlador();
        PersonaModelo persona = new PersonaModelo();
        persona.setPer_cedula(cedula);
        persona.setPer_nombres(nombres);
        persona.setPer_apellidos(apellidos);
        persona.setPer_fecha_nacimiento(sqlDate);
        persona.setPer_direccion(direccion);
        persona.setPer_telefono(telefono);
        persona.setPer_email(email);
        persona.setPer_usuario(usuario);
        persona.setPer_password(contrasena);
        
        personaControlador.registrarPersona(persona);

         AdministradorModelo administrador = new AdministradorModelo();
        administrador.setPerCedula(cedula);

        AdministradorControlador administradorControlador = new AdministradorControlador();
        administradorControlador.registrarAdministrador(administrador);

        System.out.println("Administrador registrado exitosamente.");
    } catch (ParseException e) {
        System.out.println("Error fecha incorrecta: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Error al registrar usuario: " + e.getMessage());
    }
}
        
    private static void eliminaradmnistrador(Scanner scanner) {
    AdministradorControlador administradorControlador = new AdministradorControlador();
    System.out.println("----------------------------------------------------------------");
    System.out.println("Ingrese la cédula del administrador a eliminar:");
    String cedula = scanner.nextLine();
    System.out.println("----------------------------------------------------------------");
    try {
        boolean eliminado = administradorControlador.eliminarAdministradorPorCedula(cedula);
        if (eliminado) {
            System.out.println("Administrador eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un administrador con la cédula proporcionada.");
        }
    } catch (Exception e) {
        System.out.println("Error al eliminar administrador: " + e.getMessage());
    }
}
   
    private static void menuVotante(Scanner scanner) {
    int opcion;
    do {
        
        System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺");
        System.out.println("🌺Seleccione una opción:                  🌺");
        System.out.println("🌺1. Ver listado de candidatos y votar    🌺");
        System.out.println("🌺2. Ver porcentaje de resultados de votos🌺");
        System.out.println("🌺3. Salir                                🌺");
        System.out.println("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺");
        opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                verCandidatos(scanner);
                break;
            case 2:
                verResultados();
                break;
            case 3:
                System.out.println("Saliendo...");
                return;
            default:
                System.out.println("Opción inválida, intente nuevamente.");
        }
    } while (opcion != 3);
}

    private static void verCandidatos(Scanner scanner) {
    CandidatoControlador candidatoControlador = new CandidatoControlador();
    System.out.println("----------------------------------------------------");
    System.out.println("Lista de candidatos:");
    List<CandidatoModelo> candidatos = candidatoControlador.obtenerCandidatos();

    for (CandidatoModelo candidato : candidatos) {
        System.out.println("ID: " + candidato.getCand_id() +
                           ", Nombre: " + candidato.getPer_nombres() + " " + candidato.getPer_apellidos() +
                           ", Partido: " + candidato.getPartido_politico());
    }

    System.out.println("\n¿Desea votar por algún candidato? (Sí=1 / No=2)");
    int opcion = scanner.nextInt();
    scanner.nextLine();
    System.out.println("----------------------------------------------------");
    if (opcion == 1) {
        votar(scanner);
    } else if (opcion != 2) {
        System.out.println("Opción inválida, regresando al menú.");
    }
}

    private static void votar(Scanner scanner) {
    System.out.println("----------------------------------------------------------");
    System.out.println(" --Ingrese su cédula:                                  --");
    String userCedula = scanner.nextLine();

    System.out.println(" --Ingrese el ID del candidato por el que desea votar: --");
    int candId = scanner.nextInt();
    scanner.nextLine();
    System.out.println("---------------------------------------------------------");
    VotosModelo voto = new VotosModelo();
    voto.setVoto_cand_id(candId);
    voto.setVoto_cedula(userCedula);

    VotanteControlador votanteControlador = new VotanteControlador();
    if (votanteControlador.registrarVoto(voto)) {
        System.out.println("Voto registrado exitosamente.");
    } else {
        System.out.println("Error al registrar el voto.");
    }
}

    private static void verResultados() {
    ResultadosControlador resultadosControlador = new ResultadosControlador();
    Map<CandidatoModelo, Integer> resultados = resultadosControlador.obtenerResultados();

    int totalVotos = resultados.values().stream().mapToInt(Integer::intValue).sum();
    System.out.println("----------------------------------------------------");
    System.out.println("Resultados de las votaciones:");
    for (Map.Entry<CandidatoModelo, Integer> entry : resultados.entrySet()) {
        CandidatoModelo candidato = entry.getKey();
        int votos = entry.getValue();
        double porcentaje = totalVotos > 0 ? (votos / (double) totalVotos) * 100 : 0;

        System.out.println("Candidato: " + candidato.getPer_nombres() + " " + candidato.getPer_apellidos() +
                           ", Partido: " + candidato.getPartido_politico() + 
                           ", Votos: " + votos + 
                           ", Porcentaje: " + String.format("%.2f", porcentaje) + "%");
    }
    System.out.println("----------------------------------------------------");
}

}


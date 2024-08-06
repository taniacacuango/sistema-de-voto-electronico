/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import modelo.AdministradorModelo;
import modelo.PersonaModelo;

public class AdministradorControlador {
    private ConexionBDD conexion;
    private Connection conectado;

    public AdministradorControlador() {
        conexion = new ConexionBDD();
        conectado = conexion.conectar();
    }
    
    public boolean registrarAdministrador(AdministradorModelo administrador) {
    String sql = "INSERT INTO administrador (Per_Cedula) VALUES (?)";
    try (PreparedStatement pstmt = conectado.prepareStatement(sql)) {
        pstmt.setString(1, administrador.getPerCedula());
        int filasInsertadas = pstmt.executeUpdate();
        return filasInsertadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar administrador: " + e.getMessage());
        return false;
    }
}

    public Map<String, String> validarAdministrador(String usuario, String contrasena) {
    String sql = "SELECT persona.Per_Cedula, persona.Per_Nombres, persona.Per_Apellidos " +
                 "FROM persona " +
                 "JOIN administrador ON persona.Per_Cedula = administrador.Per_Cedula " +
                 "WHERE persona.Per_Usuario = ? AND persona.Per_Password = ?";
    try (PreparedStatement pstmt = conectado.prepareStatement(sql)) {
        pstmt.setString(1, usuario);
        pstmt.setString(2, contrasena);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("rol", "Administrador");
            userInfo.put("cedula", rs.getString("Per_Cedula"));
            userInfo.put("nombres", rs.getString("Per_Nombres"));
            userInfo.put("apellidos", rs.getString("Per_Apellidos"));
            return userInfo;
        }
    } catch (SQLException e) {
        System.out.println("Error al validar administrador: " + e.getMessage());
    }
    return null;
}

    public boolean eliminarAdministradorPorCedula(String cedula) {
    String eliminarAdministradorSql = "DELETE FROM administrador WHERE Per_Cedula = ?";
    String eliminarPersonaSql = "DELETE FROM persona WHERE Per_Cedula = ?";
    
    try {
        try (PreparedStatement statement = conectado.prepareStatement(eliminarAdministradorSql)) {
            statement.setString(1, cedula);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No se encontró un administrador con la cédula proporcionada.");
                return false;
            }
        }       
        try (PreparedStatement statement = conectado.prepareStatement(eliminarPersonaSql)) {
            statement.setString(1, cedula);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No se encontró una persona con la cédula proporcionada.");
                return false;
            }
        }        
        return true;
        
    } catch (SQLException e) {
        System.out.println("Error al eliminar administrador: " + e.getMessage());
        return false;
    }
}
}

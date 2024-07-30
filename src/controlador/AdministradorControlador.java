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

    // Método para registrar un administrador
    public boolean registrarAdministrador(AdministradorModelo administrador) {
        String sql = "INSERT INTO administradores (Per_Cedula) VALUES (?)";
        try (PreparedStatement pstmt = conectado.prepareStatement(sql)) {
            pstmt.setString(1, administrador.getPerCedula());
            int filasInsertadas = pstmt.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar administrador: " + e.getMessage());
            return false;
        }
    }

    // Método para validar un administrador
    public Map<String, String> validarAdministrador(String usuario, String contrasena) {
        String sql = "SELECT personas.Per_Cedula, personas.Per_Nombres, personas.Per_Apellidos " +
                     "FROM personas " +
                     "JOIN administradores ON personas.Per_Cedula = administradores.Per_Cedula " +
                     "WHERE personas.Per_Usuario = ? AND personas.Per_Password = ?";
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

    // Método para eliminar un usuario
    public void eliminarUsuario(String cedula) {
        String sql = "DELETE FROM personas WHERE Per_Cedula = ?";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    
}

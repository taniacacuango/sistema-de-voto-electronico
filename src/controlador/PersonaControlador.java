/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.PersonaModelo;


public class PersonaControlador {
        private ConexionBDD conexion;
    private Connection conectado;
    
        public PersonaControlador() {
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }    
        public boolean registrarPersona(PersonaModelo persona) {
        String sql = "INSERT INTO Persona (Per_Cedula, Per_Nombres, Per_Apellidos, Per_FechaNacimiento, Per_Direccion, Per_Telefono, Per_Email, Per_Usuario, Per_Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, persona.getPer_cedula());
            stmt.setString(2, persona.getPer_nombres());
            stmt.setString(3, persona.getPer_apellidos());
            stmt.setDate(4, persona.getPer_fecha_nacimiento());
            stmt.setString(5, persona.getPer_direccion());
            stmt.setString(6, persona.getPer_telefono());
            stmt.setString(7, persona.getPer_email());
            stmt.setString(8, persona.getPer_usuario());
            stmt.setString(9, persona.getPer_password());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar persona: " + e.getMessage());
            return false;
        }
    }
         public boolean personaExiste(String cedula) {
        String sql = "SELECT * FROM persona WHERE Per_Cedula = ?";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); 
        } catch (SQLException e) {
            System.out.println("Error al verificar persona: " + e.getMessage());
            return false;
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.CandidatoModelo;

public class CandidatoControlador {
    private ConexionBDD conexion;
    private Connection conectado;

    public CandidatoControlador() {
        conexion = new ConexionBDD();
        conectado = conexion.conectar();
    }

    public void agregarCandidato(CandidatoModelo candidato) {
        String sql = "INSERT INTO candidatos (Per_Cedula, Partido_Politico) VALUES (?, ?)";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, candidato.getPer_cedula()); 
            stmt.setString(2, candidato.getPartido_politico()); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al agregar candidato: " + e.getMessage());
        }
    }

public List<CandidatoModelo> obtenerCandidatos() {
    List<CandidatoModelo> candidatos = new ArrayList<>();
    String sql = "SELECT c.Cand_id, p.Per_Nombres, p.Per_Apellidos, c.Partido_Politico " +
                 "FROM candidatos c " +
                 "JOIN personas p ON c.Per_Cedula = p.Per_Cedula"; // Cambiado de 'persona' a 'personas'
    try (PreparedStatement stmt = conectado.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
            CandidatoModelo candidato = new CandidatoModelo();
            candidato.setCand_id(rs.getInt("Cand_id"));
            candidato.setPer_nombres(rs.getString("Per_Nombres"));
            candidato.setPer_apellidos(rs.getString("Per_Apellidos"));
            candidato.setPartido_politico(rs.getString("Partido_Politico"));
            candidatos.add(candidato);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener candidatos: " + e.getMessage());
    }
    return candidatos;
}


    public boolean eliminarCandidatoPorCedula(String cedula) {
        String sql = "DELETE FROM candidatos WHERE Per_Cedula = ?";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            int filasEliminadas = stmt.executeUpdate();
            return filasEliminadas > 0; 
        } catch (SQLException e) {
            System.out.println("Error al eliminar candidato: " + e.getMessage());
            return false;
        }
    }
}

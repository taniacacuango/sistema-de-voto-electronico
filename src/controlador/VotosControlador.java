/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.VotosModelo;

/**
 *
 * @author alext
 */
public class VotosControlador {
        private ConexionBDD conexion;
    private Connection conectado;
    
        public VotosControlador() {
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }    
        
        
      public boolean registrarVoto(VotosModelo voto) {
    String sql = "INSERT INTO votos (Voto_Cand_id, Voto_Cedula) VALUES (?, ?)";
    try (PreparedStatement pstmt = conectado.prepareStatement(sql)) {
        pstmt.setInt(1, voto.getVoto_cand_id());
        pstmt.setString(2, voto.getVoto_cedula());
        int filasInsertadas = pstmt.executeUpdate();
        return filasInsertadas > 0;
    } catch (SQLException e) {
        System.out.println("Error al registrar el voto: " + e.getMessage());
        return false;
    }
}
        public int obtenerVotosPorCandidato(int candId) {
        int totalVotos = 0;
        String sql = "SELECT Total_Votos FROM resultados WHERE Cand_id = ?";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setInt(1, candId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                totalVotos = rs.getInt("Total_Votos");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener votos por candidato: " + e.getMessage());
        }
        return totalVotos;
    }
}

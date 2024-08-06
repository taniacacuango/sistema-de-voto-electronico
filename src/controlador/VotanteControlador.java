/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.VotanteModelo;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import modelo.VotosModelo;

public class VotanteControlador {
    private ConexionBDD conexion;
    private Connection conectado;

    public VotanteControlador(){
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }
    
    public boolean registrarVotante(VotanteModelo votante) {
        String sql = "INSERT INTO Votante (Vot_id, Per_Cedula) VALUES (?, ?)";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, votante.getVotante_cedula());
            stmt.setString(2, votante.getPer_cedula());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar votante: " + e.getMessage());
            return false;
        }
    }

    public Map<String, String> validarVotante(String usuario, String contrasena) {
    String sql = "SELECT persona.Per_Cedula, persona.Per_Nombres, persona.Per_Apellidos " +
                 "FROM persona " +
                 "JOIN votante ON persona.Per_Cedula = votante.Per_Cedula " +
                 "WHERE persona.Per_Usuario = ? AND persona.Per_Password = ?";
    try (PreparedStatement pstmt = conectado.prepareStatement(sql)) {
        pstmt.setString(1, usuario);
        pstmt.setString(2, contrasena);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            Map<String, String> userInfo = new HashMap<>();
            userInfo.put("rol", "Votante");
            userInfo.put("cedula", rs.getString("Per_Cedula"));
            userInfo.put("nombres", rs.getString("Per_Nombres"));
            userInfo.put("apellidos", rs.getString("Per_Apellidos"));
            return userInfo;
        }
    } catch (SQLException e) {
        System.out.println("Error al validar votante: " + e.getMessage());
    }
    return null;
}

    public boolean registrarVoto(VotosModelo voto) {
        String sql = "INSERT INTO votos (Voto_Cand_id, Voto_Cedula) VALUES (?, ?)";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setInt(1, voto.getVoto_cand_id());
            stmt.setString(2, voto.getVoto_cedula());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar el voto: " + e.getMessage());
            return false;
        }
    }
}

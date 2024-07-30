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
import modelo.VotanteModelo;
import modelo.VotosModelo;

public class VotanteControlador {
    private ConexionBDD conexion;
    private Connection conectado;

    public VotanteControlador(){
        conexion = new ConexionBDD();
        conectado = conexion.conectar();
    }
    
    public boolean registrarVotante(VotanteModelo votante) {
        String sql = "INSERT INTO votantes (Per_Cedula) VALUES (?)";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, votante.getPer_cedula());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Error al registrar votante: " + e.getMessage());
            return false;
        }
    }

    public void eliminarVotantePorCedula(String cedula) {
        String sql = "DELETE FROM votantes WHERE Per_Cedula = ?";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, cedula);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error al eliminar votante: " + e.getMessage());
        }
    }

    public Map<String, String> validarVotante(String usuario, String contrasena) {
        String sql = "SELECT personas.Per_Cedula, personas.Per_Nombres, personas.Per_Apellidos " +
                     "FROM personas " +
                     "JOIN votantes ON personas.Per_Cedula = votantes.Per_Cedula " +
                     "WHERE personas.Per_Usuario = ? AND personas.Per_Password = ?";
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;



import modelo.AdministradorModelo;
import modelo.CandidatoModelo;
import modelo.UsuariosModelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import modelo.VotosModelo;


public class AdministradorControlador {
    private ConexionBDD conexion;
    private Connection conectado;

    public AdministradorControlador() {
        conexion = new ConexionBDD();
        conectado = conexion.conectar();
    }

    public boolean validarAdministrador(String cedula, String contrasena) {
        String query = "SELECT * FROM Administrador JOIN Persona ON Admin_Cedula = Per_Cedula WHERE Per_Cedula = ? AND Per_Contraseña = ?";
        try (PreparedStatement statement = conectado.prepareStatement(query)) {
            statement.setString(1, cedula);
            statement.setString(2, contrasena);
            ResultSet resultSet = statement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.out.println("Error al validar administrador: " + e.getMessage());
            return false;
        }
    }

    public void agregarCandidato(CandidatoModelo candidato) {
        String sql = "INSERT INTO Candidato (Cand_Nombres, Cand_Apellidos) VALUES (?, ?)";
        try (PreparedStatement stmt = conectado.prepareStatement(sql)) {
            stmt.setString(1, candidato.getCandNombres());
            stmt.setString(2, candidato.getCandApellidos());
            stmt.executeUpdate();
            System.out.println("Candidato agregado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al agregar candidato: " + e.getMessage());
        }
    }

    public void eliminarCandidato(int candId) {
        String query = "DELETE FROM Candidato WHERE Cand_id = ?";
        try (PreparedStatement statement = conectado.prepareStatement(query)) {
            statement.setInt(1, candId);
            statement.executeUpdate();
            System.out.println("Candidato eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar candidato: " + e.getMessage());
        }
    }

    public void registrarUsuario(UsuariosModelo usuario) {
        String queryPersona = "INSERT INTO Persona (Per_Cedula, Per_Nombres, Per_Apellidos, Per_Contraseña) VALUES (?, ?, ?, ?)";
        String queryUsuario = "INSERT INTO Usuarios (User_Cedula) VALUES (?)";

        try (PreparedStatement statementPersona = conectado.prepareStatement(queryPersona);
             PreparedStatement statementUsuario = conectado.prepareStatement(queryUsuario)) {

            statementPersona.setString(1, usuario.getPer_cedula());
            statementPersona.setString(2, usuario.getPer_nombres());
            statementPersona.setString(3, usuario.getPer_apellidos());
            statementPersona.setString(4, usuario.getPer_contraseña());
            statementPersona.executeUpdate();

            statementUsuario.setString(1, usuario.getPer_cedula());
            statementUsuario.executeUpdate();
            System.out.println("Usuario votante registrado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
        }
    }

    public void eliminarUsuario(String cedula) {
        String deleteAdminSql = "DELETE FROM Administrador WHERE Admin_Cedula = ?";
        String deleteUserSql = "DELETE FROM Usuarios WHERE User_Cedula = ?";
        String deletePersonaSql = "DELETE FROM Persona WHERE Per_Cedula = ?";

        try (PreparedStatement deleteAdminStmt = conectado.prepareStatement(deleteAdminSql);
             PreparedStatement deleteUserStmt = conectado.prepareStatement(deleteUserSql);
             PreparedStatement deletePersonaStmt = conectado.prepareStatement(deletePersonaSql)) {

            deleteAdminStmt.setString(1, cedula);
            deleteAdminStmt.executeUpdate();

            deleteUserStmt.setString(1, cedula);
            deleteUserStmt.executeUpdate();

            deletePersonaStmt.setString(1, cedula);
            deletePersonaStmt.executeUpdate();

            System.out.println("Usuario votante eliminado exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al eliminar usuario: " + e.getMessage());
        }
    }

    public boolean validarUsuario(String cedula, String contrasena) {
        String sql = "SELECT * FROM Persona WHERE Per_Cedula = ? AND Per_Contraseña = ?";
        try (PreparedStatement ps = conectado.prepareStatement(sql)) {
            ps.setString(1, cedula);
            ps.setString(2, contrasena);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Error al validar usuario: " + e.getMessage());
            return false;
        }
    }

    public List<CandidatoModelo> obtenerCandidatos() {
        List<CandidatoModelo> listaCandidatos = new ArrayList<>();
        String sql = "SELECT * FROM Candidato";
        try (PreparedStatement ps = conectado.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CandidatoModelo candidato = new CandidatoModelo(
                        rs.getInt("Cand_id"),
                        rs.getString("Cand_Nombres"),
                        rs.getString("Cand_Apellidos")
                );
                listaCandidatos.add(candidato);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener candidatos: " + e.getMessage());
        }
        return listaCandidatos;
    }

    public boolean registrarVoto(VotosModelo voto) {
    String sql = "INSERT INTO Votos (Cand_id, Per_Cedula) VALUES (?, ?)";
    try (PreparedStatement ps = conectado.prepareStatement(sql)) {
        ps.setInt(1, voto.getVotoCandidateId()); 
        ps.setString(2, voto.getVotoCedula()); 
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Error al registrar voto: " + e.getMessage());
        return false;
    }
}


    public Map<CandidatoModelo, Integer> obtenerResultados() {
        Map<CandidatoModelo, Integer> resultados = new HashMap<>();
        String sql = "SELECT candidato.Cand_id, candidato.Cand_Nombres, candidato.Cand_Apellidos, COUNT(votos.Cand_id) AS votos " +
                     "FROM candidato LEFT JOIN votos ON candidato.Cand_id = votos.Cand_id " +
                     "GROUP BY candidato.Cand_id";

        try (PreparedStatement ps = conectado.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CandidatoModelo candidato = new CandidatoModelo(
                        rs.getInt("Cand_id"),
                        rs.getString("Cand_Nombres"),
                        rs.getString("Cand_Apellidos")
                );
                int votos = rs.getInt("votos");
                resultados.put(candidato, votos);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener resultados: " + e.getMessage());
        }
        return resultados;
    }
}
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
import modelo.CandidatoModelo;

public class ResultadosControlador {
    private ConexionBDD conexion;
    private Connection conectado;

    public ResultadosControlador(){
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }

  public Map<CandidatoModelo, Integer> obtenerResultados() {
    String sql = "SELECT candidato.Cand_id, persona.Per_Nombres, persona.Per_Apellidos, candidato.Partido_Politico, " +
                 "COALESCE(COUNT(votos.Voto_id), 0) AS Total_Votos " +
                 "FROM candidato " +
                 "LEFT JOIN persona ON candidato.Per_Cedula = persona.Per_Cedula " +
                 "LEFT JOIN votos ON candidato.Cand_id = votos.Voto_Cand_id " +
                 "GROUP BY candidato.Cand_id, persona.Per_Nombres, persona.Per_Apellidos, candidato.Partido_Politico";
    
    Map<CandidatoModelo, Integer> resultados = new HashMap<>();
    try (PreparedStatement pstmt = conectado.prepareStatement(sql)) {
        ResultSet rs = pstmt.executeQuery();

        while (rs.next()) {
            CandidatoModelo candidato = new CandidatoModelo();
            candidato.setCand_id(rs.getInt("Cand_id"));
            candidato.setPer_nombres(rs.getString("Per_Nombres"));
            candidato.setPer_apellidos(rs.getString("Per_Apellidos"));
            candidato.setPartido_politico(rs.getString("Partido_Politico"));
            
            int totalVotos = rs.getInt("Total_Votos");
            resultados.put(candidato, totalVotos);
        }
    } catch (SQLException e) {
        System.out.println("Error al obtener resultados: " + e.getMessage());
    }
    return resultados;
  }
}



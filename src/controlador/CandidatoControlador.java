/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.sun.jdi.connect.spi.Connection;
import java.util.ArrayList;
import java.util.List;
import modelo.CandidatoModelo;
import modelo.ResultadosModelo;
import modelo.VotosModelo;

/**
 *
 * @author alext
 */
public class CandidatoControlador {
        private ConexionBDD conexion;
    private Connection conectado;
    
    public CandidatoControlador(){
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }    
    private static List<CandidatoModelo> candidatos = new ArrayList<>();
    private static List<VotosModelo> votos = new ArrayList<>();
    private static List<ResultadosModelo> resultados = new ArrayList<>();

    static {
        inicializarCandidatos();
    }

    private static void inicializarCandidatos() {
        CandidatoModelo candidato1 = new CandidatoModelo();
        candidato1.setCandId(1);
        candidato1.setCandNombres("Candidato A");
        candidatos.add(candidato1);
        
        CandidatoModelo candidato2 = new CandidatoModelo();
        candidato2.setCandId(2);
        candidato2.setCandNombres("Candidato B");
        candidatos.add(candidato2);
    }

    public static List<CandidatoModelo> getCandidatos() {
        return candidatos;
    }

    public static List<VotosModelo> getVotos() {
        return votos;
    }

    public static List<ResultadosModelo> getResultados() {
        return resultados;
    }

    public static void registrarVoto(int candidatoId) {
        VotosModelo voto = new VotosModelo();
        voto.setVoto_candidate_id(candidatoId);
        votos.add(voto);

        // Actualizar resultados
        actualizarResultados(candidatoId);
    }

    private static void actualizarResultados(int candidatoId) {
        for (ResultadosModelo resultado : resultados) {
            if (resultado.getCand_id() == candidatoId) {
                resultado.setTotal_Votos(resultado.getTotal_Votos() + 1);
                return;
            }
        }
        
        ResultadosModelo nuevoResultado = new ResultadosModelo();
        nuevoResultado.setCand_id(candidatoId);
        nuevoResultado.setTotal_Votos(1);
        resultados.add(nuevoResultado);
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.CandidatoControlador;

import com.sun.jdi.connect.spi.Connection;
import java.util.List;
import modelo.CandidatoModelo;
import modelo.ResultadosModelo;
import modelo.VotosModelo;

/**
 *
 * @author alext
 */
public class ResultadosControlador {
        private ConexionBDD conexion;
    private Connection conectado;
    
        public ResultadosControlador(){
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }    
    public static void verPorcentajeVotos() {
        List<CandidatoModelo> candidatos = CandidatoControlador.getCandidatos();
        List<ResultadosModelo> resultados = CandidatoControlador.getResultados();
        List<VotosModelo> votos = CandidatoControlador.getVotos();

        if (votos.isEmpty()) {
            System.out.println("No hay votos registrados.");
            return;
        }

        for (CandidatoModelo candidato : candidatos) {
            long totalVotos = resultados.stream()
                    .filter(r -> r.getCand_id() == candidato.getCandId())
                    .mapToInt(ResultadosModelo::getTotal_Votos)
                    .sum();

            double porcentaje = (totalVotos / (double) votos.size()) * 100;
            System.out.printf("Candidato: %s - Porcentaje de votos: %.2f%%%n", 
                              candidato.getCandNombres(), 
                              porcentaje);
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class ResultadosModelo {
    private int Resultado_id;
    private int Cand_id;
    private int Total_Votos;

    public ResultadosModelo() {
    }

    public int getResultado_id() {
        return Resultado_id;
    }

    public void setResultado_id(int resultado_id) {
        this.Resultado_id = resultado_id;
    }

    public int getCand_id() {
        return Cand_id;
    }

    public void setCand_id(int cand_id) {
        this.Cand_id = cand_id;
    }

    public int getTotal_Votos() {
        return Total_Votos;
    }

    public void setTotal_Votos(int total_votos) {
        this.Total_Votos = total_votos;
    }

    @Override
    public String toString() {
        return "ResultadosModelo{" +
                "Resultado_id=" + Resultado_id +
                ", Cand_id=" + Cand_id +
                ", Total_Votos=" + Total_Votos +
                '}';
    }
}


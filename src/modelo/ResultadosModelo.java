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
    private int resultado_id;
    private int cand_id;
    private int total_votos;

    public ResultadosModelo() {
    }

    public int getResultado_id() {
        return resultado_id;
    }

    public void setResultado_id(int resultado_id) {
        this.resultado_id = resultado_id;
    }

    public int getCand_id() {
        return cand_id;
    }

    public void setCand_id(int cand_id) {
        this.cand_id = cand_id;
    }

    public int getTotal_votos() {
        return total_votos;
    }

    public void setTotal_votos(int total_votos) {
        this.total_votos = total_votos;
    }

    @Override
    public String toString() {
        return "ResultadosModelo{" +
                "resultado_id=" + resultado_id +
                ", cand_id=" + cand_id +
                ", total_votos=" + total_votos +
                '}';
    }
}




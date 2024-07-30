/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class CandidatoModelo extends PersonaModelo {
    private int cand_id;
    private String partido_politico;

    public CandidatoModelo() {
    }

    public int getCand_id() {
        return cand_id;
    }

    public void setCand_id(int cand_id) {
        this.cand_id = cand_id;
    }

    public String getPartido_politico() {
        return partido_politico;
    }

    public void setPartido_politico(String partido_politico) {
        this.partido_politico = partido_politico;
    }

    @Override
    public String toString() {
        return "CandidatoModelo{" +
                "cand_id=" + cand_id +
                ", partido_politico='" + partido_politico + '\'' +
                "} " + super.toString();
    }
}

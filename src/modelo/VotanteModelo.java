/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class VotanteModelo extends PersonaModelo {
    private String votante_cedula;

    public VotanteModelo() {
    }

    public String getVotante_cedula() {
        return votante_cedula;
    }

    public void setVotante_cedula(String votante_cedula) {
        this.votante_cedula = votante_cedula;
    }

    @Override
    public String toString() {
        return "VotanteModelo{" +
                "votante_cedula='" + votante_cedula + '\'' +
                "} " + super.toString();
    }
}

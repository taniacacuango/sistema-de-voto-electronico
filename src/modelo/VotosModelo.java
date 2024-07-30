/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class VotosModelo {
    private int voto_id;
    private int voto_cand_id;
    private String voto_cedula;

    public VotosModelo() {
    }

    public VotosModelo(int voto_cand_id, String voto_cedula) {
        this.voto_cand_id = voto_cand_id;
        this.voto_cedula = voto_cedula;
    }

    public int getVoto_id() {
        return voto_id;
    }

    public void setVoto_id(int voto_id) {
        this.voto_id = voto_id;
    }

    public int getVoto_cand_id() {
        return voto_cand_id;
    }

    public void setVoto_cand_id(int voto_cand_id) {
        this.voto_cand_id = voto_cand_id;
    }

    public String getVoto_cedula() {
        return voto_cedula;
    }

    public void setVoto_cedula(String voto_cedula) {
        this.voto_cedula = voto_cedula;
    }

    @Override
    public String toString() {
        return "VotosModelo{" +
                "voto_id=" + voto_id +
                ", voto_cand_id=" + voto_cand_id +
                ", voto_cedula='" + voto_cedula + '\'' +
                '}';
    }
}


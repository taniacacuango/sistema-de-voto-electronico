/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class CandidatoModelo {
    private int candId;
    private String candNombres;
    private String candApellidos;

    public CandidatoModelo(String candNombres, String candApellidos) {
        this.candNombres = candNombres;
        this.candApellidos = candApellidos;
    }

    public CandidatoModelo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public CandidatoModelo(int aInt, String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getCandId() {
        return candId;
    }

    public void setCandId(int candId) {
        this.candId = candId;
    }

    public String getCandNombres() {
        return candNombres;
    }

    public void setCandNombres(String candNombres) {
        this.candNombres = candNombres;
    }

    public String getCandApellidos() {
        return candApellidos;
    }

    public void setCandApellidos(String candApellidos) {
        this.candApellidos = candApellidos;
    }

    @Override
    public String toString() {
        return "CandidatoModelo{" +
                "candId=" + candId +
                ", candNombres='" + candNombres + '\'' +
                ", candApellidos='" + candApellidos + '\'' +
                '}';
    }
}

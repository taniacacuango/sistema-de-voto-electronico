/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Candidato extends Persona {
    private int votosRecibidos;

    public Candidato(int id, String nombre, int edad, String direccion, String telefono) {
        super(id, nombre, edad, direccion, telefono);
        this.votosRecibidos = 0;
    }

    public int getVotosRecibidos() {
        return votosRecibidos;
    }

    public void setVotosRecibidos(int votosRecibidos) {
        this.votosRecibidos = votosRecibidos;
    }

    public void incrementarVotos() {
        this.votosRecibidos++;
    }
}

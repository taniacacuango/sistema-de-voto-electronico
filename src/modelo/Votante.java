/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author User
 */
public class Votante extends Persona{
    private boolean votoRealizado;

    public Votante(int id, String nombre, int edad, String direccion, String telefono) {
        super(id, nombre, edad, direccion, telefono);
        this.votoRealizado = false;
    }

    public boolean isVotoRealizado() {
        return votoRealizado;
    }

    public void setVotoRealizado(boolean votoRealizado) {
        this.votoRealizado = votoRealizado;
    }

    public void realizarVoto() {
        this.votoRealizado = true;
        System.out.println("Voto registrado correctamente.");
    }

    public void cancelarVoto() {
        this.votoRealizado = false;
        System.out.println("Voto cancelado.");
    }
}

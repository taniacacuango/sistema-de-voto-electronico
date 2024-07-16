/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class AdministradorModelo extends PersonaModelo{
    private String Admin_cedula;

    public AdministradorModelo() {
    }

    public String getAdmin_cedula() {
        return Admin_cedula;
    }

    public void setAdmin_cedula(String Admin_cedula) {
        this.Admin_cedula = Admin_cedula;
    }


    @Override
    public String toString() {
        return "AdministradorModelo{" +
                "Admin_cedula='" + Admin_cedula + '\'' +
                '}';
    }
}

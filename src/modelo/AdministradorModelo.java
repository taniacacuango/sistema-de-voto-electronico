/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class AdministradorModelo extends PersonaModelo {
    private String adminId;
    private String perCedula;

    public AdministradorModelo() {
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getPerCedula() {
        return perCedula;
    }

    public void setPerCedula(String perCedula) {
        this.perCedula = perCedula;
    }

    @Override
    public String toString() {
        return "AdministradorModelo{" +
                "adminId='" + adminId + '\'' +
                ", perCedula='" + perCedula + '\'' +
                "} " + super.toString();
    }
}

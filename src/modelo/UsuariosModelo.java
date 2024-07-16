/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author alext
 */
public class UsuariosModelo extends PersonaModelo {
    private String User_cedula;

    public UsuariosModelo() {
    }

    public String getUser_cedula() {
        return User_cedula;
    }

    public void setUser_cedula(String user_cedula) {
        this.User_cedula = user_cedula;
    }

    @Override
    public String toString() {
        return "UsuarioModelo{" +
                "User_cedula='" + User_cedula + '\'' +
                '}';
    }
}

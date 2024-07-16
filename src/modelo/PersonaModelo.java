package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author alext
 */
public class PersonaModelo {
    private String Per_cedula;
    private String Per_nombres;
    private String Per_apellidos;
    private String Per_contraseña;
  
    public PersonaModelo (){
    }

    public String getPer_cedula() {
        return Per_cedula;
    }

    public void setPer_cedula(String Per_cedula) {
        this.Per_cedula = Per_cedula;
    }

    public String getPer_nombres() {
        return Per_nombres;
    }

    public void setPer_nombres(String Per_nombres) {
        this.Per_nombres = Per_nombres;
    }

    public String getPer_apellidos() {
        return Per_apellidos;
    }

    public void setPer_apellidos(String Per_apellidos) {
        this.Per_apellidos = Per_apellidos;
    }

    public String getPer_contraseña() {
        return Per_contraseña;
    }

    public void setPer_contraseña(String Per_contraseña) {
        this.Per_contraseña = Per_contraseña;
    }
    @Override
    public String toString() {
        return "PersonaModelo{" +
                "Per_cedula='" + Per_cedula + '\'' +
                ", Per_nombres='" + Per_nombres + '\'' +
                ", Per_apellidos='" + Per_apellidos + '\'' +
                ", Per_contraseña='" + Per_contraseña + '\'' +
                '}';
    }
}

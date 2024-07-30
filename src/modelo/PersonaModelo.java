package modelo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author alext
 */
import java.sql.Date;

public class PersonaModelo {
    private String per_cedula;
    private String per_nombres;
    private String per_apellidos;
    private Date per_fecha_nacimiento;
    private String per_direccion;
    private String per_telefono;
    private String per_email;
    private String per_usuario;
    private String per_password;
  
    public PersonaModelo() {
    }

    public String getPer_cedula() {
        return per_cedula;
    }

    public void setPer_cedula(String per_cedula) {
        this.per_cedula = per_cedula;
    }

    public String getPer_nombres() {
        return per_nombres;
    }

    public void setPer_nombres(String per_nombres) {
        this.per_nombres = per_nombres;
    }

    public String getPer_apellidos() {
        return per_apellidos;
    }

    public void setPer_apellidos(String per_apellidos) {
        this.per_apellidos = per_apellidos;
    }

    public Date getPer_fecha_nacimiento() {
        return per_fecha_nacimiento;
    }

    public void setPer_fecha_nacimiento(Date per_fecha_nacimiento) {
        this.per_fecha_nacimiento = per_fecha_nacimiento;
    }

    public String getPer_direccion() {
        return per_direccion;
    }

    public void setPer_direccion(String per_direccion) {
        this.per_direccion = per_direccion;
    }

    public String getPer_telefono() {
        return per_telefono;
    }

    public void setPer_telefono(String per_telefono) {
        this.per_telefono = per_telefono;
    }

    public String getPer_email() {
        return per_email;
    }

    public void setPer_email(String per_email) {
        this.per_email = per_email;
    }

    public String getPer_usuario() {
        return per_usuario;
    }

    public void setPer_usuario(String per_usuario) {
        this.per_usuario = per_usuario;
    }

    public String getPer_password() {
        return per_password;
    }

    public void setPer_password(String per_password) {
        this.per_password = per_password;
    }

    @Override
    public String toString() {
        return "PersonaModelo{" +
                "per_cedula='" + per_cedula + '\'' +
                ", per_nombres='" + per_nombres + '\'' +
                ", per_apellidos='" + per_apellidos + '\'' +
                ", per_fecha_nacimiento='" + per_fecha_nacimiento + '\'' +
                ", per_direccion='" + per_direccion + '\'' +
                ", per_telefono='" + per_telefono + '\'' +
                ", per_email='" + per_email + '\'' +
                ", per_usuario='" + per_usuario + '\'' +
                ", per_password='" + per_password + '\'' +
                '}';
    }
}
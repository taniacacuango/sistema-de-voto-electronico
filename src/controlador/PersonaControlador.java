/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;


import com.sun.jdi.connect.spi.Connection;

/**
 *
 * @author alext
 */
public class PersonaControlador {
        private ConexionBDD conexion;
    private Connection conectado;
    
        public PersonaControlador() {
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }    
}

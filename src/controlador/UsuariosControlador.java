/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import com.sun.jdi.connect.spi.Connection;
import java.util.Scanner;

/**
 *
 * @author alext
 */
public class UsuariosControlador {
    private ConexionBDD conexion;
    private Connection conectado;
    
        public UsuariosControlador() {
        conexion = new ConexionBDD();
        conectado = (Connection) conexion.conectar();
    }    
    public static void usuarioMenu(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}

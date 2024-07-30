/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author alext
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDD {
java.sql.Connection conexion;
    public java.sql.Connection conectar(){
         
        try {
           
            Class.forName("com.mysql.jdbc.Driver");
            
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/Voto_Electronico?autoReconnect=true&useSSL=false","root","T@nia125");
           /* System.out.println("CONECTADO"); */
        } catch (ClassNotFoundException | SQLException e)
        {
             System.out.println("NO SE CONECTO ");
        }
        return conexion;
    }
    public void cerrarConexion(){
        try {
            if(conexion !=null && !conexion.isClosed()){
            conexion.close();
                System.out.println("CONEXION CERRADA");
            }
        } catch (SQLException e) {
            System.out.println("");
        }
    }

    
}


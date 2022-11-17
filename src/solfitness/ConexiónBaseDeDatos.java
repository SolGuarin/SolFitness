/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solfitness;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Usuario
 */
public class ConexiónBaseDeDatos {
    public static void main(String[] args) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/solfitnnesbd";
        Connection connection;
        
        try{
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url, user, password);
            if (connection != null){
                System.out.println("Conexión exitosa");
            }
            
            
        }catch(Exception e){
            System.out.println("Error en la conexión" + e.getMessage());
        // TODO code application logic here
    }   
}
    

}

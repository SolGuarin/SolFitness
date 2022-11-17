/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.clsEmpleado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


/**
 *
 * @author Usuario
 */
public class modelEmpleado {
    DatosBd datosBd;

    public modelEmpleado() {
        this.datosBd = new DatosBd();
    }
    
    public boolean createEmpleado(clsEmpleado empleado){
        
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
            String query = "INSERT INTO tb_empleado (Id, nombre, apellido, cargo, documentoIdentidad, correoElectronico) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statementEmpleado = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementEmpleado.setString(1, empleado.getId());
            statementEmpleado.setString(2, empleado.getNombre());
            statementEmpleado.setString(3, empleado.getApellido());
            statementEmpleado.setString(4, empleado.getCargo());
            statementEmpleado.setString(5, empleado.getDocumentoIdentidad());
            statementEmpleado.setString(6, empleado.getCorreoElectronico());
            int rowsInserted = statementEmpleado.executeUpdate();
            if(rowsInserted > 0){
                return true;
            }
            return false;
        }
        catch (SQLException e){

        }
        return false;
    }

    public boolean updateEmpleado(clsEmpleado empleado){
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
            String queryEmpleado = "UPDATE tb_empleado SET nombre = ?, apellido = ?, cargo = ?, documentoIdentidad = ?, correoElectronico = ? WHERE Id = ?";
            PreparedStatement statementEmpleado = conn.prepareStatement(queryEmpleado);
          
            statementEmpleado.setString(1, empleado.getNombre());
            statementEmpleado.setString(2, empleado.getApellido());
            statementEmpleado.setString(3, empleado.getCargo());
            statementEmpleado.setString(4, empleado.getDocumentoIdentidad());
            statementEmpleado.setString(5, empleado.getCorreoElectronico());
            statementEmpleado.setString(6, empleado.getId());
            int rowsInserted = statementEmpleado.executeUpdate();
            System.out.println("rowsInserted" + rowsInserted);
            System.out.println(statementEmpleado.toString());
            if(rowsInserted > 0){
                return true;
            }
            return false;
        }
        catch (SQLException e){
            System.out.println(e.toString());
            return false;
        }

    } 

    public boolean deleteEmpleado(clsEmpleado empleado){
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
        conn.setAutoCommit(false);
        Savepoint savePoint = conn.setSavepoint("DeletePoint");
        try{
            String queryEmpleado = "DELETE FROM tb_empleado WHERE id = ? ";
            PreparedStatement statementEmpleado = conn.prepareStatement(queryEmpleado);
            statementEmpleado.setString(1, empleado.getId());
            int rowsUpdateEmpleado = statementEmpleado.executeUpdate();
            conn.commit();
            System.out.println(statementEmpleado.toString());
            
            return rowsUpdateEmpleado > 0;    
        }catch (Exception e){
            System.out.println(e.toString());
           conn.rollback(savePoint);
        } 
        }catch(SQLException e){
            System.out.println(e.toString());
            return false;
        }
        return false;
    }
    
    public clsEmpleado selectEmpleado(String id){
        clsEmpleado empleado = null;
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
            String query = "SELECT * FROM tb_empleado WHERE id = ?";
            PreparedStatement statementEmpleado = conn.prepareStatement(query);
            statementEmpleado.setString(1, id);
            ResultSet result = statementEmpleado.executeQuery();
            while (result.next()){
                String idEmpleado = result.getString(1);
                String nombreEmpleado = result.getString(2);
                String apellidoEmpleado = result.getString(3);
                String correoElectronicoEmpleado = result.getString(4);
                String cargoEmpleado = result.getString(5);
                String documentoIdentidadEmpleado = result.getString(6);
                empleado = new clsEmpleado(cargoEmpleado, id, nombreEmpleado, apellidoEmpleado, documentoIdentidadEmpleado, correoElectronicoEmpleado);
                return empleado;
            }
       
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return empleado;
}
    
}

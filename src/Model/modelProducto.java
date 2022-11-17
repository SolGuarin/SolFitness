/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.clsProducto;
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
public class modelProducto {
    DatosBd datosBd;

    public modelProducto() {
        this.datosBd = new DatosBd();
    }
    
    public boolean createProducto(clsProducto producto){
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
            String query = "INSERT INTO tb_producto (referencia, nombre, talla, color, precio) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statementProducto = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statementProducto.setString(1, producto.getReferencia());
            statementProducto.setString(2, producto.getNombre());
            statementProducto.setString(3, producto.getTalla());
            statementProducto.setString(4, producto.getColor());
            statementProducto.setInt(5, producto.getPrecio());
            int rowsInserted = statementProducto.executeUpdate();
            if(rowsInserted > 0){
                return true;
            }
            return false;
        } 
        
        catch (SQLException e){
            
        }
        return false;
    }

    public boolean updateProducto(clsProducto producto){
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
            String queryProducto = "UPDATE tb_producto SET nombre = ?, talla = ?, color =?, precio =? WHERE referencia = ?";
            PreparedStatement statementProducto = conn.prepareStatement(queryProducto);
            statementProducto.setString(1, producto.getNombre());
            statementProducto.setString(2, producto.getTalla());
            statementProducto.setString(3, producto.getColor());
            statementProducto.setInt(4, producto.getPrecio());
            statementProducto.setString(5, producto.getReferencia());
            int rowsInserted = statementProducto.executeUpdate();
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

    public boolean deleteProducto(clsProducto producto){
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
        conn.setAutoCommit(false);
        Savepoint savePoint = conn.setSavepoint("DeletePoint");
        try{
            String queryProducto = "DELETE FROM tb_producto WHERE referencia = ? ";
            PreparedStatement statementProducto = conn.prepareStatement(queryProducto);
            statementProducto.setString(1, producto.getReferencia());
            int rowsUpdateProducto = statementProducto.executeUpdate();
            conn.commit();
            System.out.println(statementProducto.toString());
            
            return rowsUpdateProducto > 0;    
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
    
    public clsProducto selectProducto(String referencia){
        clsProducto producto = null;
        try(Connection conn = DriverManager.getConnection(datosBd.getUrl(), datosBd.getUser(), datosBd.getPassword())){
            String query = "SELECT * FROM tb_producto WHERE referencia = ?";
            PreparedStatement statementProducto = conn.prepareStatement(query);
            statementProducto.setString(1, referencia);
            ResultSet result = statementProducto.executeQuery();
            System.out.println(result);
            while (result.next()){
                System.out.println(result.getString(2));
                String referenciaProducto = result.getString(1);
                String nombreProducto = result.getString(2);
                String tallaProducto = result.getString(3);
                String colorProducto = result.getString(4);
                int precioProducto = result.getInt(5);
                producto = new clsProducto(referencia, nombreProducto, tallaProducto, colorProducto, precioProducto);
                return producto;
            }
            
        } catch (SQLException e){
        }
        return producto;
}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.clsProducto;
import Model.modelProducto;

/**
 *
 * @author Usuario
 */
public class ctlProducto {
    
    private modelProducto modelProducto;

    public ctlProducto() {
        this.modelProducto = new modelProducto();
    }
    
    
    public boolean createProducto(clsProducto producto){
        try{
            return this.modelProducto.createProducto(producto);
        }
        catch (Exception e){
            
        }
        return false;
    }

    public boolean updateProducto(clsProducto producto){
        try{
            return this.modelProducto.updateProducto(producto);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    } 

    public boolean deleteProducto(clsProducto producto){
        try{
            return this.modelProducto.deleteProducto(producto);
        }
        catch (Exception e){
            System.out.println(e.toString());
          return false;  
        }
        
    }
    
    public clsProducto selectProducto(String referencia){
        clsProducto producto = null;
        try{
            producto = this.modelProducto.selectProducto(referencia);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return producto;
    }
}

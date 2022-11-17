/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.clsEmpleado;
import Model.modelEmpleado;

/**
 *
 * @author Usuario
 */
public class ctlEmpleado {
    
    private modelEmpleado modelEmpleado;

    public ctlEmpleado() {
        this.modelEmpleado = new modelEmpleado();
    }
    
    public boolean createEmpleado(clsEmpleado empleado){
        try{
            this.modelEmpleado.createEmpleado(empleado);
        }
        catch (Exception e){
            System.out.println("Hay un error");
            throw e;
        }
        return false;
    }
    
    public boolean updateEmpleado(clsEmpleado empleado){
        try{
           return this.modelEmpleado.updateEmpleado(empleado);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
    
    public boolean deleteEmpleado(clsEmpleado empleado){
        try{
            return this.modelEmpleado.deleteEmpleado(empleado);
        }
        catch (Exception e){
            System.out.println(e.toString());
            return false;      
        }     
    }
    
    public clsEmpleado selectEmpleado(String id){
        clsEmpleado empleado = null;
        try{
            empleado = this.modelEmpleado.selectEmpleado(id);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return empleado;
    }
}

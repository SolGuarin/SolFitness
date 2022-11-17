/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Usuario
 */
public class clsEmpleado extends clsPersona {
    private String cargo;

    /**
     * @return the cargo
     */
    


    public clsEmpleado(String cargo, String id, String nombre, String apellido, String documentoIdentidad, String correoElectronico) {
        super(id, nombre, apellido, documentoIdentidad, correoElectronico);
        this.cargo = cargo;
    }
    
        public clsEmpleado(String id) {
            super(id);
    }
    


    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    public void printAllAttributes(){
     
        System.out.println(
                "Cargo: " + this.getCargo() + "\nid: " + this.getId() + "\nNombre: " + this.getNombre() + "\nApellido: " + this.getApellido() + "\nDocumento de identidad: " + this.getDocumentoIdentidad() + " \nCorreo electrónico: " + this.getCorreoElectronico());

    }
    
}

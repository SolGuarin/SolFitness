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
public class clsCliente extends clsPersona {
    private String direccion;
    private String telefono;

    /**
     * @return the direccion
     */
    
    

    public clsCliente(String direccion, String telefono, String id, String nombre, String apellido, String documentoIdentidad, String correoElectronico) {
        super(id, nombre, apellido, documentoIdentidad, correoElectronico);
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}

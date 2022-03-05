/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

public class Cliente {
    private final String dni;
    private final String apelidosenome;
    private String email;
    private String direccion;
    private String telefono;
    
    public Cliente(String dni,String apelidosnome,String email,String direccion,String telefono) {
        this.dni=dni;
        this.apelidosenome=apelidosnome;
        this.email=email;
        this.direccion=direccion;
        this.telefono=telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getApelidosenome() {
        return apelidosenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}

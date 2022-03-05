/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @author xavi
 */
public class Producto {
    private final String codigo;
    private final String descricion;
    
    public Producto(String codigo,String descricion) {
        this.codigo=codigo;
        this.descricion=descricion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricion() {
        return descricion;
    }
}

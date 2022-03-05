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
public class Material {
    private final String code;
    private final String descricion;
    private double prezo;
    
    public Material(String code,String descricion,double prezo) {
        // Validar Code
        this.code=code;
        this.descricion=descricion;
        this.prezo=prezo;
    }

    public String getCode() {
        return code;
    }

    public String getDescricion() {
        return descricion;
    }

    public double getPrezo() {
        return prezo;
    }

    public void setPrezo(double prezo) {
        this.prezo = prezo;
    }
    
    
    
}

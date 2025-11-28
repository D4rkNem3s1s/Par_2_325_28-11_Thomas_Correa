/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.Model;

import java.io.Serializable;

public class Butaca implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private final String identificador; 
    
    private boolean estaOcupada; 

    public Butaca(String id) {
        this.identificador = id; 
        this.estaOcupada = false;
    }

    public String getIdentificador() {
        return identificador;
    }
    
    public boolean getEstaOcupada() {
        return estaOcupada;
    }

    public void setEstaOcupada(boolean ocupada) {
        this.estaOcupada = ocupada;
    }

}

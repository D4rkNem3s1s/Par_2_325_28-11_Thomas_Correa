/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.Model;

import java.io.Serializable;


public class Entrada implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String identificadorButaca; 
    
    private String nombrePelicula;
    
    public Entrada(String identificadorButaca, String nombrePelicula) {
        this.identificadorButaca = identificadorButaca;
        this.nombrePelicula = nombrePelicula;
    }

    public String getIdentificadorButaca() {
        return identificadorButaca;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setIdentificadorButaca(String identificadorButaca) {
        this.identificadorButaca = identificadorButaca;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }
}
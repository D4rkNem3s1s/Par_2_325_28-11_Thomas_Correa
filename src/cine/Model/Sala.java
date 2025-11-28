/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable{
    private static final long serialVersionUID = 1L;

    private String pelicula; 
    private int numeroSala;

    private final Butaca[][] butacas; 
    private final int filas;
    private final int columnas;

    public Sala(String nombrePelicula, int numFilas, int numColumnas) {
        this.pelicula = nombrePelicula;
        this.filas = numFilas;
        this.columnas = numColumnas;
        this.butacas = new Butaca[numFilas][numColumnas];
        inicializarButacas();
    }
    
    private void inicializarButacas() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String id = (char)('A' + i) + String.valueOf(j + 1);
                this.butacas[i][j] = new Butaca(id); 
            }
        }
    }

    public String getPelicula() {
        return pelicula;
    }

    public String getNombre() {
        return this.pelicula; 
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public Butaca getButaca(int fila, int columna) {
        if (fila >= 0 && fila < filas && columna >= 0 && columna < columnas) {
            return butacas[fila][columna];
        }
        return null;
    }
    
    public List<Butaca> getButacas() {
        List<Butaca> listaButacas = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                listaButacas.add(butacas[i][j]);
            }
        }
        return listaButacas;
    }
    
    public void reservar(int fila, int columna){
        Butaca butacaSeleccionada = butacas[fila][columna];

        if(butacaSeleccionada != null && !butacaSeleccionada.getEstaOcupada()) { 
            butacaSeleccionada.setEstaOcupada(true);
        }
    }
}
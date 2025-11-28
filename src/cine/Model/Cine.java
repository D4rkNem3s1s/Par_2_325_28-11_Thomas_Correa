/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Cine implements Serializable{
    private static final long serialVersionUID = 4L; 
    
    private Set<Usuario> usuarios;

    private List<Sala> salas;
    public Cine() {
        inicializarListas(); 
    }
    private void inicializarListas() {
        if (this.usuarios == null) {
             this.usuarios = new HashSet<>(); 
        }
        
        if (this.salas == null) {
             this.salas = new ArrayList<>(); 
             
             
             this.salas.add(new Sala("Duna 2", 10, 12));
             this.salas.add(new Sala("Wonka", 8, 10));
             this.salas.add(new Sala("Avatar", 5, 8));
             this.salas.add(new Sala("Interestellar", 5, 12));
             this.salas.add(new Sala("Scary Movie 6", 9, 10));
             this.salas.add(new Sala("ToyStory 5", 7, 8));
        }
    }
    
    public Set<Usuario> getUsuarios() { 
        return usuarios; 
    }
    
    public List<Sala> getSalas() { 
        return salas; 
    }
}
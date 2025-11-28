/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.Model;
import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L; 
    
    private String nombre;
    private int id;
    private String passwordHash;

    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.passwordHash = simularHash(password);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean verificarPassword(String passwordTextoPlano) {
        String hashIngresado = simularHash(passwordTextoPlano);
        return this.passwordHash != null && this.passwordHash.equals(hashIngresado);
    }
    
    public String getContrasenaHasheada() {
        return this.passwordHash;
    }
    
    public void setPassword(String passwordTextoPlano) {
        this.passwordHash = simularHash(passwordTextoPlano);
    }
    
    private static String simularHash(String password) {
        return String.valueOf(password.hashCode()); 
    }

    @Override
    public int hashCode() {
        return this.nombre.hashCode(); 
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Usuario usuario = (Usuario) obj;
        return this.nombre.equalsIgnoreCase(usuario.nombre);
    }
}
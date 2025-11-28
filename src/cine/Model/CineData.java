/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.Model;
import java.util.Set; // Importamos Set


public class CineData {

    private static Cine instanciaCine;

    public static Cine getInstancia() {
        if (instanciaCine == null) {
            cargarDatos();
        }
        return instanciaCine;
    }

    public static void cargarDatos() {
        Cine datosCargados = Serializador.cargar(); 
        
        if (datosCargados != null) {
            instanciaCine = datosCargados;
            System.out.println("Datos del Cine cargados desde archivo.");
        } else {
            instanciaCine = new Cine(); 
            System.out.println("No se encontraron datos guardados. Iniciando nuevo Cine.");
        }
    }
    
    public static void guardarDatos() {
        if (instanciaCine != null) {
            Serializador.guardar(instanciaCine);
            System.out.println("Datos del Cine guardados correctamente.");
        }
    }

    public static Usuario buscarUsuarioPorNombre(String usuarioNombre) {
        if (instanciaCine == null) {
            cargarDatos();
        }

        Set<Usuario> usuarios = instanciaCine.getUsuarios();
        
        if (usuarios == null) {
            return null;
        }

        return usuarios.stream()
            .filter(u -> u.getNombre().equalsIgnoreCase(usuarioNombre))
            .findFirst()
            .orElse(null);
    }
    
    public static void agregarUsuario(Usuario nuevoUsuario) {
        instanciaCine.getUsuarios().add(nuevoUsuario);
        

        guardarDatos(); 
    }
    
}
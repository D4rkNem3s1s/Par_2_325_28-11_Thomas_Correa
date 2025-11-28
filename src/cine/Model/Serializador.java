/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializador {
    
    private static String ARCHIVO_CINE = "cine.dat";
    
    public static void guardar(Cine cine){
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_CINE))){
            oos.writeObject(cine);
            System.out.println("Datos del Cine guardados exitosamente.");
        } catch(IOException e){
            System.out.println("Error al serializar el objeto Cine: " + e.getMessage());
        }
    }
    
    public static Cine cargar(){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_CINE))){
            return (Cine) ois.readObject();
        } catch(FileNotFoundException e) {
            System.out.println("Archivo de datos cine.dat no encontrado. Iniciando nuevo Cine.");
            return new Cine();
        } catch(IOException | ClassNotFoundException e) { 
            System.err.println("Error al cargar o deserializar Cine: " + e.getMessage());
            return new Cine();
        }
    }
}

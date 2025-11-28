/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.controler;

import cine.Model.CineData; 
import cine.Model.Usuario; 

public class ControladorLogin {
    private final ControladorAcceso controladorAcceso;
    public ControladorLogin(ControladorAcceso controladorAcceso) {
        this.controladorAcceso = controladorAcceso;
    }
    public boolean validarCredenciales(String usuario, String password) {
        Usuario usuarioExistente = CineData.buscarUsuarioPorNombre(usuario); 

        if (usuarioExistente == null ) {
            System.out.println("Login fallido: Usuario no encontrado.");
            return false;
        }

        if (usuarioExistente.verificarPassword(password)) {

            System.out.println("Login exitoso para: " + usuario);
            return true;
        } else {
            System.out.println("Login fallido: Contraseña incorrecta.");
            return false;
        }
    }
}
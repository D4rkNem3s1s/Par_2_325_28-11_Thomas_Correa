/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.controler;

import cine.Model.CineData;
import cine.Model.Usuario;
import cine.excepciones.CamposVaciosException;
import cine.excepciones.ContraseñasDistintasException;
import cine.excepciones.UsuarioExistenteException;
import cine.excepciones.LongitudMinimaException; 

public class ControladorRegistro {
    private final ControladorAcceso controladorAcceso;
    private final int MIN_LENGTH = 4;

    public ControladorRegistro(ControladorAcceso controladorAcceso) {
        this.controladorAcceso = controladorAcceso;
    }

    public void procesarRegistro(String usuarioNombre, String password, String passwordConfirmacion)
            throws CamposVaciosException, LongitudMinimaException, ContraseñasDistintasException, UsuarioExistenteException {
        String nombreLimpio = (usuarioNombre != null) ? usuarioNombre.trim() : "";
        String passwordLimpia = (password != null) ? password.trim() : "";
        String confirmacionLimpia = (passwordConfirmacion != null) ? passwordConfirmacion.trim() : "";
        verificarCamposVacios(nombreLimpio, passwordLimpia, confirmacionLimpia);
        verificarLongitudMinima(nombreLimpio, passwordLimpia);
        verificarCoincidenciaClaves(passwordLimpia, confirmacionLimpia);
        verificarUsuarioExistente(nombreLimpio);
        Usuario nuevoUsuario = new Usuario(nombreLimpio, passwordLimpia);

        try {
            CineData.agregarUsuario(nuevoUsuario);
            System.out.println("Registro exitoso. Usuario " + nombreLimpio + " guardado.");
            this.controladorAcceso.loginExitoso(); 

        } catch (Exception e) {
            System.err.println("Error fatal al guardar el nuevo usuario: " + e.getMessage());
            throw new RuntimeException("Error en el guardado de datos.", e);
        }
    }
    private void verificarCamposVacios(String usuario, String clave, String confirmacion) throws CamposVaciosException {
        if (usuario.isEmpty() || clave.isEmpty() || confirmacion.isEmpty()) {
            throw new CamposVaciosException("Error. Todos los campos deben estar completados");
        }
    }
    private void verificarLongitudMinima(String usuario, String clave) throws LongitudMinimaException {
        if (usuario.length() < MIN_LENGTH || clave.length() < MIN_LENGTH) {
            throw new LongitudMinimaException("Error. Debe tener una longitud minima de " + MIN_LENGTH);
        }
    }
    private void verificarCoincidenciaClaves(String clave, String confirmacion) throws ContraseñasDistintasException {
        if (!clave.equals(confirmacion)) {
            throw new ContraseñasDistintasException("Error. Las contraseñas no coinciden");
        }
    }
    private void verificarUsuarioExistente(String nombreLimpio) throws UsuarioExistenteException {
        if (CineData.buscarUsuarioPorNombre(nombreLimpio) != null) {
            throw new UsuarioExistenteException("Error. Este usuario ya esta registrado");
        }
    }
}
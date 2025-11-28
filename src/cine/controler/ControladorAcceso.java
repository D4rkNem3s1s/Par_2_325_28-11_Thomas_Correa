/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.controler;

import cine.excepciones.CamposVaciosException;
import cine.excepciones.ContraseñasDistintasException;
import cine.excepciones.LongitudMinimaException;
import cine.excepciones.UsuarioExistenteException;
import cine.view.LoginMenu;
import cine.view.MainMenu;
import cine.view.RegisterMenu;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class ControladorAcceso {
    private final Stage stage;
    private final ControladorCine controladorCine;
    private final ControladorLogin controladorLogin;
    private final ControladorRegistro controladorRegister;
    
    private final Parent mainMenuRoot;

    
    public ControladorAcceso(Stage stage, ControladorCine controladorCine){
    
        this.stage = stage;
        this.controladorCine = controladorCine;
        
        this.controladorLogin = new ControladorLogin(this);
        this.controladorRegister = new ControladorRegistro(this);

        MainMenu mainMenu = new MainMenu(this);
        mainMenuRoot = mainMenu.getRoot();
    }

    public void irAlRegister(){
        RegisterMenu registerMenu = new RegisterMenu(this);
        
        stage.getScene().setRoot(registerMenu.getRoot());
        stage.setTitle("Cine Manager - Registrarse");
    }
    
    public void irAlLogin(){
        LoginMenu loginMenu = new LoginMenu(this);
        
        stage.getScene().setRoot(loginMenu.getRoot());
        stage.setTitle("Cine Manager - Iniciar Sesión");
    }
    
    public void volverMainMenu(){
        stage.getScene().setRoot(this.mainMenuRoot);
        stage.setTitle("Cine Manager - Inicio");
    }

    public void verificarCredenciales(String usuario, String contraseña) {
        boolean credencialesValidas = controladorLogin.validarCredenciales(usuario, contraseña);
        
        if (credencialesValidas) {
            this.loginExitoso();
        } else {

            System.out.println("Error: Credenciales no válidas."); 
        }
    }
    
    public void loginExitoso(){
        this.controladorCine.iniciarAplicacionPrincipal(); 
    }

    public void registrarNuevoUsuario(String usuario, String password, String confirmacion) throws CamposVaciosException, LongitudMinimaException, ContraseñasDistintasException, UsuarioExistenteException {
        this.controladorRegister.procesarRegistro(usuario, password, confirmacion);
    }

    public Parent getRootInicial(){
        return mainMenuRoot;
    }
    
    public Stage getStage() {
        return stage;
    }  

}
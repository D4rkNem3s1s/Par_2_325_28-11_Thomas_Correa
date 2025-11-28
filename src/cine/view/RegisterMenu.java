/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.view;

import cine.controler.ControladorAcceso;
import cine.excepciones.CamposVaciosException;
import cine.excepciones.ContraseñasDistintasException;
import cine.excepciones.LongitudMinimaException;
import cine.excepciones.UsuarioExistenteException;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

/**
 *
 * @author thoma
 */
public class RegisterMenu {
    private final VBox root;
    private final ControladorAcceso controladorAcceso;

    private final TextField txtUsuario;
    private final PasswordField txtPassword;
    private final PasswordField txtConfirmarPassword; 

    public RegisterMenu(ControladorAcceso controladorAcceso){
        this.controladorAcceso = controladorAcceso;
        
        Label titulo = new Label("Registrar Nuevo Usuario");
        titulo.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
        
        txtUsuario = new TextField();
        txtUsuario.setPromptText("Usuario");
        
        txtPassword = new PasswordField();
        txtPassword.setPromptText("Contraseña");

        txtConfirmarPassword = new PasswordField();
        txtConfirmarPassword.setPromptText("Confirmar Contraseña");
        
        Button btnRegistrar = new Button("Registrarse");
        Button btnVolver = new Button("Volver");
        

        btnRegistrar.setOnAction(e -> {
            try {
                controladorAcceso.registrarNuevoUsuario(
                        txtUsuario.getText(),
                        txtPassword.getText(),
                        txtConfirmarPassword.getText()
                );
            } catch (CamposVaciosException ex) {
                mostrarAlerta(ex.getMessage());
            } catch (LongitudMinimaException ex) {
                mostrarAlerta(ex.getMessage());
            } catch (ContraseñasDistintasException ex) {
                mostrarAlerta(ex.getMessage());
            } catch (UsuarioExistenteException ex) {
                mostrarAlerta(ex.getMessage());
            }
        });
        
        btnVolver.setOnAction(e -> {
            controladorAcceso.volverMainMenu();
        });

        root = new VBox(15);
        root.setStyle("-fx-padding:30; -fx-alignment:center");
        
        
        root.getChildren().addAll(titulo, txtUsuario, txtPassword, txtConfirmarPassword, btnRegistrar, new Label(""), btnVolver);
    }
    
    private void mostrarAlerta(String mensaje) {
        System.out.println("ALERTA UI: " + mensaje);
    }
    public Parent getRoot(){
        return root;
    }
}
    


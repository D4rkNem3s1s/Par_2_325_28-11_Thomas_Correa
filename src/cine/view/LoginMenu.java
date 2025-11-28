/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.view;

import cine.controler.ControladorAcceso;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class LoginMenu {
    
    private final VBox root;

    private final ControladorAcceso controladorAcceso;

    private final TextField txtUsuario;
    private final PasswordField txtPassword;

    public LoginMenu(ControladorAcceso controladorAcceso) { 

        this.controladorAcceso = controladorAcceso; 
        Label titulo = new Label("Iniciar Sesión");

        this.txtUsuario = new TextField(); 
        this.txtUsuario.setPromptText("Usuario");
        
        this.txtPassword = new PasswordField();
        this.txtPassword.setPromptText("Contraseña");
        
        Button btnEnter = new Button("Entrar");
        Button btnVolver = new Button("Volver");

        btnEnter.setOnAction(e -> {
            this.controladorAcceso.verificarCredenciales(
                this.txtUsuario.getText(),
                this.txtPassword.getText()
            );
        });
        
        btnVolver.setOnAction(e -> {
            this.controladorAcceso.volverMainMenu();
        }); 
        root = new VBox(15);
        root.setStyle("-fx-padding:30; -fx-alignment:center");
        root.getChildren().addAll(titulo, this.txtUsuario, this.txtPassword, btnEnter, new Label(""), btnVolver);
    }
    
    public Parent getRoot(){
        return root;
    }
}

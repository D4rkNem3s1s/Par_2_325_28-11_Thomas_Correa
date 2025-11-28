/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.view;

import cine.controler.ControladorAcceso;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


/**
 *
 * @author thoma
 */
public class MainMenu {
    private final VBox root;
    private final ControladorAcceso controlador;

    public MainMenu(ControladorAcceso controlador){
        this.controlador = controlador;
        
        Label titulo = new Label("Registrese o inicie sesión");
        titulo.setStyle("-fx-font-size: 14pt; -fx-font-weight: bold;");
        root = new VBox(20);
        root.setStyle("-fx-padding:30; -fx-alignment:center;");
        Button btnLogin = new Button("Iniciar Sesión");
        Button btnRegister = new Button("Registrarse");
        btnLogin.setOnAction(e -> controlador.irAlLogin());
        btnRegister.setOnAction(e -> controlador.irAlRegister());
        root.getChildren().addAll(titulo, btnLogin, btnRegister); 
    }
    public Parent getRoot(){
        return root;
    }
    

}

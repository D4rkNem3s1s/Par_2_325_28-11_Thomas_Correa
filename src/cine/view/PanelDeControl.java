/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.view;

import cine.controler.ControladorCine;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class PanelDeControl {
    private final VBox root;
    private final ControladorCine controladorCine; 
    
    public PanelDeControl(ControladorCine controladorCine) {
        this.controladorCine = controladorCine;
        
        Label titulo = new Label("Bienvenido a Cine Manager");
        titulo.setStyle("-fx-font-size: 20pt;");
        
        Button btnVerCartelera = new Button("Ver Cartelera");
        btnVerCartelera.setMinWidth(250);
        
        Button btnCerrarSesion = new Button("Cerrar Sesión");
        btnCerrarSesion.setMinWidth(250);
        
        btnVerCartelera.setOnAction(e -> this.controladorCine.navegarACartelera()); 
        
        btnCerrarSesion.setOnAction(e -> this.controladorCine.cerrarSesion()); 
        
        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(titulo, btnVerCartelera, btnCerrarSesion);
    }

    public Parent getRoot() {
        return root;
    }
}
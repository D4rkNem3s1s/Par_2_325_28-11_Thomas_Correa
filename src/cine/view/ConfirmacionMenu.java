/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.view;

import cine.controler.ControladorCine; // Importamos el controlador
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ConfirmacionMenu {
    private final VBox root;
    private final ControladorCine controladorCine; 
    
    public ConfirmacionMenu(ControladorCine controladorCine, String pelicula, List<String> butacasSeleccionadas){
        this.controladorCine = controladorCine;
        
        Label titulo = new Label("¿Deseas confirmar la compra?");
        titulo.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        
        int precioEntrada = 5000; 
        int cantidadButacas = butacasSeleccionadas.size();
        int totalPagar = cantidadButacas * precioEntrada;
        String butacasStr = String.join(", ", butacasSeleccionadas);
        
        String resumenTexto = String.format("Pelicula: %s\nButacas: %s\nTotal a Pagar: $%,d", pelicula, butacasStr, totalPagar);
        
        Label resumen = new Label(resumenTexto);
        resumen.setStyle("-fx-font-size: 12pt;");
        // ------------------------------------------------------------------
        
        Button btnConfirmar = new Button("Confirmar Compra");
        Button btnCancelar = new Button("Cancelar y volver");
        
        HBox botones = new HBox(30);
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(btnConfirmar, btnCancelar);

        btnConfirmar.setOnAction(e -> controladorCine.finalizarCompra(pelicula, butacasSeleccionadas, totalPagar));
        
        btnCancelar.setOnAction(e -> controladorCine.volverASala());

        root = new VBox(30);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30;");
        root.getChildren().addAll(titulo, resumen, botones);
    }

    public Parent getRoot(){
        return root;
    }
}
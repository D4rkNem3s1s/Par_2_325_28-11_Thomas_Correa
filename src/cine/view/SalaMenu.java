package cine.view;

import cine.controler.ControladorCine;
import cine.Model.Butaca; 
import cine.Model.Sala; 
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class SalaMenu {
    private final VBox root;
    private final String nombrePelicula;
    private final List<String> butacasSeleccionadas;
    private final ControladorCine controladorCine;
    private final Sala salaActual;

    public SalaMenu(ControladorCine controladorCine, Sala sala) {
        this.controladorCine = controladorCine;
        this.salaActual = sala;
        this.nombrePelicula = sala.getNombre(); 
        this.butacasSeleccionadas = new ArrayList<>();
        
        Label titulo = new Label("Selecciona tus Asientos para: " + this.nombrePelicula);
        titulo.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        
        GridPane matrizButacas = new GridPane();
        matrizButacas.setAlignment(Pos.CENTER);
        matrizButacas.setHgap(10); 
        matrizButacas.setVgap(10); 

        crearButacas(matrizButacas, sala); 
        
        Label pantalla = new Label("--- PANTALLA DE CINE ---");
        pantalla.setStyle("-fx-background-color: #333333; -fx-text-fill: white; -fx-padding: 5 150;");
        
        Button btnComprar = new Button("Comprar Seleccionadas");
        Button btnVolver = new Button("Volver a Cartelera");

        btnComprar.setOnAction(e -> {
            if (butacasSeleccionadas.isEmpty()) {
                System.out.println("Debe seleccionar al menos una butaca.");
                return;
            }
            this.controladorCine.navegarAConfirmacion(this.nombrePelicula, butacasSeleccionadas);
        });
        
        btnVolver.setOnAction(e -> this.controladorCine.volverACartelera());
        
        
        root = new VBox(25);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30");
        
        root.getChildren().addAll(titulo, pantalla, matrizButacas, btnComprar, btnVolver);
    }
    
    
    private void crearButacas(GridPane matriz, Sala sala){
        final String estilo_Ocupado = "-fx-background-color: #ff6961; -fx-border-color: #a83e3e; -fx-background-radius: 5; -fx-border-radius: 5; -fx-font-weight: bold;"; 
        final String estilo_Disponible = "-fx-background-color: #a8e6cf; -fx-border-color: #38761d; -fx-background-radius: 5; -fx-border-radius: 5"; 
        final String estilo_Seleccionado = "-fx-background-color: #ffd3b6; -fx-border-color: #e69138; -fx-background-radius: 5; -fx-border-radius: 5; -fx-font-weight: bold;"; 
        
        int numFilas = sala.getFilas();
        int numColumnas = sala.getColumnas();
        

        for (int i = 0; i < numFilas; i++) { 
            for (int j = 0; j < numColumnas; j++) { 
                
                Butaca butacaModelo = sala.getButaca(i, j);
                
                if (butacaModelo == null) continue; 
                
                String nombreButaca = butacaModelo.getIdentificador();
                Button butacaUI = new Button(nombreButaca);
                butacaUI.setPrefSize(50, 50);
                

                if (butacaModelo.getEstaOcupada()) { // Se asume isEstaOcupada()
                    butacaUI.setStyle(estilo_Ocupado);
                    butacaUI.setDisable(true); 
                } else {
                    butacaUI.setStyle(estilo_Disponible);
                }

                butacaUI.setOnAction(e -> {

                    if (butacaUI.getStyle().contains("#a8e6cf")) { 
                        butacaUI.setStyle(estilo_Seleccionado);
                        butacasSeleccionadas.add(nombreButaca);

                    } else if (butacaUI.getStyle().contains("#ffd3b6")) { 
                        butacaUI.setStyle(estilo_Disponible);
                        butacasSeleccionadas.remove(nombreButaca);
                    }
                });
                
                matriz.add(butacaUI, j, i);
            }
        }
    }
    
    public Parent getRoot(){
        return root;
    }
}
package cine.view;

import cine.controler.ControladorCine;
import cine.Model.Sala; 
import java.util.List;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;


public class CineMenu {
    private final VBox root;
    private final ControladorCine controladorCine; 
    
    public CineMenu(ControladorCine controladorCine, List<Sala> salasDisponibles){
        this.controladorCine = controladorCine;
        
        Label titulo = new Label("Selecciona una Película");
        titulo.setStyle("-fx-font-size: 18pt; -fx-font-weight: bold;");
        
        root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-padding: 30;");
        
        root.getChildren().add(titulo);
        
        generarBotonesDeSalas(salasDisponibles);
        
        Button btnVolver = new Button("Volver al Menú Principal");
        btnVolver.setOnAction(e -> controladorCine.volverAlDashboard());
        
        root.getChildren().add(btnVolver);
    }
    
    private void generarBotonesDeSalas(List<Sala> salasDisponibles) {
        int i = 1;
        
        for(Sala sala : salasDisponibles){

            final String nombrePelicula = sala.getNombre();
            
            Button btnSala = new Button("Sala " + i + ": " + nombrePelicula);
            btnSala.setPrefWidth(350);
            
            btnSala.setOnAction(e -> controladorCine.navegarASala(nombrePelicula));
            
            root.getChildren().add(btnSala);
            i++;
        }
    } 
    public Parent getRoot(){
        return root;
    }
}
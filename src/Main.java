/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import cine.Model.CineData; 
import cine.controler.ControladorAcceso;
import cine.controler.ControladorCine;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        CineData.cargarDatos();

        ControladorCine controladorCine = new ControladorCine(primaryStage);

        ControladorAcceso controladorAcceso = new ControladorAcceso(primaryStage, controladorCine);

        controladorCine.setControladorAcceso(controladorAcceso);
        
        Parent initialRoot = controladorAcceso.getRootInicial();
        
        Scene scene = new Scene (initialRoot, 600, 400);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cine Manager - Inicio");
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(event -> {
            CineData.guardarDatos(); 
        });
    }
    
    public static void main(String[] args) {
        launch();
    }
}
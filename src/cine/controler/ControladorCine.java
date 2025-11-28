/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cine.controler;
import cine.Model.Butaca;
import cine.Model.CineData;
import cine.Model.Sala;
import cine.view.CineMenu;
import cine.view.ConfirmacionMenu;
import cine.view.PanelDeControl;
import cine.view.SalaMenu;
import java.util.List;
import javafx.stage.Stage;


public class ControladorCine {

    private final Stage stagePrincipal;
    private ControladorAcceso controladorAcceso; 

    public ControladorCine(Stage primaryStage) {

        this.stagePrincipal = primaryStage;
    }
    
    public void setControladorAcceso(ControladorAcceso controladorAcceso) {
        this.controladorAcceso = controladorAcceso;
    }

    public void iniciarAplicacionPrincipal() {
        PanelDeControl dashboard = new PanelDeControl(this);

        stagePrincipal.getScene().setRoot(dashboard.getRoot());
        stagePrincipal.setTitle("Cine Manager - PanelDeControl");
    }

    
    public void cerrarSesion() {

        if (controladorAcceso != null) {
            this.controladorAcceso.volverMainMenu(); 
        } else {
            System.err.println("Error grave: ControladorAcceso es null en ControladorCine.");
        }
    }
    
    public void volverAlDashboard() {
        this.iniciarAplicacionPrincipal();
    }

    public void navegarACartelera() {
        List<Sala> salasDisponibles = CineData.getInstancia().getSalas();
        CineMenu carteleraMenu = new CineMenu(this, salasDisponibles);
        stagePrincipal.getScene().setRoot(carteleraMenu.getRoot());
        stagePrincipal.setTitle("Cine Manager - Cartelera");
    }
    
    public void volverACartelera() {
        this.navegarACartelera();
    }

    public void navegarASala(String nombrePelicula) {
    Sala salaSeleccionada = buscarSalaPorPelicula(nombrePelicula); 
    
    if (salaSeleccionada == null) {
        System.err.println("Error: No se encontró la sala para la película: " + nombrePelicula);
        return;
    }
    SalaMenu salaMenu = new SalaMenu(this, salaSeleccionada); 
    
    stagePrincipal.getScene().setRoot(salaMenu.getRoot());
    stagePrincipal.setTitle("Cine Manager - Selección de Butacas: " + nombrePelicula);
}
    
    public void navegarAConfirmacion(String nombrePelicula, List<String> butacasSeleccionadas) {
        ConfirmacionMenu menuConfirmacion = new ConfirmacionMenu(this, nombrePelicula, butacasSeleccionadas);
        
        stagePrincipal.getScene().setRoot(menuConfirmacion.getRoot());
        stagePrincipal.setTitle("Cine Manager - Confirmar Compra");
    }
    
    public void volverASala() {
        this.navegarACartelera();
    }
    
    public void finalizarCompra(String pelicula, List<String> butacasSeleccionadas, int totalPagar) {
        System.out.println("✅ Procesando compra: " + butacasSeleccionadas.size() + " butacas por $" + totalPagar);

        Sala salaComprada = buscarSalaPorPelicula(pelicula);
        
        if (salaComprada != null) {
            for (String identificadorButaca : butacasSeleccionadas) {
                for (Butaca butaca : salaComprada.getButacas()) {
                    if (butaca.getIdentificador().equalsIgnoreCase(identificadorButaca)) {
                        butaca.setEstaOcupada(true);
                        break;
                    }
                }
            }
            
            CineData.guardarDatos(); 
            System.out.println("Datos actualizados y guardados exitosamente.");
            
        } else {
            System.err.println("Error: Sala no encontrada al finalizar la compra. No se guardaron los datos.");
        }

        this.iniciarAplicacionPrincipal(); 
    }

    private Sala buscarSalaPorPelicula(String nombrePelicula) {
        for (Sala sala : CineData.getInstancia().getSalas()) {
            if (sala.getNombre().equalsIgnoreCase(nombrePelicula)) { 
                return sala;
            }
        }
        return null;
    }
}

import presentacion.Modelo;

/**
 * Clase principal
 */
public class Launcher {

    private Modelo modeloApp;
    
    /**
     * Metodo incial ejecucion
     * @param args 
     */
    public static void main(String[] args) {
       new Launcher();
    }
    
    /**
     * Metodo instanciar Modelo e inicializarlo
     */
    public Launcher() {
        modeloApp = new Modelo();
        modeloApp.iniciar();        
    }   
    
}

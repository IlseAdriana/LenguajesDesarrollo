package Transportes;

import ZonasEspera.Aeropuerto;

public class RutaAlimentadora implements Runnable { // Productor para Aeropuerto
    // Atributos
    private Aeropuerto aeropuerto;
    private int numIteraciones;

    // Métodos
    
    // Constructor
    public RutaAlimentadora(Aeropuerto aeropuerto, int iteraciones) {
        this.aeropuerto = aeropuerto;
        this.numIteraciones = iteraciones;
    }

    // Run
    @Override
    public void run() {
        for (int i = 0; i < this.numIteraciones; i++) {
            if (i % 5 == 0) {
                this.aeropuerto.llegaRutaAlimentadora();
            }
            
        }
    }   
}
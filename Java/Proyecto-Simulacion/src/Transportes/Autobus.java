package Transportes;

import ZonasEspera.Aeropuerto;

public class Autobus implements Runnable { // Consumidor para Aeropuerto y Productor para Central Sur
    // Atributos
    private Aeropuerto aeropuerto;
    private int numIteraciones;

    // Métodos
    
    // Constructor
    public Autobus(Aeropuerto aeropuerto, int iteraciones) {
        this.aeropuerto = aeropuerto;
        this.numIteraciones = iteraciones;
    }

    // Run
    @Override
    public void run() {
        for (int i = 0; i < this.numIteraciones; i++) {
            if (this.aeropuerto.saleAutobusHaciaCS(70)) {
                for (int j = 0; j < 60; j++) {
                }
                i += 60;
            }
        }
    }
    
}

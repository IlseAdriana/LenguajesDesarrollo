package Transportes;

import ZonasEspera.Aeropuerto;

public class Avion implements Runnable { // Consumidor para Aeropuerto y Productor para Central Norte
    // Atributos
    private Aeropuerto aeropuerto;
    private int numIteraciones;

    // Métodos

    // Constructor
    public Avion(Aeropuerto aeropuerto, int iteraciones) {
        this.aeropuerto = aeropuerto;
        this.numIteraciones = iteraciones;
    }

    // Run
    @Override
    public void run() {
        for (int i = 0; i < this.numIteraciones; i++) {
            if (this.aeropuerto.saleAvionHaciaCN(100)) {
                for (int j = 0; j < 40; j++) {

                }
                i += 40;
            }
        }
    } 
}
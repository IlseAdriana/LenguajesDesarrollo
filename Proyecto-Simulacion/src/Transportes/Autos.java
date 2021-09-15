package Transportes;

import ZonasEspera.CentralAutobus;

public class Autos implements Runnable {
    // Atributos
    private CentralAutobus central;
    private int numIteraciones;

    // Métodos

    // Constructor
    public Autos(CentralAutobus central, int iteraciones) {
        this.central = central;
        this.numIteraciones = iteraciones;
    }

    // Run
    @Override
    public void run() {
        for (int i = 0; i < this.numIteraciones; i++) {
            if (i % 3 == 0) {
                /* Sale un taxi en la Central Norte */
                this.central.saleTaxiDesdeCN();

                /* Sale un taxi en la Central Sur*/
                this.central.saleTaxiDesdeCS();
            }
        }
    }
    
}

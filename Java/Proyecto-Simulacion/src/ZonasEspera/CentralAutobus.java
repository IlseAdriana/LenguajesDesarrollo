package ZonasEspera;

import java.util.Random;

public class CentralAutobus { // Área común
    // Atributos
    private int capacidadCN;
    private int capacidadActualCN;
    private int tomaronTaxiCN; // Cantidad de personas que tomaron un taxi en la Central Norte

    private int capacidadCS;
    private int capacidadActualCS;
    private int tomaronTaxiCS; // Cantidad de personas que tomaron un taxi en la Central Sur

    private Random probaNumPersonas;

    // Métodos

    // Constructor
    public CentralAutobus(int capacidadCN, int capacidadCS) {
        this.capacidadCN = capacidadCN;
        this.capacidadActualCN = 0;
        this.tomaronTaxiCN = 0;

        this.capacidadCS = capacidadCS;
        this.capacidadActualCS = 0;
        this.tomaronTaxiCS = 0;

        this.probaNumPersonas = new Random();
    }

    // Para los hilos consumidores

    // Salida de un taxi con 1, 2 o 3 personas de la Central Norte
    public synchronized boolean saleTaxiDesdeCN() {
        /* Verificamos que haya al menos 3 personas en la Central Norte */
        if (this.capacidadActualCN > 3) {

            /* Si la probabilidad es < 0.4, es un viaje de 3 personas */
            if (this.probaNumPersonas.nextDouble() < 0.4) {
                this.capacidadActualCN -= 3;
                this.tomaronTaxiCN += 3;
                return true;

            /* Si la probabilidad es >= 0.4 y < 0.7, es un viaje de 2 personas*/
            } else if (this.probaNumPersonas.nextDouble() >= 0.4 && this.probaNumPersonas.nextDouble() < 0.7) {
                this.capacidadActualCN -= 2;
                this.tomaronTaxiCN += 2;
                return true;

            /* La probabilidad es >= 0.7, por lo que es un viaje de 1 persona */
            } else {
                this.capacidadActualCN--;
                this.tomaronTaxiCN++;
                return true;
            }

        } else {
            // System.out.println("No hay suficientes personas para recoger en la Central Norte");
            return false;
        }
    }

    // Salida de un taxi con 1, 2 o 3 personas de la Central Sur
    public synchronized boolean saleTaxiDesdeCS() {
        /* Verificamos que haya al menos 3 personas en la Central Sur */
        if (this.capacidadActualCS > 3) {

            /* Si la probabilidad es < 0.4, es un viaje de 3 personas */
            if (this.probaNumPersonas.nextDouble() < 0.4) {
                this.capacidadActualCS -= 3;
                this.tomaronTaxiCS += 3;
                return true;

            /* Si la probabilidad es >= 0.4 y < 0.7, es un viaje de 2 personas*/
            } else if (this.probaNumPersonas.nextDouble() >= 0.4 && this.probaNumPersonas.nextDouble() < 0.7) {
                this.capacidadActualCS -= 2;
                this.tomaronTaxiCS += 2;
                return true;

            /* La probabilidad es >= 0.7, por lo que es un viaje de 1 persona */
            } else {
                this.capacidadActualCS--;
                this.tomaronTaxiCS++;
                return true;
            }

        } else {
            // System.out.println("No hay suficientes personas para recoger en la Central Sur");
            return false;
        } 
    }
    
    // Getters y Setters
    
        // Central Norte
    public int getCapacidadCN() {
        return capacidadCN;
    }

    public int getCapacidadActualCN() {
        return capacidadActualCN;
    }
    public void setCapacidadActualCN(int capacidadActualCN) {
        this.capacidadActualCN = capacidadActualCN;
    }

    public int getTomaronTaxiCN() {
        return tomaronTaxiCN;
    }

        // Central Sur
    public int getCapacidadCS() {
        return capacidadCS;
    }

    public int getCapacidadActualCS() {
        return capacidadActualCS;
    }
    public void setCapacidadActualCS(int capacidadActualCS) {
        this.capacidadActualCS = capacidadActualCS;
    }
    
    public int getTomaronTaxiCS() {
        return tomaronTaxiCS;
    }
    
}
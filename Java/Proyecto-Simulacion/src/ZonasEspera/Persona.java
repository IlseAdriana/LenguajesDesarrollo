package ZonasEspera;

import java.util.Random;

public class Persona {
    // Atributos
    private String destino;
    private Random probaDestino;

    // Métodos

    // Constructor
    public Persona() {
        this.probaDestino = new Random();

        /* Si la probabilidad es > 0.35, la persona va al norte y sino al sur */
        if (this.probaDestino.nextDouble() > 0.35) { 
            this.destino = "Norte";
        } else {
            this.destino = "Sur";
        }
    }
        
        // Getters
    public String getDestino() {
        return destino;
    }
}

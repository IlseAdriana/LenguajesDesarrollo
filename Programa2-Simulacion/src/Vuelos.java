import java.util.Random;

public class Vuelos implements Runnable { // Consumidor
    // Atributos
    private AreaComun area;
    private int hrs_simulacion;
    private Random probaVuelo;
    
    // Métodos
        // Constructor
    public Vuelos(AreaComun area, int hrs_simulacion) {
        this.area = area;
        this.hrs_simulacion = hrs_simulacion;
        this.probaVuelo = new Random();
    }

        // Run
    @Override
    public void run() {
        for (int i = 0; i < hrs_simulacion; i++) {
            
            if (i % 3 == 0 && probaVuelo.nextDouble() >= 0.05) { // Se realiza un VN cada 3 horas y si hay buen clima
                area.vueloNacional();
            } 

            if (i % 5 == 0 && probaVuelo.nextDouble() >= 0.05) { // Se realiza un VI cada 5 horas y si hay buen clima
                area.vueloInternacional();
            } 
        }
    }
}
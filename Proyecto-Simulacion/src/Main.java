import Transportes.*;
import ZonasEspera.*;

public class Main {
    public static void main(String[] args) throws Exception {

        // Creación de Áreas comunes
        CentralAutobus central = new CentralAutobus(500, 200);
        Aeropuerto aeropuerto = new Aeropuerto(700, central);

        // Creación de Objetos Base
        int numIteraciones = 1000000;

        RutaAlimentadora obj_rutaAlimentadora = new RutaAlimentadora(aeropuerto, numIteraciones);
        Avion objAvion = new Avion(aeropuerto, numIteraciones);
        Autobus objAutobus = new Autobus(aeropuerto, numIteraciones);
        Autos objAutos = new Autos(central, numIteraciones);

        // Creación de Hilos
        ThreadGroup grupoHilos = new ThreadGroup("Transportes de la Central Inteligente");

        Thread hiloAlimentadora = new Thread(grupoHilos, obj_rutaAlimentadora);
        Thread hiloAvion = new Thread(grupoHilos, objAvion);
        Thread hiloAutobus = new Thread(grupoHilos, objAutobus);
        Thread hiloAutos = new Thread(grupoHilos, objAutos);
        
        
        // Ejecución de Hilos
        hiloAlimentadora.start();
        hiloAvion.start();
        hiloAutobus.start();
        hiloAutos.start();

        while (grupoHilos.activeCount() > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Muestra de resultados
        System.out.println("\nVuelos totales a Central Norte: " + aeropuerto.getVuelosCN());
        System.out.println("Viajes totales en autobus a Central Sur: " + aeropuerto.getViajesbusCS());
        System.out.println("\nTotal de personas que tomaron taxi en Central Norte: " + central.getTomaronTaxiCN());
        System.out.println("Total de personas que tomaron taxi en Central Sur: " + central.getTomaronTaxiCS() + "\n");

    }
}

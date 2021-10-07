public class Main {
    public static void main(String[] args) throws Exception {
        
        // Creación de área común
        AreaComun aeropuerto = new AreaComun(24000, 32000);

        // Creación de objetos base
        int hrs_simulacion = 43800;
        CargaProgramada objProductor = new CargaProgramada(aeropuerto, hrs_simulacion);
        Vuelos objConsumidor = new Vuelos(aeropuerto, hrs_simulacion);

        // Creación de hilos
        Thread hiloPro = new Thread(objProductor);
        Thread hiloCon = new Thread(objConsumidor);

        // Ejecución de los hilos
        hiloPro.start();
        hiloCon.start();

        while (hiloPro.isAlive() || hiloCon.isAlive()) {
            try {
               Thread.sleep(10); 
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // Muestra de resultados
        System.out.println("Veces que se intercambiaron combustible los contenedores: " + aeropuerto.getPasoCombustible());
        System.out.println("Vuelos perdidos por falta de combustible en contenedores: " + aeropuerto.getVuelosPerdidos());
    }
}

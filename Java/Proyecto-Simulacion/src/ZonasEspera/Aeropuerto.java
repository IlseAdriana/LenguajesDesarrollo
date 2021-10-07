package ZonasEspera;

public class Aeropuerto { // Área Común
    // Atributos
    private int capacidad;
    private int capacidadActual;
    private int vuelosCN; // Cantidad de vuelos realizados hacia la Central Norte
    private int autobusesCS; // Cantidad de viajes en autobus realizados hacia la Central Sur
    
    private Persona persona;
    private int destinoNorte; // Cantidad de personas con destino a la Central Norte
    private int destinoSur; // Cantidad de personas con destino a la Central Sur
    
    private CentralAutobus central;

    // Métodos

    // Constructor
    public Aeropuerto(int capacidad, CentralAutobus central) {
        this.capacidad = capacidad;
        this.capacidadActual = 0;

        this.central = central;
        this.vuelosCN = 0;
        this.autobusesCS = 0;

        this.destinoNorte = 0;
        this.destinoSur = 0;
    }

    // Para el hilo productor

    // Llegada de personas al aeropuerto en la ruta alimentadora 
    public synchronized boolean llegaRutaAlimentadora() {
        /* Verificamos que haya capacidad para que lleguen más personas */
        if (this.capacidadActual < this.capacidad) {
            this.persona = new Persona(); // Creamos una nueva persona

            if (this.persona.getDestino().equals("Norte")) { // Comprobamos el destino de la persona
                this.destinoNorte++;
            } else {
                this.destinoSur++;
            }

            this.capacidadActual++;
            return true;

        } else {
            // System.out.println("Capacidad del aeropuerto al límite");
            return false;
        }
    }

    // Para los hilos consumidores y productores

    // Obtener porcentaje de la capacidad actual del aeropuerto    
    public synchronized double capacidadActualAeropuerto() {
        return (double) 100 * this.capacidadActual / this.capacidad;
    }

    // Salida de un vuelo a la Central Norte
    public synchronized boolean saleAvionHaciaCN(int numPasajeros) {
        /* Verificamos que la capacidad del aeropuerto esté en 85% */
        if (this.capacidadActualAeropuerto() >= 85.0) {
            /* Verificamos que haya suficientes pasajeros que van a la Central Norte
                y que ésta tenga espacio para recibirlas */
            if (this.destinoNorte >= numPasajeros && this.central.getCapacidadActualCN() <= (this.central.getCapacidadCN() - numPasajeros)) {
                this.destinoNorte -= numPasajeros;
                this.capacidadActual -= numPasajeros;

                /* Modificamos la capacidad actual de la Central Norte*/
                this.central.setCapacidadActualCN(this.central.getCapacidadActualCN() + numPasajeros);

                this.vuelosCN++;
                return true;
            } else {
                return false;
            }
        } else {
            // System.out.println("Aún puede llegar más gente al Aeropuerto");
            return false;
        }
    }

    // Salida de un autobus a la Central Sur
    public synchronized boolean saleAutobusHaciaCS(int numPasajeros) {
        /* Verificamos que la capacidad del aeropuerto esté en 85% */
        if (this.capacidadActualAeropuerto() >= 85.0) {
            /* Verificamos que haya suficientes pasajeros que van a la Central Sur
                y que ésta tenga espacio para recibirlas */
            if (this.destinoSur >= numPasajeros && this.central.getCapacidadActualCS() <= (this.central.getCapacidadCS() - numPasajeros)) {
                this.destinoSur -= numPasajeros;
                this.capacidadActual -= numPasajeros;

                /* Modificamos la capacidad actual de la Central Sur*/
                this.central.setCapacidadActualCS(this.central.getCapacidadActualCS() + numPasajeros);

                this.autobusesCS++;
                return true;
            } else {
                return false;
            }
        } else {
            // System.out.println("Aún puede llegar más gente al Aeropuerto");
            return false;
        }
    }

    // Getters
    
    public int getVuelosCN() {
        return this.vuelosCN;
    }
    public int getViajesbusCS() {
        return this.autobusesCS;
    }

}
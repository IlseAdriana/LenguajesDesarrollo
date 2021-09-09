public class CargaProgramada implements Runnable { // Productor
    // Atributos
    private AreaComun area;
    private int hrs_simulacion;
    
    // Métodos
        // Constructor
    public CargaProgramada(AreaComun area, int hrs_simulacion) {
        this.area = area;
        this.hrs_simulacion = hrs_simulacion;
    }

        // Run
    @Override
    public void run() {
        for (int i = 0; i < hrs_simulacion; i++) {
            
            if (i % 24 == 0) { // Cada 24 horas se realiza la carga programada
                area.cargaProgramada();
            }
        }
    }
    
}
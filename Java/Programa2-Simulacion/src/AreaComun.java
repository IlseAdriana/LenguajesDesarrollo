public class AreaComun {
    // Atributos
    private double capacidadCont1;
    private double capacidadCont2;
    private double ltsactualesCont1;
    private double ltsactualesCont2;
    private int pasoCombustible; // Veces que se paso combustible de un contenedor a otro
    private int vuelosPerdidos; // Vuelos perdidos por falta de combustible

    // Métodos
        // Constructor
    public AreaComun(double capacidad1, double capacidad2) {
        this.capacidadCont1 = capacidad1;
        this.capacidadCont2 = capacidad2;

        this.ltsactualesCont1 = this.capacidadCont1 * 0.50;
        this.ltsactualesCont2 = this.capacidadCont2 * 0.50;

        this.pasoCombustible = 0;
        this.vuelosPerdidos = 0;
    }

        // Cargar combustible a los contenedores
    public synchronized boolean cargaProgramada() {
        if (this.capacidadCont1 - this.ltsactualesCont1 >= 3600.0) {
            this.ltsactualesCont1 += 3600.0;
            return true;
        } else if(this.capacidadCont2 - this.ltsactualesCont2 >= 3600.0) {
            this.ltsactualesCont2 += 3600.0;
            return true;
        } else {
            return false;
        }
    }

        // Tomar litros de los contenedores
    public synchronized boolean vueloNacional() {
        if (this.ltsactualesCont1 >= 400.0) {
            this.ltsactualesCont1 -= 400.0;

            if (pasarLitrosDeCont2()) {
                pasoCombustible++;
            } else {
                vuelosPerdidos++;
            }
            return true;
            
        } else {
            System.out.println("No hay suficientes litros de turbosina en C1 para tomar 400");
            return false;
        }
    }
    public synchronized boolean vueloInternacional() {
        if (this.ltsactualesCont2 > 800.0) {
            ltsactualesCont2 -= 800.0;

            if (pasarLitrosDeCont1()) {
                pasoCombustible++;
            } else {
                vuelosPerdidos++;
            }
            return true;

        } else {
            System.out.println("No hay suficientes litros de turbosina en C2 para tomar 800");
            return false;
        }
    }
        // Pasar litros entre contenedores
    public synchronized boolean pasarLitrosDeCont2() {
        if (this.ltsactualesCont1 <= 0) {

            if (this.ltsactualesCont2 >= 1000.0) {
                this.ltsactualesCont2 -= 1000.0;
                this.ltsactualesCont1 += 1000.0;
                return true;
            } else {
                System.out.println("C2 no tiene suficiente combustible para pasarle a C1");
                return false;
            }

        } else {
            System.out.println("C1 no está vacío");
            return false;
        }

    }
    public synchronized boolean pasarLitrosDeCont1() {         
        if (this.ltsactualesCont2 <= 0) {

            if (this.ltsactualesCont1 >= 1000.0) {
                this.ltsactualesCont1 -= 1000.0;
                this.ltsactualesCont2 += 1000.0;
                return true;                    
            } else {
                System.out.println("C1 no tiene suficiente combustible para pasarle a C2");
                return false;
            }

        } else {
            System.out.println("C2 no está vacío");
            return false;
        }
    }

        // Getters
    public int getPasoCombustible() {
        return pasoCombustible;
    }

    public int getVuelosPerdidos() {
        return vuelosPerdidos;
    }

}
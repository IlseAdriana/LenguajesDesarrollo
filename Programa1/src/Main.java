public class Main {
    public static void main(String[] args) throws Exception {

        /* Llenar array de objetos <Punto2d> */
        Punto2d[] arrPuntos = new Punto2d[100];
        for (int i = 0; i < arrPuntos.length; i++) {
            arrPuntos[i] = new Punto2d();
        }

        /* Dividir el trabajo */
        int numHilos = 4;
        int datosXhilo = arrPuntos.length / numHilos;
        Punto2d[][] matrizPuntos = new Punto2d[numHilos][datosXhilo];

        for (int i = 0; i < numHilos; i++) {
            System.arraycopy(arrPuntos, i * datosXhilo, matrizPuntos[i], 0, datosXhilo);
        }

        /* Crear los objetos base, asociarlos a un nuevo hilo, 
            el cual pertenece a un ThreadGroup, y ejecutarlos*/
        Punto2d[] arrObjsBase = new Punto2d[numHilos];
        
        ThreadGroup grupoHilos = new ThreadGroup("Hilos");
        Thread[] arrHilos = new Thread[numHilos];
        
        for (int i = 0; i < numHilos; i++) {
            arrObjsBase[i] = new Punto2d(matrizPuntos[i]);
            arrHilos[i] = new Thread(grupoHilos, arrObjsBase[i]);
            arrHilos[i].start();
        }

        /* Esperar a que los hilos mueran */
        while (grupoHilos.activeCount() > 0) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        /* Sumar los resultados de cada hilo */
        float res = 0f;
        for (int i = 0; i < arrHilos.length; i++) {
            res += arrObjsBase[i].getRes();
        }
        System.out.println("Suma total: " + res);

    }
}
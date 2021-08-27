import java.util.Random;

public class Punto2d implements Runnable {
    // Atributos
    private Float x;
    private Float y;
    private Punto2d[] datos;
    private float resu;
    
    // Métodos
        // Constructores
    public Punto2d() {
        this.x = new Random().nextFloat() * 10f;
        this.y = -5f + new Random().nextFloat() * (5 - (-5));
    }
    public Punto2d(Punto2d[] puntos) {
        this.datos = puntos;
        this.resu = 0f;
    }
        // Getters
    public float getRes() {
        return resu;
    }
        // Otros
    @Override
    public void run() {
        for(int i = 0; i < this.datos.length; i++) {
            this.resu += (float) (Math.pow(this.datos[i].x, 2) + (2 * this.datos[i].y) - this.datos[i].x);
        } 
    }
    
}

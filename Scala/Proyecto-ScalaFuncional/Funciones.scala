// Método Nelder-Mead con Programación Funcional

object Funciones {

   // Funciones a evaluar

   def sphere(punto: Punto2D): Double = {
      (punto.x * punto.x) + (punto.y * punto.y)
   }

   def example(punto: Punto2D): Double = {
      (punto.x * punto.x) - (4 * punto.x) + (punto.y * punto.y) - punto.y - (punto.x * punto.y)
   }

   def rosenbrock(punto: Punto2D): Double = {
      (1 - punto.x) + Math.pow(100 * (punto.y - (punto.x * punto.x)), 2)
   }

}

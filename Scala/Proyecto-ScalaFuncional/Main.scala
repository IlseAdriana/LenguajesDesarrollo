// Método Nelder-Mead con Programación Funcional

object Main {

   def main(args: Array[String]): Unit = {

      // Valores mínimos obtenidos utilizando la función pasada como parámetro
      val minSphere:Punto2D = Algoritmo.algoritmo(Funciones.sphere)
      val minExample:Punto2D = Algoritmo.algoritmo(Funciones.example)
      val minRosenbrock:Punto2D = Algoritmo.algoritmo(Funciones.rosenbrock)

      println("Sphere: " + minSphere)
      println("Example: " + minExample)
      println("Rosenbrock: " + minRosenbrock)

   }

}

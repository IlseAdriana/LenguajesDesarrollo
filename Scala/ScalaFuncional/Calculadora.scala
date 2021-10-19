/* Generación de una calculadora con funciones de alto nivel y currificadas
   que permita realizar operaciones de suma, resta, multiplicación y división */

object Calculadora {

   def main(args: Array[String]): Unit = {

      val resSuma:Double = aplica(7.5, 3.41, suma(_)(_))
      printf("%.2f\n", resSuma)

      val resResta:Double = aplica(13.7, 6.2, resta(_)(_))
      printf("%.2f\n", resResta)

      val resMult:Double = aplica(5.2, 2.7, multiplicacion(_)(_))
      printf("%.2f\n", resMult)

      val resDiv:Double = aplica(12.0, 4.0, division(_)(_))
      printf("%.2f\n", resDiv)

   }

   // Función de alto nivel
   def aplica(p1: Double, p2: Double, func:(Double, Double) => Double):Double = {
      func(p1, p2)
   }

   // Funciones currificadas
   def suma(n1: Double)(n2: Double): Double = { n1 + n2 }

   def resta(n1: Double)(n2: Double): Double = { n1 - n2 }

   def multiplicacion(n1: Double)(n2: Double): Double = { n1 * n2 }

   def division(n1: Double)(n2: Double): Double = { n1 / n2 }

}

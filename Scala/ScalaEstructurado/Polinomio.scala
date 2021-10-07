// Calcular el polinomio P(x) = 2 + 5x - x**2

import java.util.Scanner

object Polinomio {
   def main(args: Array[String]): Unit = {
      val leer = new Scanner(System.in)
      print("Digite el valor de X: ")
      val x: Float = leer.nextFloat()

      val resu: Float = 2 + (5 * x) - (x * x)
      printf("Resultado: %.2f", resu)
   }
}

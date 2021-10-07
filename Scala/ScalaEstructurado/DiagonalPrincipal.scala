// Calcular la suma de la diagonal principal de una matriz

import java.util.Scanner

object DiagonalPrincipal {
   def main(args: Array[String]): Unit = {
      val leer = new Scanner(System.in)
      print("Digite el número de filas y columnas para la matriz cuadrada: ")
      val fc: Int = leer.nextInt()

      val matriz = Array.ofDim[Int](fc, fc)
      var suma: Int = 0
      for (i <- 0 until fc) {
         for (j <- 0 until fc) {
            print("Digite un numero entero: ")
            matriz(i)(j) = leer.nextInt()
            if (j == i) {
               suma += matriz(i)(j)
            }
         }
      }
      println("Suma de diagonal principal: " + suma)
   }
}

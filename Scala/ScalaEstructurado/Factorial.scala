// Calcular el factorial de un número

import java.util.Scanner

object Factorial {
   def main(args: Array[String]): Unit = {
      val leer = new Scanner(System.in)
      print("Digite un número entero: ")
      val num: Int = leer.nextInt()
      
      var fact = 1;
      for (i <- 1 to num) {
      	fact *= i;
      }
      
      println("Factorial: " + fact)
   }
}

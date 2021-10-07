// Mostrar si un numero es par o impar

import java.util.Scanner

object ParImpar {
   def main(args: Array[String]): Unit = {
      val leer = new Scanner(System.in)
      print("Digite un número entero: ")
      val num: Int = leer.nextInt()

      val resp: String = num match {
         case num if (num % 2 == 0) => "Par"
         case num if (num % 2 == 1) => "Impar"
      }
      println(resp)
   }
}

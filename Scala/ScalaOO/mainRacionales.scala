// Operaciones con Numeros Racionales

import java.util.Scanner

object mainRacionales {
   def main(args: Array[String]): Unit = {
      val leer:Scanner = new Scanner(System.in)

      println("Digite los valores del numerador y denominador para la fraccion 1")
      val num1 = leer.nextDouble()
      val den1 = leer.nextDouble()
      val nr1: NumeroRacional = new NumeroRacional(num1, den1)

      println("Digite los valores del numerador y denominador para la fraccion 2")
      val num2 = leer.nextDouble()
      val den2 = leer.nextDouble()
      val nr2: NumeroRacional = new NumeroRacional(num2, den2)

      val nr3: NumeroRacional = nr1.suma(nr2)
      printf("Suma\n%s\n\n", nr3.toString)

      val nr4: NumeroRacional = nr1.resta(nr2)
      printf("Resta\n%s\n\n", nr4.toString)

      val nr5: NumeroRacional = nr1.multiplicacion(nr2)
      printf("Multiplicacion\n%s\n\n", nr5.toString)

      val nr6: NumeroRacional = nr1.division(nr2)
      printf("Division\n%s\n\n", nr6.toString)

   }
}

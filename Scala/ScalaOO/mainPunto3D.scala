// Operaciones con Puntos3D

import java.util.Scanner

object mainPunto3D {
   def main(args: Array[String]): Unit = {
      val leer:Scanner = new Scanner(System.in)

      println("Digite los valores de X, Y y Z para el punto 1")
      val x1 = leer.nextDouble()
      val y1 = leer.nextDouble()
      val z1 = leer.nextDouble()
      val p1: Punto3D = new Punto3D(x1, y1, z1)

      println("Digite los valores de X, Y y Z para el punto 2")
      val x2 = leer.nextDouble()
      val y2 = leer.nextDouble()
      val z2 = leer.nextDouble()
      val p2: Punto3D = new Punto3D(x2, y2, z2)

      val p3: Punto3D = p1.suma(p2)
      println("Suma: " + p3.toString)

      val p4: Punto3D = p1.resta(p2)
      println("Resta: " + p4.toString)

      val p5: Punto3D = p1.producto(p2)
      println("Producto: " + p5.toString)

   }
}

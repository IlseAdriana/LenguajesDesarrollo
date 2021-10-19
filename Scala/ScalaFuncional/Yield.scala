/* Generación de una lista por medio del operador yield,
   cuyos resultados son obtenidos de la operación x^2 + y^2 + z^2 */

object Yield {

   def main(args: Array[String]): Unit = {

      var puntos: List[Punto3D] = List()
      puntos = puntos :+ Punto3D(1.0, 6.5, 2.0)
      puntos = puntos :+ Punto3D(3.5, 7.0, 1.0)
      puntos = puntos :+ Punto3D(8.0, 1.0, 4.5)
      puntos = puntos :+ Punto3D(1.0, 5.0, 9.0)
      puntos = puntos :+ Punto3D(6.25, 2.25, 3.5)

      val resultados = for (i <- puntos.indices) yield { funcion(puntos(i)) }
      println("Lista resultante: " + resultados)
      println("Lista resultante ordenada: " + resultados.sorted)
   }

   // Función que realiza la operación solicitada
   def funcion(punto: Punto3D): Double = (punto.x * punto.x) + (punto.y * punto.y) + (punto.z * punto.z)
}

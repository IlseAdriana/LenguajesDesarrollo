/* Generación de una lista por medio del operador yield,
   cuyos resultados son obtenidos de la operación x^2 + y^2 + z^2 */

case class Punto3D(x: Double, y: Double, z: Double) extends Ordered[Punto3D] {

   override def compare(obj: Punto3D): Int = {
      if (this > obj) 1
      else if (this < obj) -1
      else 0
   }
}

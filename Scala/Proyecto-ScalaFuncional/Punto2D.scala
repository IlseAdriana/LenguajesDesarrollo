// Método Nelder-Mead con Programación Funcional

case class Punto2D(x: Double, y: Double, func:Punto2D => Double) {

   // Valor resultante después de realizar la función
   val fit:Double = func(this)

   def sumPto(punto: Punto2D): Punto2D = Punto2D(this.x + punto.x, this.y + punto.y, this.func)

   def resPto(punto: Punto2D): Punto2D = Punto2D(this.x - punto.x, this.y - punto.y, this.func)

   def divPto(punto: Punto2D): Punto2D = Punto2D((this.x + punto.x) / 2, (this.y + punto.y) / 2, this.func)

   override def toString: String = s"B = ($x, $y), f(B) = $fit"
}

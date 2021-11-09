// Método Nelder-Mead con Programación Funcional

object Expansion {

   def mov(R: Punto2D, M: Punto2D): Punto2D = R.sumPto(R.resPto(M))

}

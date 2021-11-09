// Método Nelder-Mead con Programación Funcional

object Algoritmo {

   def algoritmo(func: Punto2D => Double):Punto2D = {
      val V1 = Punto2D(0.0, 0.0, func)
      val V2 = Punto2D(1.2, 0.0, func)
      val V3 = Punto2D(0.0, 0.8, func)

      // Función para ordenar los vertices con base en el valor de fit
      def ordenarV(p1: Punto2D, p2: Punto2D): Boolean = {
         if (p1.fit < p2.fit) true
         else false
      }

      /* Creamos una lista para realizar más rápido el proceso de ordenamiento,
         y posteriormente asignarlos a las variables B, G y W */
      val puntosIniciales: List[Punto2D] = List(V1, V2, V3).sortWith(ordenarV)

      var B: Punto2D = puntosIniciales(0)
      var G: Punto2D = puntosIniciales(1)
      var W: Punto2D = puntosIniciales(2)

      // Función cuyo valor se utilizará como criterio de paro
      def distancia(p1: Punto2D, p2: Punto2D): Double = {
         Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2))
      }

      /* Ciclo que realizará las operaciones y se detendrá hasta que el valor resultante
         de distancia sea > 0.001 */
      while(distancia(B, W) > 0.001 ) {
         // Creamos el reflejo del punto W; y para ello, determinamos el punto medio primero
         val M = PuntoMedio.mov(B, G)
         val R = Reflejo.mov(M, W)

         // Inicia algoritmo
         if (R.fit < G.fit) { /* Realizamos caso 1 (reflejo o expansión) */
            if (B.fit < R.fit) W = R // Aceptamos el reflejo
            else {
               val E = Expansion.mov(R, M)
               if (E.fit < B.fit) W = E // Realizamos la expansión
               else W = R // Nos quedamos con en reflejo
            }
         } else { /* Realizamos caso 2 (contracción o reducción) */
            if (R.fit < W.fit) W = R // Aceptamos el reflejo
            val C = Contraccion.mov(W, M)
            if (C.fit < W.fit) W = C // Realizamos contracción
            else {
               val S = Reduccion.mov(B, W)
               W = S
               G = M
            }
         }
         /* Creamos una nueva lista con los puntos finales ordenados,
         para posteriormente asignarlos a las variables B, G y W */
         val puntosFinales: List[Punto2D] = List(B, G, W).sortWith(ordenarV)
         B = puntosFinales(0)
         G = puntosFinales(1)
         W = puntosFinales(2)
      }
      B // Regresamos el valor mínimo obtenido
   }

}

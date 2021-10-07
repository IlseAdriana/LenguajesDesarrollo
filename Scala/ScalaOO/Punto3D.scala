// Operaciones con Puntos3D

class Punto3D(val X: Double, val Y: Double, val Z: Double) {

   def suma(puntoExt: Punto3D): Punto3D = { new Punto3D(this.X + puntoExt.X, this.Y + puntoExt.Y, this.Z + puntoExt.Z) }

   def resta(puntoExt: Punto3D): Punto3D = { new Punto3D(this.X - puntoExt.X, this.Y - puntoExt.Y, this.Z - puntoExt.Z) }

   def producto(puntoExt: Punto3D): Punto3D = { new Punto3D(this.X * puntoExt.X, this.Y * puntoExt.Y, this.Z * puntoExt.Z) }

   override def toString: String = s"X = $X, Y = $Y, Z = $Z"
}

// Operaciones con Numeros Racionales

class NumeroRacional(val num: Double, val den: Double) {

   require(this.den != 0)

   def suma(racionalExt: NumeroRacional): NumeroRacional = {
      val numerador = this.num * racionalExt.den + this.den * racionalExt.num
      val denominador = this.den * racionalExt.den
      new NumeroRacional(numerador, denominador)
   }

   def resta(racionalExt: NumeroRacional): NumeroRacional = {
      val numerador = this.num * racionalExt.den - this.den * racionalExt.num
      val denominador = this.den * racionalExt.den
      new NumeroRacional(numerador, denominador)
   }

   def multiplicacion(racionalExt: NumeroRacional): NumeroRacional = {
      val numerador = this.num * racionalExt.num
      val denominador = this.den * racionalExt.den
      new NumeroRacional(numerador, denominador)
   }

   def division(racionalExt: NumeroRacional): NumeroRacional = {
      val numerador = this.num * racionalExt.den
      val denominador = this.den * racionalExt.num
      new NumeroRacional(numerador, denominador)
   }

   def toDecimal: Double = { this.num / this.den}

   override def toString: String = s"$num / $den es lo mismo que $toDecimal"

}

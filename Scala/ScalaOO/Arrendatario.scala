// Herencia con Objetos Persona

class Arrendatario (rfc: String, nombre: String, aPaterno: String, aMaterno: String, edad: Int,
                    val numContrato: Int, val antig: Int) extends Persona(rfc, nombre, aPaterno, aMaterno, edad)
                    with ControlBandera {

   var atrasado: Boolean = true

   override def estaAtrasado(estado: Boolean): Unit = {
      this.atrasado = estado
   }

   override def toString: String = s"Arrendatario\n$mostrarDatos\nNombre: $nombre $aPaterno $aMaterno\n" +
     s"Num. Contrato: $numContrato\nAntigüedad: $antig\nAtrasado: $atrasado"
}

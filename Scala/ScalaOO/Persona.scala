// Herencia con Objetos Persona

abstract class Persona(val rfc: String, val nombre: String, val aPaterno: String,
                           val aMaterno: String, val edad: Int) {

   def mostrarDatos():String = { s"RCF: $rfc\nEdad: $edad" }
}

// Herencia con Objetos Persona

class Propietario(rfc: String, nombre: String, aPaterno: String, aMaterno: String, edad: Int,
                  val direccion: String, val tel: String) extends Persona(rfc, nombre, aPaterno, aMaterno, edad) {

   override def toString: String = s"Propietario\n$mostrarDatos\nNombre: $nombre $aPaterno $aMaterno\n" +
                                       s"Direccion: $direccion\nTelefono: $tel\n"
}

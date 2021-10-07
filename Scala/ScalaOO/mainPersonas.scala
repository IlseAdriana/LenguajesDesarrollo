// Herencia con Objetos Persona

object mainPersonas {
   def main(args: Array[String]): Unit = {
   
      val propietario: Propietario = new Propietario("MSC40", "Michael", "Scott", "Carell", 40, "Scranton", "1234567")

      val arrendatario: Arrendatario = new Arrendatario("JHK30", "Jim", "Halpert", "Krasinski", 30, 2, 12)

      println(propietario.toString)

      arrendatario.atrasado = false;
      println(arrendatario.toString)
   }
}

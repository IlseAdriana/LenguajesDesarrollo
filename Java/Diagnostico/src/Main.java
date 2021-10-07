import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        Restaurantes listaRestaurantes = new Restaurantes();

        Integer opcion = 0;
        while (true) {   
            System.out.println("\nCatálogo de Restaurantes");
            try {
                System.out.println("Elija una opción:\n 1. Capturar\n 2. Buscar\n 3. Eliminar\n 4. Mostrar lista\n 5. Salir");
                System.out.print("Opción: "); 
                opcion = leer.nextInt();
            } catch (InputMismatchException imEx) {
                System.out.println("Error, el dato ingresado no es un número entero");
                leer.nextLine();
                continue;
            }

            if(opcion == 5) {
                break;
            }

            switch(opcion) {
                case 1:
                    listaRestaurantes.capturar();
                    break;
                case 2:
                    listaRestaurantes.buscar();
                    break;
                case 3:
                    listaRestaurantes.eliminar();
                    break;
                case 4:
                    listaRestaurantes.mostrar();
                    break;
                default: 
                    System.out.println("Digite una opcion válida");
            }
        }
        leer.close();
    }
}
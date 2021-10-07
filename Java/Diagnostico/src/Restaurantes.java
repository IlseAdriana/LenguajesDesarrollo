import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Restaurantes {
    // Atributos
    private ArrayList<Restaurante> restaurantes = new ArrayList<>();
    private Scanner leer = new Scanner(System.in);

    // Métodos
        // Getters y Setters
    public ArrayList<Restaurante> getRestaurantes() {
        return restaurantes;
    }
    public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

        // Otros
    public int obtenerPosicion(Integer id) {
        for (int i = 0; i < restaurantes.size(); i++) {
            if (restaurantes.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void capturar() {
        try {
            System.out.print("Digite el Id del restaurante: ");
            Integer id = leer.nextInt();

            if (obtenerPosicion(id) == -1) {
                System.out.print("Digite el número de mesas: ");
                Integer numMesas = leer.nextInt();
                leer.nextLine();
                System.out.print("Digite el horario de atención: ");
                String horario = leer.nextLine();
                System.out.print("Digite la especialidad: ");
                String especialidad = leer.nextLine();
                restaurantes.add(new Restaurante(id, numMesas, horario, especialidad));
                System.out.println("El restaurante se capturó correctamente");
            } else {
                System.out.println("El Id ya existe");
            }

        } catch (Exception ex) {
            System.out.println("Ocurrio un error, la información no fue capturada");
            leer.nextLine();
        }
    }

    public void buscar() {
        if (!restaurantes.isEmpty()) {
            System.out.print("Digite la especialidad del restaurante que desea consultar: ");
            String especBuscar = leer.nextLine();
            int posicion = -1;

            for (int i = 0; i < restaurantes.size(); i++) {
                if (restaurantes.get(i).getEspecialidad().toLowerCase().equals(especBuscar.toLowerCase())) {
                    posicion = i;
                } 
            }

            if (posicion != -1) {
                System.out.println("\n-------------------------");
                System.out.println(restaurantes.get(posicion).toString());
                System.out.println("-------------------------");
            } else {
                System.out.println("No hay ningún restaurante con esa especialidad");
            }

        } else {
            System.out.println("No hay restaurantes registrados");
        }
    }

    public void eliminar() throws Exception {
        if (!restaurantes.isEmpty()) {

            try {
                System.out.print("Digite el Id del restaurante que desea dar de baja: ");
                Integer idEliminar = leer.nextInt();
                int posicion = obtenerPosicion(idEliminar);

                if (posicion != -1) {
                    restaurantes.remove(posicion);
                    System.out.println("El restaurante se dio de baja con éxito");
                } else {
                    System.out.println("El Id no está registrado");
                }
            } catch (Exception ex) {
                throw new Exception("Ocurrió un error, el restaurante no se pudo dar de baja");
            }

        } else {
            System.out.println("No hay restaurantes registrados");
        }
    }

    public void mostrar() {
        if (!restaurantes.isEmpty()) {

            Collections.sort(restaurantes);
            for (Restaurante restaurante : restaurantes) {
                System.out.println("\n-------------------------");
                System.out.println(restaurante);
                System.out.println("-------------------------");
            }

        } else {
            System.out.println("No hay restaurantes registrados");
        }
    }
}
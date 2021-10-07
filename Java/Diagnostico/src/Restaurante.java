public class Restaurante implements Comparable<Restaurante> {
    // Atributos
    private Integer id;
    private Integer numMesas;
    private String horario;
    private String especialidad;

    // Métodos
        // Constructores
    public Restaurante() {}

    public Restaurante(Integer id, Integer numMesas, String horario, String especialidad) {
        this.id = id;
        this.numMesas = numMesas;
        this.horario = horario;
        this.especialidad = especialidad;
    }

        // Getters y Setters
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumMesas() {
        return numMesas;
    }
    public void setNumMesas(Integer numMesas) {
        this.numMesas = numMesas;
    }

    public String getHorario() {
        return horario;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String espec) {
        this.especialidad = espec;
    }

        // Otros
    @Override
    public String toString() {
        return String.format("Restaurante No. %d\nEspecialidad: %s\nNúmero de mesas: %d\nHorario de atención: %s", id, especialidad, numMesas, horario);
    }

    @Override
    public int compareTo(Restaurante o) {
        return id.compareTo(o.id);
    }
}

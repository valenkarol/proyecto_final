package co.edu.uniquindio.poo;

public class Puesto {
    // Coordenada i (fila) del puesto en la matriz del parqueadero.
    private int i;
    // Coordenada j (columna) del puesto en la matriz del parqueadero.
    private int j;
    // Vehículo que ocupa el puesto, si está ocupado.
    private Vehiculo vehiculo;

    /**
     * Constructor de la clase Puesto.
     *
     * @param i Coordenada i (fila) del puesto.
     * @param j Coordenada j (columna) del puesto.
     */
    public Puesto(int i, int j) {
        assert i >= 0 : "La coordenada i debe ser mayor o igual a cero";
        assert j >= 0 : "La coordenada j debe ser mayor o igual a cero";
        
        this.i = i;
        this.j = j;
        this.vehiculo = null;
    }

    /**
     * Obtiene la coordenada i (fila) del puesto.
     *
     * @return La coordenada i del puesto.
     */
    public int getI() {
        return i;
    }

    /**
     * Obtiene la coordenada j (columna) del puesto.
     *
     * @return La coordenada j del puesto.
     */
    public int getJ() {
        return j;
    }

    /**
     * Verifica si el puesto está ocupado por un vehículo.
     *
     * @return true si el puesto está ocupado, false en caso contrario.
     */
    public boolean estaOcupado() {
        return vehiculo != null;
    }

    /**
     * Ocupa el puesto con un vehículo.
     *
     * @param vehiculo Vehículo que ocupará el puesto.
     */
    public void ocuparPuesto(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * Libera el puesto, dejándolo vacío.
     */
    public void liberarPuesto() {
        this.vehiculo = null;
    }

    /**
     * Obtiene el vehículo que ocupa el puesto.
     *
     * @return El vehículo que ocupa el puesto, o null si está vacío.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}
package co.edu.uniquindio.poo;

public class Administrador {
    private final String nombre;
    private double tarifaEstacionamiento;

    public Administrador(String nombre, double tarifaInicial) {
        assert nombre != null && !nombre.isBlank() : "El nombre debe ser diferente de null";
        assert tarifaInicial > 0 : "La tarifa inicial debe ser mayor que 0";

        this.nombre = nombre;
        this.tarifaEstacionamiento = tarifaInicial;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para modificar la tarifa de estacionamiento
    public void setTarifaEstacionamiento(double nuevaTarifa) {
        assert nuevaTarifa > 0 : "La nueva tarifa debe ser mayor que 0";
        tarifaEstacionamiento = nuevaTarifa;
    }

    // Método para obtener la tarifa de estacionamiento actual
    public double getTarifaEstacionamiento() {
        return tarifaEstacionamiento;
    }
}
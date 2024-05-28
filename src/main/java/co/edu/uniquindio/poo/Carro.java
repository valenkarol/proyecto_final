package co.edu.uniquindio.poo;

/**
 * La clase Carro representa un tipo de Vehiculo específico.
 * Esta clase hereda de la clase Vehiculo y añade una tarifa por hora específica para los carros.
 */
public class Carro extends Vehiculo {
    

    // Tarifa por hora específica para los carros.
    private static double tarifaPorHora;

    /**
     * Constructor de la clase Carro.
     *
     * @param placa La placa del carro.
     * @param modelo El modelo del carro.
     * @param propietario El propietario del carro.
     */
    public Carro(String placa, String modelo, Propietario propietario) {
        super(placa, modelo, propietario);
    }

    /**
     * Establece la tarifa por hora para los carros.
     *
     * @param tarifa La tarifa por hora a establecer.
     * @throws IllegalArgumentException si la tarifa es negativa.
     */
    public static void setTarifaPorHora(double tarifa) {
        assert tarifa >= 0 : "La tarifa por hora no puede ser negativa";
        tarifaPorHora = tarifa;
    }

    /**
     * Obtiene la tarifa por hora para los carros.
     *
     * @return La tarifa por hora.
     */
    @Override
    public double getTarifaPorHoraVehiculo() {
        return tarifaPorHora;
    }
}

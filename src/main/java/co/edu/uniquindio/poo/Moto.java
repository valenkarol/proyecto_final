package co.edu.uniquindio.poo;

package co.edu.uniquindio.poo;

/**
 * La clase Moto representa un tipo de Vehiculo específico.
 * Esta clase hereda de la clase Vehiculo y añade propiedades y tarifas específicas para las motos.
 */
public class Moto extends Vehiculo {
    // El tipo de moto (CLASICA o HIBRIDA).
    private TipoMoto tipoMoto;
    // La velocidad máxima de la moto.
    private double velocidadMaxima;
    // Tarifa por hora para motos clásicas.
    private static double tarifaClasica;
    // Tarifa por hora para motos híbridas.
    private static double tarifaHibrida;

    /**
     * Constructor de la clase Moto.
     *
     * @param placa La placa de la moto.
     * @param modelo El modelo de la moto.
     * @param propietario El propietario de la moto.
     * @param tipoMoto El tipo de la moto (CLASICA o HIBRIDA).
     * @param velocidadMaxima La velocidad máxima de la moto.
     */
    public Moto(String placa, String modelo, Propietario propietario, TipoMoto tipoMoto, double velocidadMaxima) {
        super(placa, modelo, propietario);
        assert velocidadMaxima >= 0 : "La velocidad máxima no puede ser negativa";
        this.tipoMoto = tipoMoto;
        this.velocidadMaxima = velocidadMaxima;
    }

    /**
     * Obtiene el tipo de moto.
     *
     * @return El tipo de moto.
     */
    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    /**
     * Obtiene la velocidad máxima de la moto.
     *
     * @return La velocidad máxima.
     */
    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    /**
     * Establece la tarifa por hora para las motos clásicas.
     *
     * @param tarifa La tarifa por hora a establecer para las motos clásicas.
     */
    public static void setTarifaClasica(double tarifa) {
        assert tarifa >= 0 : "La tarifa para motos clásicas no puede ser negativa";
        tarifaClasica = tarifa;
    }

    /**
     * Establece la tarifa por hora para las motos híbridas.
     *
     * @param tarifa La tarifa por hora a establecer para las motos híbridas.
     */
    public static void setTarifaHibrida(double tarifa) {
        assert tarifa >= 0 : "La tarifa para motos híbridas no puede ser negativa";
        tarifaHibrida = tarifa;
    }

    /**
     * Obtiene la tarifa por hora para las motos, dependiendo de su tipo.
     *
     * @return La tarifa por hora.
     */
    @Override
    public double getTarifaPorHoraVehiculo() {
        return tipoMoto == TipoMoto.CLASICA ? tarifaClasica : tarifaHibrida;
    }
}
package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

/**
 * La clase Registro representa el registro de la entrada y salida de un vehículo en un puesto del parqueadero.
 * Contiene información sobre el vehículo, el puesto, la hora de ingreso y la hora de salida.
 */
public class Registro {
    private Vehiculo vehiculo;
    private Puesto puesto;
    private LocalDateTime horaIngreso;
    private LocalDateTime horaSalida;

    /**
     * Constructor de la clase Registro.
     *
     * @param vehiculo Vehículo registrado.
     * @param puesto Puesto ocupado por el vehículo.
     */
    public Registro(Vehiculo vehiculo, Puesto puesto) {
        assert vehiculo != null : "El vehículo no puede ser nulo";
        assert puesto != null : "El puesto no puede ser nulo";

        this.vehiculo = vehiculo;
        this.puesto = puesto;
        this.horaIngreso = LocalDateTime.now();
    }

    /**
     * Obtiene el vehículo registrado.
     *
     * @return El vehículo registrado.
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * Obtiene el puesto ocupado por el vehículo.
     *
     * @return El puesto ocupado.
     */
    public Puesto getPuesto() {
        return puesto;
    }

    /**
     * Obtiene la hora de ingreso del vehículo.
     *
     * @return La hora de ingreso.
     */
    public LocalDateTime getHoraIngreso() {
        return horaIngreso;
    }

    /**
     * Obtiene la hora de salida del vehículo.
     *
     * @return La hora de salida, o null si el vehículo aún no ha salido.
     */
    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    /**
     * Establece la hora de salida del vehículo.
     *
     * @param horaSalida La hora de salida a establecer.
     */
    public void setHoraSalida(LocalDateTime horaSalida) {
        assert horaSalida != null : "La hora de salida no puede ser nula";

        this.horaSalida = horaSalida;
    }

    /**
     * Calcula el costo del estacionamiento en base a la duración de la estancia y la tarifa por hora del vehículo.
     *
     * @return El costo del estacionamiento, o 0 si el vehículo aún no ha salido.
     */
    
     public double calcularCosto() {
        double costo = 0.0;
        if (horaSalida != null){
            long horas = java.time.Duration.between(horaIngreso, horaSalida).toSeconds();
            costo = horas * vehiculo.getTarifaPorHoraVehiculo();
        }
        return costo;
    }
}
    
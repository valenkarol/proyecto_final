package co.edu.uniquindio.poo;

import java.time.Duration;
import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime fechaEntrada;
    private LocalDateTime fechaSalida;
    private final Vehiculo vehiculo;
    private final Puesto puesto;

    public Registro(LocalDateTime fechaEntrada, LocalDateTime fechaSalida, Vehiculo vehiculo, Puesto puesto){
        this.fechaEntrada=fechaEntrada;
        this.fechaSalida=fechaSalida;
        this.vehiculo=vehiculo;
        this.puesto=puesto;
    }
    public long calcularMinutosEstacionamiento() {
        Duration duration = Duration.between(fechaEntrada, fechaSalida);
        return duration.toMinutes();
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public Puesto getPuesto() {
        return puesto;
    }
    
    public double calcularCosto() {
        long minutosEstacionamiento = calcularMinutosEstacionamiento();
        double tarifaPorHoraCarro = 0.0;

        for (Vehiculo vehiculo : carro) {
    
        } 
        }

        double costoTotal = (minutosEstacionamiento / 60.0) * tarifaPorHora;
        return costoTotal;
    }

    
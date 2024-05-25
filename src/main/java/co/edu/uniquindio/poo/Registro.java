package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public record Registro(LocalDateTime fechaIngreso, LocalDateTime fechaSalida) {
    public Registro {
        assert fechaIngreso != null;
        assert fechaSalida != null;
    }

    public LocalDateTime fechaIngreso() {
        return fechaIngreso;
    }

    public LocalDateTime fechaSalida() {
        return fechaSalida;
    }

}

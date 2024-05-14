package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

public record Registro(LocalDateTime fecha) {
    public Registro{
        assert fecha!=null;
    }

    public LocalDateTime fecha() {
        return fecha;
    }

}

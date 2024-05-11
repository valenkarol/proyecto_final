package co.edu.uniquindio.poo;

import java.time.LocalDate;

public record Registro(LocalDate fecha) {
    public Registro{
        assert fecha!=null;
    }

    public LocalDate fecha() {
        return fecha;
    }

}

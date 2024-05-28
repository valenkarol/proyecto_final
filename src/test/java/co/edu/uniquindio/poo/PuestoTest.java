package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    @Test
    public void testCrearPuesto() {
        LOG.info("Iniciando Test");

        Puesto puesto = new Puesto(3, 5);
        assertEquals(3, puesto.getI());
        assertEquals(5, puesto.getJ());
        assertFalse(puesto.estaOcupado());
        assertNull(puesto.getVehiculo());

        LOG.info("Finalizando Test");
    }

     @Test
    public void testCrearPuestoConCoordenadaNegativaI() {
        LOG.info("Iniciando Test");

        Throwable exception = assertThrows(AssertionError.class, () -> new Puesto(-1, 5));
        assertEquals("La coordenada i debe ser mayor o igual a cero", exception.getMessage());

        LOG.info("Finalizando Test");
    }

    @Test
    public void testCrearPuestoConCoordenadaNegativaJ() {
        LOG.info("Iniciando Test");

        Throwable exception = assertThrows(AssertionError.class, () -> new Puesto(3, -1));
        assertEquals("La coordenada j debe ser mayor o igual a cero", exception.getMessage());

        LOG.info("Finalizando Test");
    }

}

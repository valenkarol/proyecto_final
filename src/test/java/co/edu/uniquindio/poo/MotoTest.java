package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class MotoTest {
    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());

    @Test
    public void VelocidadMotoNegativo() {
        LOG.info("inicio test VelocidadMotoNegativo");

        assertThrows(Throwable.class, () -> new Moto("kawasaki", "123456", (short)-200));

        LOG.info("finalización test VelocidadMotoNegativo");
    }

      @Test
    public void crearMotoConValoresPositivos() {
        LOG.info("Iniciando Test");

        Propietario propietario = new Propietario("Juan", "123456789");
        Moto moto = new Moto("ABC123", "Yamaha", propietario, TipoMoto.CLASICA, 150.0);
        
        assertEquals("ABC123", moto.getPlaca());
        assertEquals("Yamaha", moto.getModelo());
        assertEquals(propietario, moto.getPropietario());
        assertEquals(TipoMoto.CLASICA, moto.getTipoMoto());
        assertEquals(150.0, moto.getVelocidadMaxima(), 0.001); // Utilizamos un delta pequeño para la comparación de valores double

        LOG.info("Finalizando Test");

    }
}

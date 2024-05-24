package co.edu.uniquindio.poo;

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
}

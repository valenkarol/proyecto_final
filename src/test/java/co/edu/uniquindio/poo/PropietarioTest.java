package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PropietarioTest {
    private static final Logger LOG = Logger.getLogger(PropietarioTest.class.getName());

    @Test
    public void DatosCompletos() {
        LOG.info("iniciación test DatosCompletos");

        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139",
                (byte) 51);

        assertEquals("julian", propietario.getNombre());
        assertEquals("gutierrez", propietario.getApellido());
        assertEquals("1004915388", propietario.getId());
        assertEquals("jugutier@gmail.com", propietario.getCorreo());
        assertEquals("3124874139", propietario.getNumero());
        assertEquals(51, propietario.getEdad());

        LOG.info("finalización test DatosCompletos");
    }

    @Test
    public void DatosNulos() {
        LOG.info("iniciación test DatosNulos");

        assertThrows(Throwable.class, () -> new Propietario(null, null, null, null, null, (byte) 51));

        LOG.info("finalización test DatosNulos");
    }

    @Test
    public void DatosVacíos() {
        LOG.info("iniciación test DatosVacíos");

        assertThrows(Throwable.class, () -> new Propietario("", "", "1004915388", "jugutier@gmail.com", "", (byte) 51));

        LOG.info("finalización test DatosVacíos");
    }

    @Test
    public void EdadNegativa() {
        LOG.info("iniciación test EdadNegativa");

        assertThrows(Throwable.class, () -> new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com",
                "3124874139", (byte) -51));

        LOG.info("finalización test EdadNegativa");
    }

    @Test
    public void CorreoInvalido() {
        LOG.info("iniciación test CorreoNegativo");

        assertThrows(Throwable.class,
                () -> new Propietario("julian", "gutierrez", "1004915388", "jugutier", "3124874139", (byte) 51));

        LOG.info("finalozación test CorreoInvalido");
    }
}

package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());

    @Test
    public void ObtenerNombre() {
        LOG.info("iniciación test ObtenerNombre");

        var administrador = new Administrador("jaime", 5000.0);

        assertEquals("jaime", administrador.getNombre());

        LOG.info("finalización test ObtenerObjeto");

    }


}

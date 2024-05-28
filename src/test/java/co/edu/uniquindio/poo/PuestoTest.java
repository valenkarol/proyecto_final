package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class PuestoTest {
    private static final Logger LOG = Logger.getLogger(PuestoTest.class.getName());

    //Crear un puesto - datos completos
    @Test
    public void CrearPuesto() {
        LOG.info("Iniciando CrearPuesto");
        var puesto = new Puesto(2, 1);

        assertEquals(2, puesto.getI());
        assertEquals(1, puesto.getJ());

        LOG.info("Finalizando CrearPuesto");
    }

     @Test
    public void DatosNegativos() {
        LOG.info("Iniciando DatosNegativos");

        assertThrows(Throwable.class, () -> new Puesto(-2, 1));
        assertThrows(Throwable.class, () -> new Puesto(2, -1));

        LOG.info("Finalizando DatosNegativos");
    }

}

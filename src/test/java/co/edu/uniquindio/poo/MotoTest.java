package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class MotoTest {
    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());
    private static final Propietario Propietario = null;

    @Test
    public void VelocidadMotoClasicaNegativo() {
        LOG.info("inicio test VelocidadMotoNegativo");

        assertThrows(Throwable.class, () -> new Moto("def456", "kawasaki", Propietario, TipoMoto.CLASICA, -200));

        LOG.info("finalización test VelocidadMotoNegativo");
    }

    @Test
    public void VelocidadMotoHibridaNegativo() {
        LOG.info("inicio test VelocidadMotoNegativo");

        assertThrows(Throwable.class, () -> new Moto("deg456", "akt", Propietario, TipoMoto.HIBRIDA, -200));

        LOG.info("finalización test VelocidadMotoNegativo");
    }

    

      @Test
    public void crearMotoConValoresPositivos() {
        LOG.info("Iniciando Test");

        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte)51);
        var moto = new Moto("def456", "kawasaki", propietario, TipoMoto.CLASICA, 200.0);
        
        assertEquals("def456", moto.getPlaca());
        assertEquals("kawasaki", moto.getModelo());
        assertEquals(propietario, moto.getPropietario());
        assertEquals(TipoMoto.CLASICA, moto.getTipoMoto());
        assertEquals(200.0, moto.getVelocidadMaxima(), 0.001); // Utilizamos un delta pequeño para la comparación de valores double

        LOG.info("Finalizando Test");

    }
}

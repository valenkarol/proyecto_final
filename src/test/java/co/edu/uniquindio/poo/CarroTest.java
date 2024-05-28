package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class CarroTest {
    private static final Logger LOG = Logger.getLogger(CarroTest.class.getName());

    @Test
    public void CrearCarro() {
        LOG.info("Iniciando Test");

        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte)51);
        var carro = new Carro("abc123", "chevrolet", propietario);

        assertEquals("abc123", carro.getPlaca());
        assertEquals("chevrolet", carro.getModelo());
        assertEquals(propietario, carro.getPropietario());

        LOG.info("Finalización CrearCarro");
    }
        
    // Verificamos que el carro no sea nulo
    @Test
    public void DatosNulos() {
        LOG.info("iniciación test DatosNulos");

        assertThrows(Throwable.class, () -> new Carro(null, null, null));

        LOG.info("finalización test DatosNulos");
    }

    //prueba tarifa por hora del carro
    @Test
    public void TarifaHoraVehiculo() {
        LOG.info("Iniciando TarifaHoraVehiculo");

        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte)51);
        var carro = new Carro("abc123", "chevrolet", propietario);
       
        // Configuramos una tarifa por hora válida
        Carro.setTarifaPorHora(2000.0);

        // Verificamos que la tarifa por hora obtenida sea la misma que configuramos
        assertEquals(2000.0, carro.getTarifaPorHoraVehiculo(), 0.0);

        LOG.info("Finalizando Test");
    }

}

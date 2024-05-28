package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class CarroTest {
    private static final Logger LOG = Logger.getLogger(CarroTest.class.getName());

    @Test
    public void testCrearCarro() {
        LOG.info("Iniciando Test");

        // Creamos un propietario
        Propietario propietario = new Propietario("Juan", "123456789");
        // Creamos un carro
        Carro carro = new Carro("ABC123", "Toyota", propietario);
        
        // Verificamos que el carro no sea nulo
        assertNotNull(carro);
        
        // Verificamos que los atributos del carro hayan sido inicializados correctamente
        assertEquals("ABC123", carro.getPlaca());
        assertEquals("Toyota", carro.getModelo());
        assertEquals(propietario, carro.getPropietario());

        LOG.info("Finalizando Test");
    }

    @Test
    public void testGetTarifaPorHoraVehiculo() {
        LOG.info("Iniciando Test");

        // Creamos un propietario
        Propietario propietario = new Propietario("Juan", "123456789");
        // Creamos un carro
        Carro carro = new Carro("ABC123", "Toyota", propietario);
        // Configuramos una tarifa por hora válida
        Carro.setTarifaPorHora(15.0);
        // Verificamos que la tarifa por hora obtenida sea la misma que configuramos
        assertEquals(15.0, carro.getTarifaPorHoraVehiculo(), 0.0);

        LOG.info("Finalizando Test");
    }

}

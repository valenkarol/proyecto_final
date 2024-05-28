package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void VerificarDisponibilidad() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        assertTrue(parqueadero.verificarDisponibilidad(0, 0)); // Comprobar disponibilidad de un puesto vacío
        parqueadero.ubicarVehiculo(0, 0, new Carro("abc123", "Toyota",
                new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51)));
        assertFalse(parqueadero.verificarDisponibilidad(0, 0)); // Comprobar disponibilidad de un puesto ocupado

        LOG.info("Finalizando Test");
    }

    @Test
    public void testUbicarVehiculo() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Vehiculo vehiculo = new Carro("ARC123", "Mazda",
                new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51));
        parqueadero.ubicarVehiculo(0, 0, vehiculo);
        assertFalse(parqueadero.verificarDisponibilidad(0, 0)); // Verificar que el vehículo se ubica correctamente en
                                                                // el puesto

        LOG.info("Finalizando Test");
    }

    @Test
    public void testIdentificarPropietario() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Propietario propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com",
                "3124874139", (byte) 51);
        Carro carro = new Carro("BBC123", "Audi", propietario);
        parqueadero.ubicarVehiculo(0, 0, carro);
        assertEquals(propietario, parqueadero.identificarPropietario(0, 0)); // Verificar identificación del propietario

        LOG.info("Finalizando Test");
    }

    @Test
    public void testLiberarPuesto() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Carro carro = new Carro("ABC123", "Mercedes",
                new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51));
        parqueadero.ubicarVehiculo(0, 0, carro);
        parqueadero.liberarPuesto(0, 0); // Liberar un puesto ocupado
        assertTrue(parqueadero.verificarDisponibilidad(0, 0)); // Verificar que el puesto se libere

        LOG.info("Finalizando Test");
    }

    @Test
    public void testGenerarReporteDiario() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Vehiculo carro = new Carro("ABC123", "Dodge",
                new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51));
        Vehiculo moto = new Moto("XYZ987", "Honda",
                new Propietario("karol", "davila", "1021476290", "karoda@gmail.com", "3217498775", (byte) 18),
                TipoMoto.CLASICA, 100.0);
        parqueadero.ubicarVehiculo(0, 0, carro);
        parqueadero.ubicarVehiculo(1, 1, moto);
        parqueadero.liberarPuesto(0, 0);
        parqueadero.liberarPuesto(1, 1);
        parqueadero.generarReporteDiario();
        assertEquals(0, parqueadero.getTotalRecaudadoDiario(), 0.001); // Verificar que el total recaudado se reinicia
                                                                       // después de generar el reporte diario

        LOG.info("Finalizando Test");
    }

    @Test
    public void testGenerarReporteMensual() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Vehiculo carro = new Carro("ABC123", "Toyota",
                new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51));
        parqueadero.ubicarVehiculo(0, 0, carro);
        parqueadero.liberarPuesto(0, 0);
        parqueadero.generarReporteMensual();
        assertEquals(0, parqueadero.getTotalRecaudadoMensual(), 0.001); // Verificar que el total recaudado se reinicia
                                                                        // después de generar el reporte mensual

        LOG.info("Finalizando Test");
    }

    @Test
    public void testCrearParqueaderoConTamañoNegativo() {
        LOG.info("Iniciando Test");

        assertThrows(Throwable.class, () -> new Parqueadero(-1));

        LOG.info("Finalizando Test");
    }

    @Test
    public void testUbicarVehiculoFueraDeLimites() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        assertThrows(Throwable.class, () -> parqueaderoConLimite3.ubicarVehiculo(5, 2, new Carro("ABC123", "mazda",
                new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51))));

        LOG.info("Finalizando Test");
    }

    @Test
    public void testConfigurarTarifasNegativas() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        try {
            parqueadero.configurarTarifasPorHora(-100, 50, 30);
            fail("Se esperaba una excepción debido a la tarifa negativa para carros.");
        } catch (AssertionError e) {
            // Se espera una excepción
        }

        LOG.info("Finalizando Test");
    }

    @Test
    public void testIdentificarPropietarioPuestoVacio() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        // Comprobamos que la función identificarPropietario para un puesto vacío
        // devuelve null
        Propietario propietario = parqueadero.identificarPropietario(1, 1);
        if (propietario != null) {
            fail("Se esperaba que el puesto estuviera vacío y no tuviera propietario.");
        }

        LOG.info("Finalizando Test");
    }
}

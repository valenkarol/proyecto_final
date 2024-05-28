package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;


public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

     //prueba para verificar la disponibilidad de un puesto
    @Test
    public void VerificarDisponibilidad() {
        LOG.info("Iniciando VerificarDisponibilidad");

        var parqueadero = new Parqueadero(3);
        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139",
        (byte) 51);

        assertTrue(parqueadero.verificarDisponibilidad(1, 2)); // Comprobar disponibilidad de un puesto vacío

        parqueadero.ubicarVehiculo(1, 2, new Carro("abc123", "chevrolet", propietario));
        
        assertFalse(parqueadero.verificarDisponibilidad(1, 2)); // Comprobar disponibilidad de un puesto ocupado

        LOG.info("Finalizando VerificarDisponibilidad");
    }

    //prueba para ubicar un vehiculo

    @Test
    public void UbicarVehiculo() {
        LOG.info("Iniciando UbicarVehiculo");

        var parqueadero = new Parqueadero(3);
        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51);
        var vehiculo = new Carro("abc123", "chevrolet", propietario);
        parqueadero.ubicarVehiculo(2, 2, vehiculo);
        assertFalse(parqueadero.verificarDisponibilidad(2, 2)); // Verificar que el vehículo se ubica correctamente en rl puesto

        LOG.info("Finalizando Test");
    }

    //prueba para identificar un propietario
    @Test
    public void IdentificarPropietario() {
        LOG.info("Iniciando IdentificarPropietario");

        var parqueadero = new Parqueadero(3);
        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com",
                "3124874139", (byte) 51);
        var carro = new Carro("abc123", "chevrolet", propietario);
        parqueadero.ubicarVehiculo(1, 1, carro);

        assertEquals(propietario, parqueadero.identificarPropietario(1, 1)); // Verificar identificación del propietario

        LOG.info("Finalizando IdentificarPropietario");
    }
    
    //prueba para poder liberar un puesto
    @Test
    public void LiberarPuesto() {
        LOG.info("Iniciando LiberarPuesto");

        var parqueadero = new Parqueadero(3);
        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51);
        var carro = new Carro("abc123", "chevrolet", propietario);

        parqueadero.ubicarVehiculo(1, 1, carro);
        parqueadero.liberarPuesto(1, 1); // Liberar un puesto ocupado
        assertTrue(parqueadero.verificarDisponibilidad(1, 1)); // Verificar que el puesto se libere

        LOG.info("Finalizando LiberarPuesto");
    }
    
    //prueba para generar un reporte diario
    @Test
    public void GenerarReporteDiario() {
        LOG.info("Iniciando GenerarReporteDiario");

        var parqueadero = new Parqueadero(3);
        var propietario1 = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51);
        var carro = new Carro("abc123", "chevrolet", propietario1);
        var propietario2 = new Propietario("karol", "davila", "1021476290", "karoda@gmail.com", "3217498775", (byte) 18);
        var moto = new Moto("def456", "kawasaki", propietario2, TipoMoto.CLASICA, 200.0);

        parqueadero.ubicarVehiculo(0, 0, carro);
        parqueadero.ubicarVehiculo(1, 1, moto);
        parqueadero.liberarPuesto(0, 0);
        parqueadero.liberarPuesto(1, 1);
        parqueadero.generarReporteDiario();
        assertEquals(6200.0, parqueadero.getTotalRecaudadoDiario(), 0.001); // Verificar que el total recaudado se reinicia
                                                                       // después de generar el reporte diario

        LOG.info("Finalizando GenerarReporteDiario");
    }

    //Prueba para generar reporte mensual
    @Test
    public void testGenerarReporteMensual() {
        LOG.info("Iniciando ReporteMensual");

        Parqueadero parqueadero = new Parqueadero(3);
        var propietario = new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51);
        Vehiculo carro = new Carro("abc123", "chevrolet", propietario);

        parqueadero.ubicarVehiculo(1, 2, carro);
        parqueadero.liberarPuesto(1, 2);
        parqueadero.generarReporteMensual();
        assertEquals(3500.0, parqueadero.getTotalRecaudadoMensual(), 0.001); // Verificar que el total recaudado se reinicia
                                                                        // después de generar el reporte mensual

        LOG.info("Finalizando ReporteMensual");
    }

    //prueba para que no se cree un parqueadero negativo
    @Test
    public void CrearParqueaderoNegativo() {
        LOG.info("Iniciando CrearParqueaderoNegativo");

        assertThrows(Throwable.class, () -> new Parqueadero(-1));

        LOG.info("Finalizando CrearParqueaderoNegativo");
    }
    

}

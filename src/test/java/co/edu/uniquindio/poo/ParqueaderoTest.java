package co.edu.uniquindio.poo;

/**
 * Unit test for simple App.
 */
public class ParqueaderoTest {
    private static final Logger LOG = Logger.getLogger(ParqueaderoTest.class.getName());

    @Test
    public void testVerificarDisponibilidad() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        assertTrue(parqueadero.verificarDisponibilidad(0, 0)); // Comprobar disponibilidad de un puesto vacío
        parqueadero.ubicarVehiculo(0, 0, new Carro("ABC123", "Toyota", new Propietario("Camilo Sanchez", "1234567890")));
        assertFalse(parqueadero.verificarDisponibilidad(0, 0)); // Comprobar disponibilidad de un puesto ocupado

        LOG.info("Finalizando Test");
    }
    
    @Test
    public void testUbicarVehiculo() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Vehiculo vehiculo = new Carro("ARC123", "Mazda", new Propietario("Juan", "12345"));
        parqueadero.ubicarVehiculo(0, 0, vehiculo);
        assertFalse(parqueadero.verificarDisponibilidad(0, 0)); // Verificar que el vehículo se ubica correctamente en el puesto

        LOG.info("Finalizando Test");
    }

    @Test
    public void testIdentificarPropietario() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Propietario propietario = new Propietario("Cristian Herrera", "1234567890");
        Carro carro = new Carro("BBC123", "Audi", propietario);
        parqueadero.ubicarVehiculo(0, 0, carro);
        assertEquals(propietario, parqueadero.identificarPropietario(0, 0)); // Verificar identificación del propietario

        LOG.info("Finalizando Test");
    }

    @Test
    public void testLiberarPuesto() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Carro carro = new Carro("ABC123", "Mercedes", new Propietario("John Rodriguez", "1234567890"));
        parqueadero.ubicarVehiculo(0, 0, carro);
        parqueadero.liberarPuesto(0, 0); // Liberar un puesto ocupado
        assertTrue(parqueadero.verificarDisponibilidad(0, 0)); // Verificar que el puesto se libere

        LOG.info("Finalizando Test");
    }

    @Test
    public void testGenerarReporteDiario() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Vehiculo carro = new Carro("ABC123", "Dodge", new Propietario("Juan", "12345"));
        Vehiculo moto = new Moto("XYZ987", "Honda", new Propietario("Ana", "67890"), TipoMoto.CLASICA, 100.0);
        parqueadero.ubicarVehiculo(0, 0, carro);
        parqueadero.ubicarVehiculo(1, 1, moto);
        parqueadero.liberarPuesto(0, 0);
        parqueadero.liberarPuesto(1, 1);
        parqueadero.generarReporteDiario();
        assertEquals(0, parqueadero.getTotalRecaudadoDiario(), 0.001); // Verificar que el total recaudado se reinicia después de generar el reporte diario

        LOG.info("Finalizando Test");
    }

    @Test
    public void testGenerarReporteMensual() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        Vehiculo carro = new Carro("ABC123", "Toyota", new Propietario("Juan", "12345"));
        parqueadero.ubicarVehiculo(0, 0, carro);
        parqueadero.liberarPuesto(0, 0);
        parqueadero.generarReporteMensual();
        assertEquals(0, parqueadero.getTotalRecaudadoMensual(), 0.001); // Verificar que el total recaudado se reinicia después de generar el reporte mensual

        LOG.info("Finalizando Test");
    } 

    @Test
    public void testCrearParqueaderoConTamanioNegativo() {
        LOG.info("Iniciando Test");

        try {
            Parqueadero parqueadero = new Parqueadero(-1);
            fail("Se esperaba una excepción debido al tamaño negativo del parqueadero.");
        } catch (AssertionError e) {
            // Se espera una excepción
        }

        LOG.info("Finalizando Test");
    }

    @Test
    public void testUbicarVehiculoFueraDeLimites() {
        LOG.info("Iniciando Test");

        Parqueadero parqueadero = new Parqueadero(3);
        try {
            parqueadero.ubicarVehiculo(5, 2, new Carro("ABC123", "mazda", new Propietario("Juan", "19281928")));
            fail("Se esperaba una excepción debido a la ubicación fuera de los límites del parqueadero.");
        } catch (AssertionError e) {
            // Se espera una excepción
        }

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
        // Comprobamos que la función identificarPropietario para un puesto vacío devuelve null
        Propietario propietario = parqueadero.identificarPropietario(1, 1);
        if (propietario != null) {
            fail("Se esperaba que el puesto estuviera vacío y no tuviera propietario.");
        }

        LOG.info("Finalizando Test");
    }
}

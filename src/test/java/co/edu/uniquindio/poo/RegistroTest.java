package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class RegistroTest {
    private static final Logger LOG = Logger.getLogger(RegistroTest.class.getName());

    @Test
    public void registroConFechaNulaDebeLanzarError() {
        LOG.info("Inicio test registroConFechaNulaDebeLanzarError");

        // Crear objetos necesarios para la prueba
        var parqueadero = new Parqueadero("Parqueadero", (byte) 6, (byte) 6);
        var puesto = new Puesto("2,2");
        var propietario = new Propietario("Julian", "Gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte) 51);
        var carro = new Carro("Chevrolet", "234567");


        var registro= new Registro(fechaEntrada, fechaSalida, carro, puesto);

              // Llamar al método calcularCosto (sustituye con la lógica real)
        double costoCalculado = registro.calcularCosto(fechaEntrada, fechaSalida, puesto);

        // Verificar que el costo calculado sea correcto (sustituye con el valor esperado)
        double costoEsperado = 42.50; // Ejemplo: costo esperado de $42.50
        assertEquals(costoEsperado, costoCalculado, 0.01);
   
    }
}

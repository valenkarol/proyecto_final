package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class AdministradorTest {
    private static final Logger LOG = Logger.getLogger(MotoTest.class.getName());

    @Test
    public void ObtenerNombre() {
        // obtener el nombre correcto del dministrador
        LOG.info("iniciación test ObtenerNombre");

        var administrador = new Administrador("jaime", 5000.0, 4000.0, 3500.0);

        assertEquals("jaime", administrador.getNombre());

        LOG.info("finalización test ObtenerObjeto");

    }

    @Test
    public void setTarifaCarro() {
        // Modificar la tarifa y verificar que la tarifa se haya actualizado correctamente
        LOG.info("Iniciación test setTarifaCarro");

        var administrador = new Administrador("jaime", 5000.0, 4000.0, 3500.0);
        double nuevaTarifaCarro = 6000.0;
        administrador.setTarifaEstacionamientoCarro(nuevaTarifaCarro);
        
        assertEquals(nuevaTarifaCarro, administrador.getTarifaEstacionamientoCarro());

        LOG.info("Finalización test setTarifaCarro");
    }

    @Test
    public void setTarifaMotoHibrida() {
        // Modificar la tarifa y verificar que la tarifa se haya actualizado correctamente
        LOG.info("Iniciación test setTarifaMotoHibrida");

        var administrador = new Administrador("jaime", 5000.0, 4000.0, 3500.0);
        double nuevaTarifaMotoH = 4500.0;
        administrador.setTarifaEstacionamientoMotoH(nuevaTarifaMotoH);
        
        assertEquals(nuevaTarifaMotoH, administrador.getTarifaEstacionamientoMotoH());

        LOG.info("Finalización test setTarifaMotoHibrida");
    }

    @Test
    public void setTarifaMotoClasica() {
        // Modificar la tarifa y verificar que la tarifa se haya actualizado correctamente
        LOG.info("Iniciación test setTarifaMotoClasica");

        var administrador = new Administrador("jaime", 5000.0, 4000.0, 3500.0);
        double nuevaTarifaMotoC = 4000.0;
        administrador.setTarifaEstacionamientoMotoC(nuevaTarifaMotoC);
        
        assertEquals(nuevaTarifaMotoC, administrador.getTarifaEstacionamientoMotoC());

        LOG.info("Finalización test setTarifaMotoClasica");
    }
}

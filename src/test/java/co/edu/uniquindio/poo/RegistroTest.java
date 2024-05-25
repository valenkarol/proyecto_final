package co.edu.uniquindio.poo;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class RegistroTest {
    private static final Logger LOG = Logger.getLogger(RegistroTest.class.getName());

    @Test

    public void RegistroVehiculo (){
        LOG.info("Inicio test RegistroVehiculo");

        var parquedero= new Parqueadero ("parqueadero", (byte)6, (byte)6);
        var puesto= new Puesto ("2,2");
        var propietario= new Propietario("julian", "gutierrez", "1004915388", "jugutier@gmail.com", "3124874139", (byte)51);
        var carro = new Carro("chevrolet", "234567");
        var registro= new Registro(null)


    }
}

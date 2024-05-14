package co.edu.uniquindio.poo;

public enum TipoVehiculo {
    CARRO(2500),
    CLASICA(1500),
    HIBRIDA(2000);

    private final double tarifa;


    private TipoVehiculo(double tarifa) {
        this.tarifa = tarifa;
    }
    
    

        
}

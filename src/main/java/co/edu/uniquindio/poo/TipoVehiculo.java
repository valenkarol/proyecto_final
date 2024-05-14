package co.edu.uniquindio.poo;

public enum TipoVehiculo {
    CARRO(2500),
    CLASICA(1500),
    HIBRIDA(2000);

    private double tarifa;

    private TipoVehiculo(double tarifa) {
        this.tarifa = tarifa;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

}

package co.edu.uniquindio.poo;

public abstract class Vehiculo {
    private final String modelo;
    private final String placa;

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Vehiculo(String modelo, String placa) {
        this.modelo = modelo;
        this.placa = placa;
    }

}

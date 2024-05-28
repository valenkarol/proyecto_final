package co.edu.uniquindio.poo;

public class Tarifas {
    private double tarifaHoraCarro;
    private double tarifaHoraMotoClasica;
    private double tarifaHoraMotoHibrida;

    // Constructor
    public Tarifas(double tarifaHoraCarro, double tarifaHoraMotoClasica, double tarifaHoraMotoHibrida) {
        this.tarifaHoraCarro = tarifaHoraCarro;
        this.tarifaHoraMotoClasica = tarifaHoraMotoClasica;
        this.tarifaHoraMotoHibrida = tarifaHoraMotoHibrida;
    }

    // Métodos Getters y Setters
    public double getTarifaHoraCarro() {
        return tarifaHoraCarro;
    }

    public void setTarifaHoraCarro(double tarifaHoraCarro) {
        this.tarifaHoraCarro = tarifaHoraCarro;
    }

    public double getTarifaHoraMotoClasica() {
        return tarifaHoraMotoClasica;
    }

    public void setTarifaHoraMotoClasica(double tarifaHoraMotoClasica) {
        this.tarifaHoraMotoClasica = tarifaHoraMotoClasica;
    }

    public double getTarifaHoraMotoHibrida() {
        return tarifaHoraMotoHibrida;
    }

    public void setTarifaHoraMotoHibrida(double tarifaHoraMotoHibrida) {
        this.tarifaHoraMotoHibrida = tarifaHoraMotoHibrida;
    }

    // Método para calcular el precio de la tarifa para carro
    public double calcularPrecioTarifaCarro(double horas) {
        return tarifaHoraCarro * horas;
    }

    // Método para calcular el precio de la tarifa para moto
    public double calcularPrecioTarifaMoto(double horas, TipoMoto tipoMoto) {
        if (tipoMoto == TipoMoto.CLASICA) {
            return tarifaHoraMotoClasica * horas;
        } else if (tipoMoto == TipoMoto.HIBRIDA) {
            return tarifaHoraMotoHibrida * horas;
        } else {
            System.out.println("Tipo de moto no válido");
            return 0.0;
        }
    }
}




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
        switch (tipoMoto) {
            case CLASICA:
                return tarifaHoraMotoClasica * horas;
            case HIBRIDA:
                return tarifaHoraMotoHibrida * horas;
            default:
                System.out.println("Tipo de moto no válido");
                return 0.0;
        }
    }

    // Método main para probar la clase
    public static void main(String[] args) {
        Tarifas tarifas = new Tarifas(10.0, 5.0, 7.0);
        double precioCarro = tarifas.calcularPrecioTarifaCarro(2);
        double precioMotoClasica = tarifas.calcularPrecioTarifaMoto(2, TipoMoto.CLASICA);
        double precioMotoHibrida = tarifas.calcularPrecioTarifaMoto(2, TipoMoto.HIBRIDA);
        
        System.out.println("Precio por 2 horas de carro: " + precioCarro);
        System.out.println("Precio por 2 horas de moto clásica: " + precioMotoClasica);
        System.out.println("Precio por 2 horas de moto híbrida: " + precioMotoHibrida);
    }
}



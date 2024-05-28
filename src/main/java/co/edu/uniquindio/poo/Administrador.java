package co.edu.uniquindio.poo;

public class Administrador {
    private final String nombre;
    private double tarifaEstacionamientoCarro;
    private double tarifaEstacionamientoMotoH;
    private double tarifaEstacionamientoMotoC;

    public Administrador(String nombre, double tarifaInicialCarro, double tarifaInicialMotoH, double tarifaInicialMotoC) {
        assert nombre != null && !nombre.isBlank() : "El nombre debe ser diferente de null";
        assert tarifaInicialCarro > 0 : "La tarifa inicial para carro debe ser mayor que 0";
        assert tarifaInicialMotoC > 0 : "La tarifa inicial para moto clásica debe ser mayor que 0";
        assert tarifaInicialMotoH > 0 : "La tarifa inicial para moto híbrida debe ser mayor que 0";

        this.nombre = nombre;
        this.tarifaEstacionamientoCarro = tarifaInicialCarro;
        this.tarifaEstacionamientoMotoH = tarifaInicialMotoH;
        this.tarifaEstacionamientoMotoC = tarifaInicialMotoC;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTarifaEstacionamientoCarro(double nuevaTarifaCarro) {
        if (nuevaTarifaCarro > 0) {
            this.tarifaEstacionamientoCarro = nuevaTarifaCarro;
        } else {
            System.out.println("La tarifa debe ser mayor que 0.");
        }
    }

    public void setTarifaEstacionamientoMotoH(double nuevaTarifaMotoH) {
        if (nuevaTarifaMotoH > 0) {
            this.tarifaEstacionamientoMotoH = nuevaTarifaMotoH;
        } else {
            System.out.println("La tarifa debe ser mayor que 0.");
        }
    }

    public void setTarifaEstacionamientoMotoC(double nuevaTarifaMotoC) {
        if (nuevaTarifaMotoC > 0) {
            this.tarifaEstacionamientoMotoC = nuevaTarifaMotoC;
        } else {
            System.out.println("La tarifa debe ser mayor que 0.");
        }
    }

    public double getTarifaEstacionamientoCarro() {
        return tarifaEstacionamientoCarro;
    }

    public double getTarifaEstacionamientoMotoH() {
        return tarifaEstacionamientoMotoH;
    }

    public double getTarifaEstacionamientoMotoC() {
        return tarifaEstacionamientoMotoC;
    }
}
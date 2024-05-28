package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * La clase Parqueadero gestiona los puestos de estacionamiento y los registros de entrada y salida de vehículos.
 * Permite verificar disponibilidad, ubicar vehículos, identificar propietarios y generar reportes diarios y mensuales de recaudación.
 */
public class Parqueadero {
    private int n;
    private Puesto[][] puestos;
    private LinkedList<Registro> registros;
    private double totalRecaudadoDiario;
    private double totalRecaudadoMensual;

    /**
     * Constructor de la clase Parqueadero.
     *
     * @param n Número de filas y columnas del parqueadero.
     */
    public Parqueadero(int n) {
        assert n > 0 : "El número de filas y columnas debe ser mayor que cero.";
        this.n = n;
        this.puestos = new Puesto[n][n];
        this.registros = new LinkedList<>();
        this.totalRecaudadoDiario = 0;
        this.totalRecaudadoMensual = 0;

        for (int i = 0; i < n; i=i+1) {
            for (int j = 0; j < n; j=j+1) {
                puestos[i][j] = new Puesto(i, j);
            }
        }
    }

    /**
     * Obtiene el número de filas y columnas del parqueadero.
     *
     * @return El número de filas y columnas.
     */
    public int getN() {
        return n;
    }

    /**
     * Establece el número de filas y columnas del parqueadero.
     *
     * @param n El número de filas y columnas a establecer.
     */
    public void setN(int n) {
        assert n > 0 : "El número de filas y columnas debe ser mayor que cero.";
        this.n = n;
    }

    /**
     * Obtiene la matriz de puestos en el parqueadero.
     *
     * @return La matriz de puestos.
     */
    public Puesto[][] getPuestos() {
        return puestos;
    }

    /**
     * Establece la matriz de puestos en el parqueadero.
     *
     * @param puestos La matriz de puestos a establecer.
     */
    public void setPuestos(Puesto[][] puestos) {
        assert puestos != null : "La matriz de puestos no puede ser nula.";
        this.puestos = puestos;
    }

    /**
     * Obtiene la lista de registros de vehículos estacionados.
     *
     * @return La lista de registros.
     */
    public LinkedList<Registro> getRegistros() {
        return registros;
    }

    /**
     * Establece la lista de registros de vehículos estacionados.
     *
     * @param registros La lista de registros a establecer.
     */
    public void setRegistros(List<Registro> registros) {
        assert registros != null : "La lista de registros no puede ser nula.";
        this.registros = (LinkedList<Registro>) registros;
    }

    /**
     * Obtiene el total recaudado en el día.
     *
     * @return El total recaudado en el día.
     */
    public double getTotalRecaudadoDiario() {
        return totalRecaudadoDiario;
    }

    /**
     * Establece el total recaudado en el día.
     *
     * @param totalRecaudadoDiario El total recaudado en el día a establecer.
     */
    public void setTotalRecaudadoDiario(double totalRecaudadoDiario) {
        this.totalRecaudadoDiario = totalRecaudadoDiario;
    }

    /**
     * Obtiene el total recaudado en el mes.
     *
     * @return El total recaudado en el mes.
     */
    public double getTotalRecaudadoMensual() {
        return totalRecaudadoMensual;
    }

    /**
     * Establece el total recaudado en el mes.
     *
     * @param totalRecaudadoMensual El total recaudado en el mes a establecer.
     */
    public void setTotalRecaudadoMensual(double totalRecaudadoMensual) {
        this.totalRecaudadoMensual = totalRecaudadoMensual;
    }

    /**
     * Verifica si un puesto específico está disponible.
     *
     * @param i Fila del puesto.
     * @param j Columna del puesto.
     * @return true si el puesto está disponible, false en caso contrario.
     */
    public boolean verificarDisponibilidad(int i, int j) {
        assert i >= 0 && i < n : "La fila está fuera de los límites.";
        assert j >= 0 && j < n : "La columna está fuera de los límites.";
        return !puestos[i][j].estaOcupado();
    }

    /**
     * Ubica un vehículo en un puesto específico si está disponible.
     *
     * @param i         Fila del puesto.
     * @param j         Columna del puesto.
     * @param vehiculo  Vehículo a ubicar.
     */
    public void ubicarVehiculo(int i, int j, Vehiculo vehiculo) {
        assert i >= 0 && i < n : "La fila está fuera de los límites.";
        assert j >= 0 && j < n : "La columna está fuera de los límites.";
        if (verificarDisponibilidad(i, j)) {
            puestos[i][j].ocuparPuesto(vehiculo);
            registros.add(new Registro(vehiculo, puestos[i][j]));
        } else {
            System.out.println("El puesto ya está ocupado.");
        }
    }

    /**
     * Identifica el propietario del vehículo en un puesto específico.
     *
     * @param i Fila del puesto.
     * @param j Columna del puesto.
     * @return El propietario del vehículo, o null si el puesto está vacío.
     */
    public Propietario identificarPropietario(int i, int j) {
        assert i >= 0 && i < n : "La fila está fuera de los límites.";
        assert j >= 0 && j < n : "La columna está fuera de los límites.";
        if (puestos[i][j].estaOcupado()) {
            return puestos[i][j].getVehiculo().getPropietario();
        }
        return null;
    }

    /**
     * Libera un puesto específico y actualiza las recaudaciones diarias y mensuales.
     *
     * @param i Fila del puesto.
     * @param j Columna del puesto.
     */
    public void liberarPuesto(int i, int j) {
        assert i >= 0 && i < n : "La fila está fuera de los límites.";
        assert j >= 0 && j < n : "La columna está fuera de los límites.";
        if (puestos[i][j].estaOcupado()) {
            Registro registro = obtenerRegistro(puestos[i][j].getVehiculo());
            if (registro != null) {
                registro.setHoraSalida(LocalDateTime.now());
                double tarifa = registro.calcularCosto();
                actualizarRecaudaciones(tarifa);
                puestos[i][j].liberarPuesto();
            }
        }
    }

    /**
     * Obtiene el registro de un vehículo específico que aún no ha salido.
     *
     * @param vehiculo Vehículo a buscar.
     * @return El registro del vehículo, o null si no se encuentra.
     */
    private Registro obtenerRegistro(Vehiculo vehiculo) {
        for (Registro registro : registros) {
            if (registro.getVehiculo().equals(vehiculo) && registro.getHoraSalida() == null) {
                return registro;
            }
        }
        return null;
    }

    /**
     * Configura las tarifas por hora para carros y tipos de motos.
     *
     * @param tarifaCarro       Tarifa por hora para carros.
     * @param tarifaMotoClasica Tarifa por hora para motos clásicas.
     * @param tarifaMotoHibrida Tarifa por hora para motos híbridas.
     */
    public void configurarTarifasPorHora(double tarifaCarro, double tarifaMotoClasica, double tarifaMotoHibrida) {
        assert tarifaCarro > 0 : "La tarifa para carros debe ser mayor que cero.";
        assert tarifaMotoClasica > 0 : "La tarifa para motos clásicas debe ser mayor que cero.";
        assert tarifaMotoHibrida > 0 : "La tarifa para motos híbridas debe ser mayor que cero.";
        Carro.setTarifaPorHora(tarifaCarro);
        Moto.setTarifaClasica(tarifaMotoClasica);
        Moto.setTarifaHibrida(tarifaMotoHibrida);
    }

    /**
     * Actualiza las recaudaciones diarias y mensuales con una nueva tarifa.
     *
     * @param tarifa Tarifa a añadir a las recaudaciones.
     */
    private void actualizarRecaudaciones(double tarifa) {
        totalRecaudadoDiario += tarifa; // Incrementa el total recaudado diario
        totalRecaudadoMensual += tarifa; // Incrementa el total recaudado mensual
    }

    /**
     * Genera y muestra un reporte diario de recaudación, desglosado por tipo de vehículo.
     */
    public void generarReporteDiario() {
        System.out.println("Reporte Diario:");
        System.out.println("Total recaudado: " + totalRecaudadoDiario);
        System.out.println("Desglosado por tipo de vehículo:");
    
        double totalCarros = 0;
        double totalMotosClasicas = 0;
        double totalMotosHibridas = 0;
    
        for (Registro registro : registros) {
            if (registro.getHoraSalida() != null) {
                if (registro.getVehiculo() instanceof Carro) {
                    totalCarros += registro.calcularCosto();
                } else if (registro.getVehiculo() instanceof Moto) {
                    Moto moto = (Moto) registro.getVehiculo();
                    if (moto.getTipoMoto() == TipoMoto.CLASICA) {
                        totalMotosClasicas += registro.calcularCosto();
                    } else if (moto.getTipoMoto() == TipoMoto.HIBRIDA) {
                        totalMotosHibridas += registro.calcularCosto();
                    }
                }
            }
        }
    
        System.out.println("Carros: " + totalCarros);
        System.out.println("Motos Clásicas: " + totalMotosClasicas);
        System.out.println("Motos Híbridas: " + totalMotosHibridas);
    
        totalRecaudadoDiario = 0; // Reset diario
    }

    /**
     * Genera y muestra un reporte mensual de recaudación.
     */
    public void generarReporteMensual() {
        System.out.println("Reporte Mensual:");
        System.out.println("Total recaudado: " + totalRecaudadoMensual);
        totalRecaudadoMensual = 0; // Reset mensual
    }
}

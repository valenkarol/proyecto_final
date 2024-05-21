package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.Hashtable;
import java.util.LinkedList;

public class Parqueadero {
    private Collection<Vehiculo> vehiculos;
    private Collection<Propietario> propietarios;
    private Hashtable<String, Puesto> posicion;

    public Parqueadero(String nombre, byte cantidadFila, byte cantidadColumnas) {
        this.vehiculos = new LinkedList<>();
        this.propietarios = new LinkedList<>();
        this.posicion = new Hashtable<>();
    }

    public Collection<Vehiculo> getVehiculos() {
        return Collections.unmodifiableCollection(vehiculos);
    }

    public Collection <Propietario> getPropietarios(){
        return Collections.unmodifiableCollection(propietarios);
    }

    public void addPuesto(int i, int j, Puesto posicion){
        posicion.put("(" + i + ", " + j + ")", posicion);

        


    }

    
}

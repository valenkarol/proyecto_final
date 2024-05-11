package co.edu.uniquindio.poo;

public class Moto extends Vehiculo {
    private int velocidad;
    private TipoMoto tipoMoto;

    public Moto (String modelo, String placa, int velocidad){
        super(modelo, placa);
        this.velocidad=velocidad;
    }
    public int getVelocidad(){
        return velocidad;
    }
    public TipoMoto getTipoMoto() {
        return tipoMoto
    }
    
    
}

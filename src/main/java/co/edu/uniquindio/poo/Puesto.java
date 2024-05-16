package co.edu.uniquindio.poo;

public class Puesto {
    private String puesto;

    public Puesto(String puesto) {
        assert puesto != null : "Error, el nombre del parque infantil no puede ser nulo";

        this.puesto = puesto;
    }

    public String getPuesto() {
        return puesto;
    }

}

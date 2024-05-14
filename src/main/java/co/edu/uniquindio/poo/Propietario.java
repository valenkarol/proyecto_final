package co.edu.uniquindio.poo;

public class Propietario {

    private final String nombre;
    private final String apellido;
    private final String id;
    private final String correo;
    private final String numero;
    private final byte edad;

    public Propietario(String nombre, String apellido, String id, String correo, String numero, byte edad) {
        assert nombre != null && !nombre.isBlank() : "El nombre debe ser diferente de null";
        assert apellido != null && !apellido.isBlank() : "El apellido debe ser diferente de null";
        assert id != null && !id.isBlank() : "El número de identificación debe ser diferente de null";
        assert correo != null && correo.contains("@") : "El correo electrónico debe contener el símbolo @";
        assert numero != null : "El teléfono no puede ser null";
        assert edad > 0 : "La edad debe ser mayor a cero";

        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.correo = correo;
        this.numero = numero;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getId() {
        return id;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNumero() {
        return numero;
    }

    public byte getEdad() {
        return edad;
    }

    
}

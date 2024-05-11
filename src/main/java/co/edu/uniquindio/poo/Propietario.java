package co.edu.uniquindio.poo;

public record Propietario (String nombre, String apellido, String id, String correo, String numero, byte edad){
    
    public Propietario {
        assert nombre != null && !nombre.isBlank(): "El nombre debe ser diferente de null";
        assert apellido != null && !apellido.isBlank(): "El apellido debe ser diferente de null";
        assert id != null && !id.isBlank(): "El id debe ser diferente de null";
        assert correo != null && !correo.isBlank(): "El correo debe ser diferente de null";
        assert numero != null && !numero.isBlank(): "El numero debe ser diferente de null";
        assert edad > 0 : "La edad debe ser mayor a cero";

    }

    public String nombre() {
        return nombre;
    }

    public String apellido() {
        return apellido;
    }

    public String id() {
        return id;
    }

    public String correo() {
        return correo;
    }

    public String numero() {
        return numero;
    }

    public byte edad() {
        return edad;
    }
    
    
}

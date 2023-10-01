package uniandes.edu.co.proyecto.modelo;

public class Acompaniante {
    private String Nombre;
    private String Apellido;
    private Integer Num_doc;
    private String Tipo_doc;

    public Acompaniante(String nombre, String apellido, Integer num_doc, String tipo_doc) {
        Nombre = nombre;
        Apellido = apellido;
        Num_doc = num_doc;
        Tipo_doc = tipo_doc;
    }

    public Acompaniante()
    {;}

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public Integer getNum_doc() {
        return Num_doc;
    }

    public void setNum_doc(Integer num_doc) {
        Num_doc = num_doc;
    }

    public String getTipo_doc() {
        return Tipo_doc;
    }

    public void setTipo_doc(String tipo_doc) {
        Tipo_doc = tipo_doc;
    }

    

    
}

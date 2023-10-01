package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String Nombre;
    private String Apellido;
    private Integer Num_documento;
    private String Tipo;

    

    public Usuario(String nombre, String apellido, Integer num_documento, String tipo) {
        Nombre = nombre;
        Apellido = apellido;
        Num_documento = num_documento;
        Tipo = tipo;
        
    }

    public Usuario()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getNum_documento() {
        return Num_documento;
    }

    public void setNum_documento(Integer num_documento) {
        Num_documento = num_documento;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    
    
}

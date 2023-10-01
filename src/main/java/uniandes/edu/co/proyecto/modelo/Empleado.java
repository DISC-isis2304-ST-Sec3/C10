package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer Nombre;
    private Integer Apellido;

    public Empleado(Integer nombre, Integer apellido) {
        Nombre = nombre;
        Apellido = apellido;
    }

    public Empleado()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNombre() {
        return Nombre;
    }

    public void setNombre(Integer nombre) {
        Nombre = nombre;
    }

    public Integer getApellido() {
        return Apellido;
    }

    public void setApellido(Integer apellido) {
        Apellido = apellido;
    }

    
    
}

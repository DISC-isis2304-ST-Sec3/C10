package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Empleado")

public class Empleado extends Usuario {

    private String funcion;
    private Integer salario;
    private Integer longevidad;

    public Empleado(Integer id, String nombre, String apellido, TipoUsuario tipousuarioid, String funcion,
            Integer salario, Integer longevidad) {
        super(id, nombre, apellido, tipousuarioid);
        this.funcion = funcion;
        this.salario = salario;
        this.longevidad = longevidad;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    public Integer getLongevidad() {
        return longevidad;
    }

    public void setLongevidad(Integer longevidad) {
        this.longevidad = longevidad;
    }

}

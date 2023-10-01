package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")



public class Cliente {

    private Integer NumerodeIdentificación;
    private String Nombre;
    private String Apellido;
    private String Direccion;
    private Integer Telefono;
    private String Plandeconsumoactual;

    
    
    public Cliente(Integer numerodeIdentificación, String nombre, String apellido, String direccion, Integer telefono,
            String plandeconsumoactual) {
        NumerodeIdentificación = numerodeIdentificación;
        Nombre = nombre;
        Apellido = apellido;
        Direccion = direccion;
        Telefono = telefono;
        Plandeconsumoactual = plandeconsumoactual;
    }

    public Cliente()
    {;}

    public Integer getNumerodeIdentificación() {
        return NumerodeIdentificación;
    }
    public void setNumerodeIdentificación(Integer numerodeIdentificación) {
        NumerodeIdentificación = numerodeIdentificación;
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
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public Integer getTelefono() {
        return Telefono;
    }
    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }
    public String getPlandeconsumoactual() {
        return Plandeconsumoactual;
    }
    public void setPlandeconsumoactual(String plandeconsumoactual) {
        Plandeconsumoactual = plandeconsumoactual;
    }

    
}

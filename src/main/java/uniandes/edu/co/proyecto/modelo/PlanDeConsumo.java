package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PlanDeConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer Descuento;
    private String descripcion;
    private String Nombre;
    
    public PlanDeConsumo(Integer descuento, String descripcion, String nombre) {
        Descuento = descuento;
        this.descripcion = descripcion;
        Nombre = nombre;
    }

    public PlanDeConsumo()
    {;}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDescuento() {
        return Descuento;
    }

    public void setDescuento(Integer descuento) {
        Descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    

    

    




    
}

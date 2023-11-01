package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "plandeconsumo")

public class PlanDeConsumo {

    @Id
    private Integer id;
    private Integer Descuento;
    private String descripcion;
    private String Nombre;

    public PlanDeConsumo(Integer id,Integer descuento, String descripcion, String nombre) {
        this.id = id;
        Descuento = descuento;
        this.descripcion = descripcion;
        Nombre = nombre;
    }

    public PlanDeConsumo() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getDescuento() {
        return Descuento;
    }

    public void setDescuento(int descuento) {
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

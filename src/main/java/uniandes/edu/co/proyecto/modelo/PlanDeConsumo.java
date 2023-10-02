package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PlanDeConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int Descuento;
    private String descripcion;
    private String Nombre;

    public PlanDeConsumo(int descuento, String descripcion, String nombre) {
        Descuento = descuento;
        this.descripcion = descripcion;
        Nombre = nombre;
    }

    public PlanDeConsumo() {
        ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDescuento() {
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

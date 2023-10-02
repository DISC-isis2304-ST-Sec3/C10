package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")

public class Cliente extends Usuario {

    private String Direccion;
    private Integer Telefono;

    @ManyToOne
    @JoinColumn(name = "PlanDeConsumo", referencedColumnName = "id")
    private PlanDeConsumo Plandeconsumoactual;

    public Cliente(String nombre, String apellido, int num_documento, String tipo, String direccion,
            int telefono, PlanDeConsumo plandeconsumoactual) {
        super(nombre, apellido, num_documento, tipo);
        Direccion = direccion;
        Telefono = telefono;

        
        Plandeconsumoactual = plandeconsumoactual;
    }

    public Cliente() {
        ;
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

    public PlanDeConsumo getPlandeconsumoactual() {
        return Plandeconsumoactual;
    }

    public void setPlandeconsumoactual(PlanDeConsumo plandeconsumoactual) {
        Plandeconsumoactual = plandeconsumoactual;
    }

}

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="cliente")



public class Cliente extends Usuario {

    private String Direccion;
    private Integer Telefono;

    @ManyToOne
    @JoinColumn(name = "PlanDeConsumo", referencedColumnName = "id")
    private PlanDeConsumo Plandeconsumoactual;

    

    public Cliente(String direccion, Integer telefono,
            PlanDeConsumo plandeconsumoactual) {
        super();
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

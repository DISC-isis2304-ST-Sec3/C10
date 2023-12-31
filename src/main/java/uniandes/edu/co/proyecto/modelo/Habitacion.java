package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "habitacion")

public class Habitacion {
    @Id
    private Integer Numero;
    private String Tipo;
    private Integer CapacidadMax;
    private String Dotacion;
    private Integer Tarifa;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "PlanDeConsumo", referencedColumnName = "id")
    public PlanDeConsumo planDeConsumo;

    @ManyToOne
    @JoinColumn(name = "Tipo_habitacion", referencedColumnName = "id")
    public TipoHabitacion tipo_habitacion;

    public Habitacion() {
        ;
    }

    public Habitacion(Integer numero, String tipo, Integer capacidadMax, String dotacion, Integer tarifa,
            PlanDeConsumo planDeConsumo, TipoHabitacion tipo_habitacion) {
        Numero = numero;
        Tipo = tipo;
        CapacidadMax = capacidadMax;
        Dotacion = dotacion;
        Tarifa = tarifa;
        this.planDeConsumo = planDeConsumo;
        this.tipo_habitacion = tipo_habitacion;
    }

    public Integer getNumero() {
        return Numero;
    }

    public void setNumero(Integer numero) {
        Numero = numero;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public Integer getCapacidadMax() {
        return CapacidadMax;
    }

    public void setCapacidadMax(Integer capacidadMax) {
        CapacidadMax = capacidadMax;
    }

    public String getDotacion() {
        return Dotacion;
    }

    public void setDotacion(String dotacion) {
        Dotacion = dotacion;
    }

    public Integer getTarifa() {
        return Tarifa;
    }

    public void setTarifa(Integer tarifa) {
        Tarifa = tarifa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PlanDeConsumo getPlanDeConsumo() {
        return planDeConsumo;
    }

    public void setPlanDeConsumo(PlanDeConsumo planDeConsumo) {
        this.planDeConsumo = planDeConsumo;
    }

    public TipoHabitacion getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(TipoHabitacion tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

}

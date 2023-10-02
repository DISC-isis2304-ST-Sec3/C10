package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UsanServiciosPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "NumerodeIdentificación_cliente", referencedColumnName = "NumerodeIdentificación")
    private Cliente NumerodeIdentificación_cliente;

    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_Servicio;

    public UsanServiciosPK() {
        super();
    }

    public UsanServiciosPK(Cliente numerodeIdentificación_cliente, Servicio id_Servicio) {
        super();
        this.NumerodeIdentificación_cliente = numerodeIdentificación_cliente;
        this.id_Servicio = id_Servicio;
    }

    public Cliente getNumerodeIdentificación_cliente() {
        return NumerodeIdentificación_cliente;
    }

    public void setNumerodeIdentificación_cliente(Cliente numerodeIdentificación_cliente) {
        this.NumerodeIdentificación_cliente = numerodeIdentificación_cliente;
    }

    public Servicio getId_Servicio() {
        return id_Servicio;
    }

    public void setId_Servicio(Servicio id_Servicio) {
        this.id_Servicio = id_Servicio;
    }

}

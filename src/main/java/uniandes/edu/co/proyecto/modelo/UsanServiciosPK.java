package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class UsanServiciosPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente id_cliente;

    @ManyToOne
    @JoinColumn(name = "id_servicio", referencedColumnName = "id")
    private Servicio id_Servicio;

    public UsanServiciosPK() {
        super();
    }

    public UsanServiciosPK(Cliente id_cliente, Servicio id_Servicio) {
        super();
        this.id_cliente = id_cliente;
        this.id_Servicio = id_Servicio;
    }

    public Cliente id_cliente() {
        return id_cliente;
    }

    public void id_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Servicio getId_Servicio() {
        return id_Servicio;
    }

    public void setId_Servicio(Servicio id_Servicio) {
        this.id_Servicio = id_Servicio;
    }

    public Cliente getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Cliente id_cliente) {
        this.id_cliente = id_cliente;
    }

    

}

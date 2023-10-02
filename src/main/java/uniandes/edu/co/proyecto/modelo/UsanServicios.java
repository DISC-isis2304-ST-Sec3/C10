package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usan_servicios")
public class UsanServicios {
    public int idCliente;
    public int idServicio;
    @EmbeddedId
    private UsanServiciosPK pk;

    public UsanServicios() {
        ;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public UsanServiciosPK getPk() {
        return pk;
    }

    public void setPk(UsanServiciosPK pk) {
        this.pk = pk;
    }

}

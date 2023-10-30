package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usan_servicios")
public class UsanServicios {
    @EmbeddedId
    private UsanServiciosPK pk;

    public UsanServicios() {
        ;
    }

   public UsanServicios(Cliente idCliente, Servicio idServicio){
    this.pk = new UsanServiciosPK(idCliente, idServicio);
    
   }

    public UsanServiciosPK getPk() {
        return pk;
    }

    public void setPk(UsanServiciosPK pk) {
        this.pk = pk;
    }

}

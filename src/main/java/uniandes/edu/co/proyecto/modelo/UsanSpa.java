package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usan_spa")
public class UsanSpa {
    @EmbeddedId
    private Usan_spaPK pk;

    public UsanSpa() {
        ;
    }

    public UsanSpa(SPA id_Spa, ReservaSpa id_Reserva){
         this.pk = new Usan_spaPK(id_Spa, id_Reserva);
    }

    public Usan_spaPK getPk() {
        return pk;
    }

    public void setPk(Usan_spaPK pk) {
        this.pk = pk;
    }

    



}

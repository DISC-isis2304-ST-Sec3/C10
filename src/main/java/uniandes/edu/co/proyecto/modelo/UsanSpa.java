package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usan_spa")
public class UsanSpa {
    public int id;
    public int idReservasSpa;
    @EmbeddedId
    private Usan_spaPK pk;

    public UsanSpa() {
        ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReservasSpa() {
        return idReservasSpa;
    }

    public void setIdReservasSpa(int idReservasSpa) {
        this.idReservasSpa = idReservasSpa;
    }

}

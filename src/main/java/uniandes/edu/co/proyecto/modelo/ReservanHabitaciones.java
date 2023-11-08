package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ReservanHabitaciones")
public class ReservanHabitaciones {
    @EmbeddedId
    private ReservanHabitacionesPK pk;

    public ReservanHabitaciones(Reserva Numero_reserva, Habitacion Numero_habitacion) {
        this.pk = new ReservanHabitacionesPK(Numero_reserva, Numero_habitacion);
    }

    public ReservanHabitaciones() {
        ;
    }

    public ReservanHabitacionesPK getPk() {
        return pk;
    }

    public void setPk(ReservanHabitacionesPK pk) {
        this.pk = pk;
    }

}
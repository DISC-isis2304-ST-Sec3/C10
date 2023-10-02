package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Reservan_habitaciones")
public class ReservanHabitaciones {
    public int numReserva;
    public int numHabitacion;
    @EmbeddedId
    private ReservanHabitacionesPK pk;

    public ReservanHabitaciones() {
        ;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public ReservanHabitacionesPK getPk() {
        return pk;
    }

    public void setPk(ReservanHabitacionesPK pk) {
        this.pk = pk;
    }

}

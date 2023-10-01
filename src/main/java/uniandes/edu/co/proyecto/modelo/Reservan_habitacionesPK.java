package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Reservan_habitacionesPK {

    @ManyToOne
    @JoinColumn(name = "Numero_reserva",referencedColumnName = "Numero")
    private Reserva Numero_reserva;

    @ManyToOne
    @JoinColumn(name = "Numero_habitacion",referencedColumnName = "Numero")
    private Habitacion Numero_habitacion;

    public Reservan_habitacionesPK()
    {
        super();
    }

    public Reservan_habitacionesPK(Reserva numero_reserva, Habitacion numero_habitacion) {
        super();
        this.Numero_reserva = numero_reserva;
        this.Numero_habitacion = numero_habitacion;
    }

    public Reserva getNumero_reserva() {
        return Numero_reserva;
    }

    public void setNumero_reserva(Reserva numero_reserva) {
        this.Numero_reserva = numero_reserva;
    }

    public Habitacion getNumero_habitacion() {
        return Numero_habitacion;
    }

    public void setNumero_habitacion(Habitacion numero_habitacion) {
        this.Numero_habitacion = numero_habitacion;
    }

    

    


    
}

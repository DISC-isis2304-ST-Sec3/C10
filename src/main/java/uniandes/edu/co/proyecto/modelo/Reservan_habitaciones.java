package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Reservan_habitaciones")
public class Reservan_habitaciones{
     @EmbeddedId
    private Reservan_habitacionesPK pk;

    public Reservan_habitaciones()
    {;}
    
}

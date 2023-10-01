package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="Usan_servicios")
public class Usan_servicios {
    @EmbeddedId
    private Usan_serviciosPK pk;

    public Usan_servicios()
    {;}

    
}

package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usan_spa")
public class Usan_spa {
    @EmbeddedId
    private Usan_spaPK pk;

    public Usan_spa()
    {;}

   

    


}

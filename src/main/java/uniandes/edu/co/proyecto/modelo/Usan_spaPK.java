package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Usan_spaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "id_SPA",referencedColumnName = "id")
    private SPA id_Spa;

    @ManyToOne
    @JoinColumn(name = "id_ReservaSPA",referencedColumnName = "id")
    private ReservaSpa id_ReservaSpa;

    private Usan_spaPK()
    {
        super();
    }

    public Usan_spaPK(SPA id_Spa, ReservaSpa id_ReservaSpa) {
        super();
        this.id_Spa = id_Spa;
        this.id_ReservaSpa = id_ReservaSpa;
    }

    public SPA getId_Spa() {
        return id_Spa;
    }

    public void setId_Spa(SPA id_Spa) {
        this.id_Spa = id_Spa;
    }

    public ReservaSpa getId_ReservaSpa() {
        return id_ReservaSpa;
    }

    public void setId_ReservaSpa(ReservaSpa id_ReservaSpa) {
        this.id_ReservaSpa = id_ReservaSpa;
    }

    

    

    
}

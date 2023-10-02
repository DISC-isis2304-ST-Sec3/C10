package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ReservasSPA")

public class ReservaSpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date Horaio;

    public ReservaSpa(Date horaio) {
        Horaio = horaio;
    }

    public ReservaSpa() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getHoraio() {
        return Horaio;
    }

    public void setHoraio(Date horaio) {
        Horaio = horaio;
    }

}

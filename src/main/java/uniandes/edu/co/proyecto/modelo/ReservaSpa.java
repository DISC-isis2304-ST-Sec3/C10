package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ReservasSPA")

public class ReservaSpa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date Horario;
    @ManyToOne
    @JoinColumn(name="Habitacion",referencedColumnName = "Numero")
    public Habitacion numerohabitacion;
    @ManyToOne
    @JoinColumn(name="Cliente",referencedColumnName = "id")
    public Cliente numerodocumento;


    

    public ReservaSpa(Date horario, Habitacion numerohabitacion, Cliente numerodocumento) {
        Horario = horario;
        this.numerohabitacion = numerohabitacion;
        this.numerodocumento = numerodocumento;
    }

    public ReservaSpa() {
        ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorario() {
        return Horario;
    }

    public void setHorario(Date horaio) {
        Horario = horaio;
    }

    public Habitacion getNumerohabitacion() {
        return numerohabitacion;
    }

    public void setNumerohabitacion(Habitacion numerohabitacion) {
        this.numerohabitacion = numerohabitacion;
    }

    

    public void setNumeroDocumento(Cliente numerodocumento) {
        this.numerodocumento = numerodocumento;
    }

    public Cliente getNumerodocumento() {
        return numerodocumento;
    }

    

    

}

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
@Table(name = "reservas")

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date fechaEntrada;
    private Date fechaSalida;
    private Integer NumeroPersonas;
    private String Estado;

    @ManyToOne
    @JoinColumn(name="Cliente",referencedColumnName = "id")
    public Cliente numeroDocumento;

   
    public int idEmpleado;

    public Reserva(Date fechaEntrada, Date fechaSalida, Integer numeroPersonas, String estado) {
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        NumeroPersonas = numeroPersonas;
        Estado = estado;
    }

    public Reserva() {
        ;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Integer getNumeroPersonas() {
        return NumeroPersonas;
    }

    public void setNumeroPersonas(Integer numeroPersonas) {
        NumeroPersonas = numeroPersonas;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setNumeroDocumento(int pNumeroDocumento) {
        numeroDocumento = pNumeroDocumento;
    }

    public void setIdEmpleado(int pIdEmpleado) {
        idEmpleado = pIdEmpleado;
    }

}

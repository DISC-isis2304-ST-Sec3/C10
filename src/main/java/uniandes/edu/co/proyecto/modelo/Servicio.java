package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "servicio")

public class Servicio {
    @Id
    private Integer id;
    private Date Horario;
    private Integer capacidad;
    private String nombre;

    public Servicio(int id, Date horario, Integer capacidad, String nombre) {
        this.id = id;
        Horario = horario;
        this.capacidad = capacidad;
        this.nombre = nombre;
    }

    public Servicio() {
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

    public void setHorario(Date horario) {
        Horario = horario;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Integer capacidad) {
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}

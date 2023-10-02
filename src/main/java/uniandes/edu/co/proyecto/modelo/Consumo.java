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
@Table(name = "consumos")
public class Consumo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Date Fecha;
    private String descripcion;
    private Integer precioUnitario;
    private Integer cantidad;
    private Integer total;

    @ManyToOne
    @JoinColumn(name = "servicio_id", referencedColumnName = "id")
    private Integer servicioID;

    @ManyToOne
    @JoinColumn(name = "numero_Reserva", referencedColumnName = "numero")
    private Integer numeroReserva;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private int usuarioid;

    public Consumo(Date fecha, String descripcion, Integer precioUnitario, Integer cantidad, Integer total,
            Integer servicioID, Integer numeroReserva, int usuarioid) {
        Fecha = fecha;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.total = total;
        this.servicioID = servicioID;
        this.numeroReserva = numeroReserva;
        this.usuarioid = usuarioid;
    }

    public Consumo() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Integer getServicioID() {
        return servicioID;
    }

    public void setServicioID(Integer servicioID) {
        this.servicioID = servicioID;
    }

    public Integer getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(Integer numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

}

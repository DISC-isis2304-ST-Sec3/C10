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
@Table(name = "consumo")
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
    private Servicio servicioID;

    @ManyToOne
    @JoinColumn(name = "id_Reserva", referencedColumnName = "id")
    private Reserva numeroReserva;

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Usuario usuarioid;

    public Consumo(Date fecha, String descripcion, Integer precioUnitario, Integer cantidad, Integer total,
            Servicio servicioID, Reserva numeroReserva, Usuario usuarioid) {
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

    public Usuario getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuario usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Servicio getServicioID() {
        return servicioID;
    }

    public void setServicioID(Servicio servicioID) {
        this.servicioID = servicioID;
    }

    public Reserva getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(Reserva numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

}

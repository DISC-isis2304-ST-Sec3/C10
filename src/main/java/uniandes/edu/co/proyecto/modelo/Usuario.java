package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")

public class Usuario {

    @Id
    private Integer id;
    private String Nombre;
    private String Apellido;

    @ManyToOne
    @JoinColumn(name = "Tipo_usuario", referencedColumnName = "id")
    private TipoUsuario tipousuarioid;

    public Usuario(Integer id, String nombre, String apellido, TipoUsuario tipousuarioid) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        this.tipousuarioid = tipousuarioid;
    }

    public Usuario() {
        ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public TipoUsuario getTipousuarioid() {
        return tipousuarioid;
    }

    public void setTipousuarioid(TipoUsuario tipousuarioid) {
        this.tipousuarioid = tipousuarioid;
    }

}

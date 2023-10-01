package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")



public class Cliente extends Usuario{

    
    private String Direccion;
    private Integer Telefono;
    private String Plandeconsumoactual;

    
    
    
    
    public Cliente(String nombre, String apellido, Integer num_documento, String tipo, String direccion,
            Integer telefono, String plandeconsumoactual) {
        super(nombre, apellido, num_documento, tipo);
        Direccion = direccion;
        Telefono = telefono;
        Plandeconsumoactual = plandeconsumoactual;
    }


    public Cliente()
    {;}

    
    public String getDireccion() {
        return Direccion;
    }
    public void setDireccion(String direccion) {
        Direccion = direccion;
    }
    public Integer getTelefono() {
        return Telefono;
    }
    public void setTelefono(Integer telefono) {
        Telefono = telefono;
    }
    public String getPlandeconsumoactual() {
        return Plandeconsumoactual;
    }
    public void setPlandeconsumoactual(String plandeconsumoactual) {
        Plandeconsumoactual = plandeconsumoactual;
    }

    
}

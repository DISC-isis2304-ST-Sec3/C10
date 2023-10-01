package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

public class SPA extends Servicio{
    private Integer Duracion_min;
    private String Tipo;
    private Integer costo;
    public SPA(String id, Date horario, Integer capacidad, String nombre, Integer duracion_min, String tipo,
            Integer costo) {
        super(id, horario, capacidad, nombre);
        Duracion_min = duracion_min;
        Tipo = tipo;
        this.costo = costo;
    }

    public SPA()
    {;}
    public Integer getDuracion_min() {
        return Duracion_min;
    }
    public void setDuracion_min(Integer duracion_min) {
        Duracion_min = duracion_min;
    }
    public String getTipo() {
        return Tipo;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }
    public Integer getCosto() {
        return costo;
    }
    public void setCosto(Integer costo) {
        this.costo = costo;
    }
    
    

    
    
}

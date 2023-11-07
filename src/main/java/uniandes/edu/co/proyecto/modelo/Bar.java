package uniandes.edu.co.proyecto.modelo;

public class Bar extends Servicio {

    private String ingredientes;
    private String Tipo_plato;
    private String Disponible;
    public Bar(String ingredientes, String tipo_plato, String disponible) {
        this.ingredientes = ingredientes;
        Tipo_plato = tipo_plato;
        Disponible = disponible;
    }
    public String getIngredientes() {
        return ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }
    public String getTipo_plato() {
        return Tipo_plato;
    }
    public void setTipo_plato(String tipo_plato) {
        Tipo_plato = tipo_plato;
    }
    public String getDisponible() {
        return Disponible;
    }
    public void setDisponible(String disponible) {
        Disponible = disponible;
    }

    
    
    

    
}

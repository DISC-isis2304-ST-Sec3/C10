package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

public class Restaurante extends Servicio {
    private String Menu;
    private String Ingredientes;
    private String Modalidad;
    public Restaurante(int id, Date horario, Integer capacidad, String nombre, String menu, String ingredientes,
            String modalidad) {
        super(id, horario, capacidad, nombre);
        Menu = menu;
        Ingredientes = ingredientes;
        Modalidad = modalidad;
    }
    public Restaurante(String menu, String ingredientes, String modalidad) {
        Menu = menu;
        Ingredientes = ingredientes;
        Modalidad = modalidad;
    }
    public String getMenu() {
        return Menu;
    }
    public void setMenu(String menu) {
        Menu = menu;
    }
    public String getIngredientes() {
        return Ingredientes;
    }
    public void setIngredientes(String ingredientes) {
        Ingredientes = ingredientes;
    }
    public String getModalidad() {
        return Modalidad;
    }
    public void setModalidad(String modalidad) {
        Modalidad = modalidad;
    }

    
    
}

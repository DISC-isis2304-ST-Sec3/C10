package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.ConsumoRepository;
import uniandes.repositorio.HabitacionRepository;
import uniandes.repositorio.ReservaRepository;

@Controller
public class HabitacionController {
    @Autowired
    private HabitacionRepository habitacionRepository;

    @GetMapping("/habitaciones")
    public String habitaciones(Model model) {
        model.addAttribute("habitaciones", habitacionRepository.darHabitaciones());
        return "habitaciones";
    }

    @GetMapping("/habitaciones/new")
    public String HabitacionForm(Model model) {
        model.addAttribute("habitaciones", new Habitacion());
        return "habitacionNueva";
    }

    @PostMapping("/habitaciones/new/save")
    public String habitacionGuardar(@ModelAttribute Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion.getNumero(), habitacion.getTipo(),
                habitacion.getCapacidadMax(), habitacion.getDotacion(), habitacion.getEstado(), habitacion.getTarifa(),
                habitacion.getPlanDeConsumo().getId());
        return "redirect:/habitaciones";
    }

    @GetMapping("/habitaciones/{id}/edit")
    public String habitacionEditarForm(@PathVariable("id") int id, Model model) {
        Habitacion habitacion = habitacionRepository.darHabitacion(id);
        if (habitacion != null) {
            model.addAttribute("habitaciones", habitacion);
            return "editarHabitacion";
        } else {
            return "/redirect:/habitaciones";
        }
    }

    @PostMapping("/habitaciones/{id}/edit/save")
    public String habitacionEditarGuardar(@ModelAttribute Habitacion habitacion, @PathVariable("id") int id) {
        habitacionRepository.actualizarHabitacion(habitacion.getNumero(), habitacion.getTipo(),
                habitacion.getCapacidadMax(), habitacion.getDotacion(), habitacion.getEstado(), habitacion.getTarifa(),
                habitacion.getPlanDeConsumo().getId());
        return "redirect:/habitaciones";

    }

    @GetMapping("/habitaciones/{id}/delete")
    public String habitacionEliminar(@PathVariable("id") int id) {
        habitacionRepository.eliminarHabitacion(id);
        return "redirect:/habitaciones";
    }
}

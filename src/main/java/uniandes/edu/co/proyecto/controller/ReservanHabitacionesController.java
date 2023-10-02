package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservanHabitaciones;
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.ReservaRepository;
import uniandes.repositorio.ReservanHabitacionesRepository;

@Controller
public class ReservanHabitacionesController {
    @Autowired
    private ReservanHabitacionesRepository reservanHabitacionesRepository;

    @GetMapping("/reservanHabitacioness")
    public String reservanHabitacioness(Model model) {
        model.addAttribute("reservanHabitacioness", reservanHabitacionesRepository.darReservanHabitacioness());
        return "reservanHabitacioness";
    }

    @GetMapping("/reservanHabitacioness/new")
    public String reservanHabitacionesForm(Model model) {
        model.addAttribute("reservanHabitacioness", new ReservanHabitaciones());
        return "reservanHabitacionesNuevo";
    }

    @PostMapping("/reservanHabitacioness/new/save")
    public String reservanHabitacionesGuardar(@ModelAttribute ReservanHabitaciones reservanHabitaciones) {
        reservanHabitacionesRepository.insertarReservanHabitaciones(reservanHabitaciones.getNumReserva(),
                reservanHabitaciones.getNumHabitacion());
        ;
        return "redirect:/reservanHabitacioness";
    }

    @GetMapping("/reservanHabitacioness/{id}/edit")
    public String reservanHabitacionesEditarForm(@ModelAttribute ReservanHabitaciones reservanHabitaciones,
            Model model) {
        if (reservanHabitaciones != null) {
            model.addAttribute("reservanHabitaciones", reservanHabitaciones);
            return "editarReservanHabitaciones";
        } else {
            return "/redirect:/reservanHabitacioness";
        }
    }

    @PostMapping("/reservanHabitacioness/{id}/edit/save")
    public String reservanHabitacionesEditarGuardar(@ModelAttribute ReservanHabitaciones reservanHabitaciones) {
        reservanHabitacionesRepository.actualizarReservan_habitaciones(reservanHabitaciones.getNumReserva(),
                reservanHabitaciones.getNumHabitacion());
        return "redirect:/reservanHabitacioness";

    }

    @GetMapping("/reservanHabitacioness/{id}/delete")
    public String reservanHabitacionesEliminar(@ModelAttribute ReservanHabitaciones reservanHabitaciones) {
        reservanHabitacionesRepository.eliminarReservan_habitaciones(reservanHabitaciones.getNumReserva(),
                reservanHabitaciones.getNumHabitacion());
        return "redirect:/reservanHabitacioness";
    }
}

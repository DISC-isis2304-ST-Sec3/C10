package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.repositorio.TipoHabitacionRepository;

import java.util.List;

@Controller
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @GetMapping("/tiposhabitacion")
    public String mostrarTiposHabitacion(Model model) {
        List<TipoHabitacion> tipoHabitaciones = tipoHabitacionRepository.findAll();
        model.addAttribute("tipoHabitaciones", tipoHabitaciones);
        return "tiposhabitacion";
    }

    @GetMapping("/nuevoTipoHabitacion")
    public String mostrarFormularioTipoHabitacion(Model model) {
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        model.addAttribute("tipoHabitacion", tipoHabitacion);
        return "tipoHabitacionNueva";
    }

    @PostMapping("/nuevoTipoHabitacion")
    public String procesarFormularioTipoHabitacion(@ModelAttribute TipoHabitacion tipoHabitacion) {
        tipoHabitacionRepository.save(tipoHabitacion);
        return "redirect:/tiposHabitacion";
    }
}
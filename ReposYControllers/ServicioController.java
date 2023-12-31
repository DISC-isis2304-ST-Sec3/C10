package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservaSpa;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaSpaRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;

@Controller
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicio")
    public String servicios(Model model) {
        model.addAttribute("servicios", servicioRepository.darServicios());
        return "servicio";
    }

    @GetMapping("/servicio/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicio/new/save")
    public String serviciosGuardar(@ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getId(), servicio.getNombre(), servicio.getCapacidad(),
                servicio.getHorario());
        return "redirect:/servicio";
    }

    @GetMapping("/servicio/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") int id, Model model) {
        Servicio servicio = servicioRepository.darServicio(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "/redirect:/servicio";
        }
    }

    @PostMapping("/servicio/{id}/edit/save")
    public String serviciosEditarGuardar(@ModelAttribute Servicio servicio, @PathVariable("id") int id) {
        servicioRepository.actualizarServicio(servicio.getId(), servicio.getNombre(), servicio.getCapacidad(),
                servicio.getHorario());
        return "redirect:/reservasSpa";

    }

    @GetMapping("/servicio/{id}/delete")
    public String servicioEliminar(@PathVariable("id") int id) {
        servicioRepository.eliminarServicio(id);

        return "redirect:/servicio";
    }
}

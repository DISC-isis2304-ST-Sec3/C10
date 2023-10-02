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
import uniandes.repositorio.ReservaRepository;
import uniandes.repositorio.ReservaSpaRepository;
import uniandes.repositorio.ServicioRepository;

@Controller
public class ServicioController {
    @Autowired
    private ServicioRepository servicioRepository;

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("servicios", servicioRepository.darServicios());
        return "servicios";
    }

    @GetMapping("/servicios/new")
    public String servicioForm(Model model) {
        model.addAttribute("servicio", new Servicio());
        return "servicioNuevo";
    }

    @PostMapping("/servicios/new/save")
    public String serviciosGuardar(@ModelAttribute Servicio servicio) {
        servicioRepository.insertarServicio(servicio.getId(), servicio.getNombre(), servicio.getCapacidad(),
                servicio.getHorario());
        return "redirect:/servicios";
    }

    @GetMapping("/servicios/{id}/edit")
    public String servicioEditarForm(@PathVariable("id") int id, Model model) {
        Servicio servicio = servicioRepository.darServicio(id);
        if (servicio != null) {
            model.addAttribute("servicio", servicio);
            return "servicioEditar";
        } else {
            return "/redirect:/servicios";
        }
    }

    @PostMapping("/servicios/{id}/edit/save")
    public String serviciosEditarGuardar(@ModelAttribute Servicio servicio, @PathVariable("id") int id) {
        servicioRepository.actualizarServicio(servicio.getId(), servicio.getNombre(), servicio.getCapacidad(),
                servicio.getHorario());
        return "redirect:/reservasSpa";

    }

    @GetMapping("/servicios/{id}/delete")
    public String servicioEliminar(@PathVariable("id") int id) {
        servicioRepository.eliminarServicio(id);

        return "redirect:/servicios";
    }
}

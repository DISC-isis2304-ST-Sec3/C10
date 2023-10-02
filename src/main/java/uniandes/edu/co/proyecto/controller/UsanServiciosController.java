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
import uniandes.edu.co.proyecto.modelo.UsanServicios;
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.ReservaRepository;
import uniandes.repositorio.ReservanHabitacionesRepository;
import uniandes.repositorio.UsanServiciosRepository;

@Controller
public class UsanServiciosController {
    @Autowired
    private UsanServiciosRepository usanServiciosRepository;

    @GetMapping("/usanServicioss")
    public String usanServicioss(Model model) {
        model.addAttribute("usanServicioss", usanServiciosRepository.darUsanServicioss());
        return "usanServicioss";
    }

    @GetMapping("/usanServicioss/new")
    public String usanServiciossForm(Model model) {
        model.addAttribute("usanServicioss", new UsanServicios());
        return "usanServiciosNuevo";
    }

    @PostMapping("/usanServicioss/new/save")
    public String usanServiciosGuardar(@ModelAttribute UsanServicios usanServicios) {
        usanServiciosRepository.insertarUsan_servicios(usanServicios.getIdCliente(), usanServicios.getIdServicio());
        ;
        return "redirect:/usanServicioss";
    }

    @GetMapping("/usanServicioss/{id}/edit")
    public String usanServiciosEditarForm(@ModelAttribute UsanServicios usanServicios,
            Model model) {
        if (usanServicios != null) {
            model.addAttribute("usanServicios", usanServicios);
            return "editarusanServicios";
        } else {
            return "/redirect:/usanServicioss";
        }
    }

    @PostMapping("/usanServicioss/{id}/edit/save")
    public String usanServiciosEditarGuardar(@ModelAttribute UsanServicios usanServicios) {
        usanServiciosRepository.actualizarUsan_servicios(usanServicios.getIdCliente(), usanServicios.getIdServicio());
        return "redirect:/usanServicioss";

    }

    @GetMapping("/usanServicioss/{id}/delete")
    public String usanServiciosEliminar(@ModelAttribute UsanServicios usanServicios) {
        usanServiciosRepository.eliminarUsan_servicios(usanServicios.getIdCliente(), usanServicios.getIdServicio());
        return "redirect:/usanServicioss";
    }
}

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
import uniandes.repositorio.ReservaRepository;
import uniandes.repositorio.ReservaSpaRepository;

@Controller
public class ReservaSpaController {
    @Autowired
    private ReservaSpaRepository reservaSpaRepository;

    @GetMapping("/reservasSpa")
    public String reservasSpa(Model model) {
        model.addAttribute("reservasSpa", reservaSpaRepository.darReservas());
        return "reservasSpa";
    }

    @GetMapping("/reservasSpa/new")
    public String reservaSpaForm(Model model) {
        model.addAttribute("reservaSpa", new ReservaSpa());
        return "reservaSpaNueva";
    }

    @PostMapping("/reservasSpa/new/save")
    public String reservaSpaGuardar(@ModelAttribute ReservaSpa reservaSpa) {
        reservaSpaRepository.insertarReservaSpa(reservaSpa.getFechaEntrada(), reserva.getFechaSalida(),
                reserva.getNumeroPersonas(), reserva.getNumeroDocumento(), reserva.getEstado(),
                reserva.getIdEmpleado());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaEditarForm(@PathVariable("id") int id, Model model) {
        Reserva reserva = reservaRepository.darReserva(id);
        if (reserva != null) {
            model.addAttribute("reserva", reserva);
            return "reservaEditar";
        } else {
            return "/redirect:/reservas";
        }
    }

    @PostMapping("/reservas/{id}/edit/save")
    public String reservaEditarGuardar(@ModelAttribute Reserva reserva, @PathVariable("id") int id) {
        reservaRepository.actualizarReserva(id, reserva.getFechaEntrada(), reserva.getFechaSalida(),
                reserva.getNumeroPersonas(), reserva.getNumeroDocumento(), reserva.getEstado(),
                reserva.getIdEmpleado());
        return "redirect:/reservas";

    }

    @GetMapping("/reservas/{id}/delete")
    public String reservaEliminar(@PathVariable("id") int id) {
        reservaRepository.eliminarReserva(id);
        return "redirect:/reservas";
    }
}

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
        model.addAttribute("reservasSpa", reservaSpaRepository.darReservasSpa());
        return "reservasSpa";
    }

    @GetMapping("/reservasSpa/new")
    public String reservaSpaForm(Model model) {
        model.addAttribute("reservaSpa", new ReservaSpa());
        return "reservaSpaNueva";
    }

    @PostMapping("/reservasSpa/new/save")
    public String reservaSpaGuardar(@ModelAttribute ReservaSpa reservaSpa) {
        reservaSpaRepository.insertarReservaSpa(reservaSpa.getId(), reservaSpa.getHorario(), 
        reservaSpa.getNumerohabitacion().getNumero(), reservaSpa.getNumerodocumento().getId());
        return "redirect:/reservas";
    }

    @GetMapping("/reservas/{id}/edit")
    public String reservaSpaEditarForm(@PathVariable("id") int id, Model model) {
        ReservaSpa reservaSpa = reservaSpaRepository.darReservaSpa(id);
        if (reservaSpa != null) {
            model.addAttribute("reservaSpa", reservaSpa);
            return "reservaSpaEditar";
        } else {
            return "/redirect:/reservasSpa";
        }
    }

    @PostMapping("/reservasSpa/{id}/edit/save")
    public String reservaSpaEditarGuardar(@ModelAttribute ReservaSpa reservaSpa, @PathVariable("id") int id) {
        reservaSpaRepository.actualizarReservaSpa(id, reservaSpa.getHorario(),
        reservaSpa.getNumerohabitacion().getNumero(), reservaSpa.getNumerodocumento().getId());
        return "redirect:/reservasSpa";

    }

    @GetMapping("/reservasSpa/{id}/delete")
    public String reservaSpaEliminar(@PathVariable("id") int id) {
        reservaSpaRepository.eliminarReservaSpa(id);
        return "redirect:/reservasSpa";
    }
}

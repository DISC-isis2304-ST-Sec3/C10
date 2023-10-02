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
import uniandes.edu.co.proyecto.modelo.UsanSpa;
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.ReservaRepository;
import uniandes.repositorio.UsanSpaRepository;

@Controller
public class UsanSpaController {
    @Autowired
    private UsanSpaRepository usanSpaRepository;

    @GetMapping("/usanSpas")
    public String usanSpas(Model model) {
        model.addAttribute("usanSpas", usanSpaRepository.darUsanspas());
        return "usanSpas";
    }

    @GetMapping("/usanSpas/new")
    public String usanSpaForm(Model model) {
        model.addAttribute("usanSpa", new UsanSpa());
        return "usanSpaNuevo";
    }

    @PostMapping("/usanSpas/new/save")
    public String usanSpaGuardar(@ModelAttribute UsanSpa usanSpa) {
        usanSpaRepository.insertarUsanSpa(usanSpa.getId(), usanSpa.getIdReservasSpa());
        ;
        return "redirect:/usanSpas";
    }

    @GetMapping("/usanSpas/{id}/edit")
    public String usanSpaEditarForm(@PathVariable("id") int id, @PathVariable("idReserva") int idReserva,
            Model model) {
        UsanSpa usanSpa = usanSpaRepository.darUsanSpa(id, idReserva);
        if (usanSpa != null) {
            model.addAttribute("usanSpa", usanSpa);
            return "editarUsanSpa";
        } else {
            return "/redirect:/usanSpas";
        }
    }

    @PostMapping("/usanSpas/{id}/edit/save")
    public String usanSpaEditarGuardar(@ModelAttribute UsanSpa usanSpa, @PathVariable("id") int id) {
        usanSpaRepository.actualizarUsanSpa(id, usanSpa.getIdReservasSpa());
        return "redirect:/usanSpas";

    }

    @GetMapping("/usanSpas/{id}/delete")
    public String usanSpaEliminar(@ModelAttribute UsanSpa usanSpa, @PathVariable("id") int id) {
        usanSpaRepository.eliminarUsanSpa(id, usanSpa.getIdReservasSpa());
        return "redirect:/usanSpas";
    }
}

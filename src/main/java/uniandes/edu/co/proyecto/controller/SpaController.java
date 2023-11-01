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
import uniandes.edu.co.proyecto.modelo.SPA;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.SPARepository;

@Controller
public class SpaController {
    @Autowired
    private SPARepository spaRepository;

    @GetMapping("/spas")
    public String spas(Model model) {
        model.addAttribute("spas", spaRepository.darSPAS());
        return "spas";
    }

    @GetMapping("/spas/new")
    public String spaForm(Model model) {
        model.addAttribute("spas", new SPA());
        return "spaNuevo";
    }

    @PostMapping("/spas/new/save")
    public String spaGuardar(@ModelAttribute SPA spa) {
        spaRepository.insertarSPA(spa.getId(), spa.getDuracion_min(), spa.getTipo(), spa.getCosto());
        return "redirect:/spas";
    }

    @GetMapping("/spas/{id}/edit")
    public String spaEditarForm(@PathVariable("id") int id, Model model) {
        SPA spa = spaRepository.darSPA(id);
        if (spa != null) {
            model.addAttribute("spa", spa);
            return "editarSpa";
        } else {
            return "/redirect:/spas";
        }
    }

    @PostMapping("/spas/{id}/edit/save")
    public String spaEditarGuardar(@ModelAttribute SPA spa, @PathVariable("id") int id) {
        spaRepository.actualizarSPA(spa.getId(), spa.getDuracion_min(), spa.getTipo(), spa.getCosto());
        return "redirect:/spas";

    }

    @GetMapping("/spas/{id}/delete")
    public String spaEliminar(@PathVariable("id") int id) {
        spaRepository.eliminarSPA(id);
        return "redirect:/spas";
    }
}

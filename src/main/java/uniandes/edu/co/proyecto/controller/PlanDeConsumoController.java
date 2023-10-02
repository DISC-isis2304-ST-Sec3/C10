package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.PlanDeConsumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.PlanDeConsumoRepository;
import uniandes.repositorio.ReservaRepository;

@Controller
public class PlanDeConsumoController {
    @Autowired
    private PlanDeConsumoRepository planDeConsumoRepository;

    @GetMapping("/planDeConsumos")
    public String planDeConsumos(Model model) {
        model.addAttribute("planDeConsumos", planDeConsumoRepository.darPlanes());
        return "planDeConsumos";
    }

    @GetMapping("/planDeConsumos/new")
    public String planDeConsumoForm(Model model) {
        model.addAttribute("planDeConsumos", new PlanDeConsumo());
        return "planDeConsumoNuevo";
    }

    @PostMapping("/planDeConsumos/new/save")
    public String planDeConsumoGuardar(@ModelAttribute PlanDeConsumo planDeConsumo) {
        planDeConsumoRepository.insertarPlan(planDeConsumo.getId(), planDeConsumo.getNombre(),
                planDeConsumo.getDescripcion(), planDeConsumo.getDescuento());
        return "redirect:/planDeConsumos";
    }

    @GetMapping("/planDeConsumos/{id}/edit")
    public String planDeConsumoEditarForm(@PathVariable("id") int id, Model model) {
        PlanDeConsumo planDeConsumo = planDeConsumoRepository.darPlan(id);
        if (planDeConsumo != null) {
            model.addAttribute("planDeConsumo", planDeConsumo);
            return "editarPlanDeConsumo";
        } else {
            return "/redirect:/planDeConsumos";
        }
    }

    @PostMapping("/planDeConsumos/{id}/edit/save")
    public String planDeConsumoEditarGuardar(@ModelAttribute PlanDeConsumo planDeConsumo, @PathVariable("id") int id) {
        planDeConsumoRepository.actualizarPlan(id,
                planDeConsumo.getNombre(), planDeConsumo.getDescripcion(), planDeConsumo.getDescuento());
        return "redirect:/planDeConsumos";

    }

    @GetMapping("/planDeConsumos/{id}/delete")
    public String planDeConsumoEliminar(@PathVariable("id") int id) {
        planDeConsumoRepository.eliminarPlan(id);
        return "redirect:/planDeConsumos";
    }
}

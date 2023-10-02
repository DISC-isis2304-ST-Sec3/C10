package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Consumo;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.ConsumoRepository;
import uniandes.repositorio.ReservaRepository;

@Controller
public class ConsumoController {
    @Autowired
    private ConsumoRepository consumoRepository;

    @GetMapping("/consumos")
    public String consumos(Model model) {
        model.addAttribute("consumos", consumoRepository.darConsumos());
        return "consumos";
    }

    @GetMapping("/consumos/new")
    public String ConsumoForm(Model model) {
        model.addAttribute("consumos", new Consumo());
        return "consumoNuevo";
    }

    @PostMapping("/consumos/new/save")
    public String consumoGuardar(@ModelAttribute Consumo consumo) {
        consumoRepository.insertarConsumo(consumo.getId(), consumo.getFecha(), consumo.getDescripcion(),
                consumo.getPrecioUnitario(),
                consumo.getCantidad(), consumo.getTotal(), consumo.getServicioID(), consumo.getNumeroReserva(),
                consumo.getUsuarioid());
        return "redirect:/consumos";
    }

    @GetMapping("/consumos/{id}/edit")
    public String consumoEditarForm(@PathVariable("id") int id, Model model) {
        Consumo consumo = consumoRepository.darConsumo(id);
        if (consumo != null) {
            model.addAttribute("consumos", consumo);
            return "editarConsumo";
        } else {
            return "/redirect:/consumos";
        }
    }

    @PostMapping("/consumos/{id}/edit/save")
    public String consumoEditarGuardar(@ModelAttribute Consumo consumo, @PathVariable("id") int id) {
        consumoRepository.actualizarConsumo(consumo.getId(), consumo.getFecha(), consumo.getDescripcion(),
                consumo.getPrecioUnitario(),
                consumo.getCantidad(), consumo.getTotal(), consumo.getServicioID(), consumo.getNumeroReserva(),
                consumo.getUsuarioid());
        return "redirect:/consumos";

    }

    @GetMapping("/consumos/{id}/delete")
    public String consumoEliminar(@PathVariable("id") int id) {
        consumoRepository.eliminarConsumo(id);
        return "redirect:/consumos";
    }
}

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
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/cliente")
    public String clientes(Model model) {
        model.addAttribute("cliente", clienteRepository.darClientes());
        return model.toString();
    }

    @GetMapping("/cliente/new")
    public String clienteForm(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clienteNuevo";
    }

    @PostMapping("/cliente/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente) {
        clienteRepository.insertarCliente(cliente.getId(),
                cliente.getDireccion(), cliente.getTelefono(), cliente.getPlandeconsumoactual().getId());
        return "redirect:/cliente";
    }

    @GetMapping("/cliente/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") int id, Model model) {
        Cliente cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "editarCliente";
        } else {
            return "/redirect:/cliente";
        }
    }

    @PostMapping("/cliente/{id}/edit/save")
    public String clienteEditarGuardar(@ModelAttribute Cliente cliente, @PathVariable("id") int id) {
        clienteRepository.actualizarCliente(cliente.getId(),
                cliente.getDireccion(), cliente.getTelefono(), cliente.getPlandeconsumoactual().getId());
        return "redirect:/cliente";

    }

    @GetMapping("/clientes/{id}/delete")
    public String clienteEliminar(@PathVariable("id") int id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/cliente";
    }
}

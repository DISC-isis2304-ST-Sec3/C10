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
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.ReservaRepository;

@Controller
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String clienteForm(Model model) {
        model.addAttribute("clientes", new Cliente());
        return "clienteNuevo";
    }

    @PostMapping("/clientes/new/save")
    public String clienteGuardar(@ModelAttribute Cliente cliente) {
        clienteRepository.insertarCliente(cliente.getId(), cliente.getNombre(), cliente.getApellido(),
                cliente.getTipo(),
                cliente.getDireccion(), cliente.getTelefono(), cliente.getPlandeconsumoactual().getNombre());
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/edit")
    public String clienteEditarForm(@PathVariable("id") int id, Model model) {
        Cliente cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "editarCliente";
        } else {
            return "/redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{id}/edit/save")
    public String clienteEditarGuardar(@ModelAttribute Cliente cliente, @PathVariable("id") int id) {
        clienteRepository.actualizarCliente(cliente.getId(), cliente.getNombre(), cliente.getApellido(),
                cliente.getTipo(),
                cliente.getDireccion(), cliente.getTelefono(), cliente.getPlandeconsumoactual().getNombre());
        return "redirect:/clientes";

    }

    @GetMapping("/clientes/{id}/delete")
    public String clienteEliminar(@PathVariable("id") int id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/clientes";
    }
}

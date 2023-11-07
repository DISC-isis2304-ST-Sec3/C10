package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tipodeusuario")
    public String tipodeusuario() {
        return "tipodeusuario";
    }

    @GetMapping("/nuevoTipoUsuario")
    public String mostrarFormularioTipoUsuario(Model model) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        model.addAttribute("tipoUsuario", tipoUsuario);
        return "usuarioNuevo";
    }

    @PostMapping("/nuevoTipoUsuario")
    public String agregarTipoUsuario(@ModelAttribute("tipoUsuario") TipoUsuario tipoUsuario) {
        String nombre = tipoUsuario.getNombre();
        String descripcion = tipoUsuario.getDescripcion();
        int id = tipoUsuario.getId();
        tipoUsuarioRepository.insertarTipoUsuario(id, nombre, descripcion);
        return "redirect:/tipodeusuario";
    }
}
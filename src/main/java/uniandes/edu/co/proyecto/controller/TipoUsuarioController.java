package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.TipoHabitacion;
import uniandes.edu.co.proyecto.modelo.TipoUsuario;
import uniandes.edu.co.proyecto.repositorio.TipoUsuarioRepository;

@Controller
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @GetMapping("/tipodeusuario")
    public String mostrarTiposDeUsuario(Model model) {
        List<TipoUsuario> tipoUsuarios = tipoUsuarioRepository.findAll();
        model.addAttribute("tipoUsuarios", tipoUsuarios);
        return "tipodeusuario";
    }

    @GetMapping("/nuevoTipoUsuario")
    public String mostrarFormularioTipoUsuario(Model model) {
        TipoUsuario tipoUsuario = new TipoUsuario();
        model.addAttribute("tipoUsuario", tipoUsuario);
        return "tipoUsuarioNuevo";
    }

    @PostMapping("/nuevoTipoUsuario")
    public String agregarTipoUsuario(@ModelAttribute("tipoUsuario") TipoUsuario tipoUsuario) {
        String nombre = tipoUsuario.getNombre();
        long id = tipoUsuario.getId();
        tipoUsuarioRepository.insertarTipoUsuario(id, nombre);
        return "redirect:/tipodeusuario";
    }
}
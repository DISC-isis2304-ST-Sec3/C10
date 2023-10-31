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
import uniandes.edu.co.proyecto.modelo.ReservaSpa;
import uniandes.edu.co.proyecto.modelo.ReservanHabitaciones;
import uniandes.edu.co.proyecto.modelo.SPA;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.UsanServicios;
import uniandes.edu.co.proyecto.modelo.UsanServiciosPK;
import uniandes.edu.co.proyecto.modelo.UsanSpa;
import uniandes.edu.co.proyecto.modelo.Usan_spaPK;
import uniandes.repositorio.ClienteRepository;
import uniandes.repositorio.ReservaRepository;
import uniandes.repositorio.ReservaSpaRepository;
import uniandes.repositorio.ReservanHabitacionesRepository;
import uniandes.repositorio.SPARepository;
import uniandes.repositorio.ServicioRepository;
import uniandes.repositorio.UsanServiciosRepository;
import uniandes.repositorio.UsanSpaRepository;

@Controller
public class UsanServiciosController {
    @Autowired
    private UsanServiciosRepository UsanServiciosRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private ClienteRepository ClienteRepository;

    

    @GetMapping("/UsanServicios/new")
    public String usanSpaForm(Model model) { 
        model.addAttribute("id", servicioRepository.darServicios());
        model.addAttribute("id", ClienteRepository.darClientes());
        return "UsanServiciosnuevos";
    }
        
    
    

    @PostMapping("/UsanServicios/new/save")
    public String usanSpaGuardar(@ModelAttribute("id_servicio") Integer idServicio,
         @ModelAttribute("id_cliente") Integer idcliente) {

        Cliente cliente = ClienteRepository.darCliente(idcliente);
        Servicio servicio = servicioRepository.darServicio(idServicio);
        UsanServiciosPK pk = new UsanServiciosPK(cliente, servicio);
        UsanServicios usanservicio = new UsanServicios();
        usanservicio.setPk(pk);
        UsanServiciosRepository.insertarUsan_servicios(usanservicio.getPk().getId_cliente().getId(), usanservicio.getPk().getId_Servicio().getId());
    
    
        
            
        return "redirect:/Cliente"; 
         

    }
}

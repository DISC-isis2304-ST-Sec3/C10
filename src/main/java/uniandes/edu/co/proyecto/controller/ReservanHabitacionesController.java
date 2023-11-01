package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Habitacion;
import uniandes.edu.co.proyecto.modelo.Reserva;
import uniandes.edu.co.proyecto.modelo.ReservanHabitaciones;
import uniandes.edu.co.proyecto.modelo.ReservanHabitacionesPK;
import uniandes.edu.co.proyecto.modelo.Servicio;
import uniandes.edu.co.proyecto.modelo.UsanServicios;
import uniandes.edu.co.proyecto.modelo.UsanServiciosPK;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.HabitacionRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.ReservanHabitacionesRepository;
import uniandes.edu.co.proyecto.repositorio.ServicioRepository;
import uniandes.edu.co.proyecto.repositorio.UsanServiciosRepository;

@Controller
public class ReservanHabitacionesController {
    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Autowired
    private ReservanHabitacionesRepository reservanHabitacionesRepository;

    

    @GetMapping("/ReservanHabitaciones/new")
    public String usanSpaForm(Model model) { 
        model.addAttribute("numero", habitacionRepository.darHabitaciones());
        model.addAttribute("id", reservaRepository.darReservas());
        return "Reservanhabitacionesnuevas";
    }
        
    
    

    @PostMapping("/ResrvanHabitaciones/new/save")
    public String usanSpaGuardar(@ModelAttribute("numero_habitacion") Integer numhabitacion,
         @ModelAttribute("id_reserva") Integer idreserva) {

        
        Habitacion habitacion = habitacionRepository.darHabitacion(numhabitacion);
        Reserva reserva = reservaRepository.darReserva(idreserva);
        ReservanHabitacionesPK pk = new ReservanHabitacionesPK(reserva, habitacion);
        ReservanHabitaciones reservanHabitaciones = new ReservanHabitaciones();
        reservanHabitaciones.setPk(pk);
        reservanHabitacionesRepository.insertarReservanHabitaciones(reservanHabitaciones.getPk().getNumero_reserva().getId(),reservanHabitaciones.getPk().getNumero_habitacion().getNumero());

    
    
        
            
        return "redirect:/Cliente"; 
         

    }
}

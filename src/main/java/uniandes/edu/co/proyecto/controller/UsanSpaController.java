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
import uniandes.edu.co.proyecto.modelo.SPA;
import uniandes.edu.co.proyecto.modelo.UsanSpa;
import uniandes.edu.co.proyecto.modelo.Usan_spaPK;
import uniandes.edu.co.proyecto.repositorio.ClienteRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaRepository;
import uniandes.edu.co.proyecto.repositorio.ReservaSpaRepository;
import uniandes.edu.co.proyecto.repositorio.SPARepository;
import uniandes.edu.co.proyecto.repositorio.UsanSpaRepository;

@Controller
public class UsanSpaController {
    @Autowired
    private UsanSpaRepository usanSpaRepository;

    @Autowired
    private SPARepository spaRepository;

    @Autowired
    private ReservaSpaRepository reservaSpaRepository;

    

    @GetMapping("/UsanSpa/new")
    public String usanSpaForm(Model model) { 
        model.addAttribute("id", spaRepository.darSPAS());
        model.addAttribute("NumReserva", reservaSpaRepository.darReservasSpa());
        return "usanSpaNuevo";
    }
        
    
    

    @PostMapping("/UsanSpa/new/save")
    public String usanSpaGuardar(@ModelAttribute("id_spa") Integer idSPA,
         @ModelAttribute("id_reservaspa") Integer idreservaspa) {

        SPA SPA = spaRepository.darSPA(idSPA);
        ReservaSpa reservaSpa = reservaSpaRepository.darReservaSpa(idreservaspa);
        Usan_spaPK pk = new Usan_spaPK(SPA, reservaSpa);
        UsanSpa usanspa = new UsanSpa();
        usanspa.setPk(pk); 
        usanSpaRepository.insertarUsanSpa(usanspa.getPk().getId_Spa().getId(), usanspa.getPk().getId_ReservaSpa().getId());
        
            
        return "redirect:/SPA"; 
         

    }


}

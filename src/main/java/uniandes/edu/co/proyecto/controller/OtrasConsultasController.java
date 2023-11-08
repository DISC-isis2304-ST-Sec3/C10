package uniandes.edu.co.proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OtrasConsultasController {
    @GetMapping("otrasconsultas")
    public String otrasconsultas() {
        return "otrasconsultas";
    }

}

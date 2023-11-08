package uniandes.edu.co.proyecto.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.ConsultasBasicasRepository;

@Controller
public class ConsultasBasicasController {
    @Autowired
    private ConsultasBasicasRepository consultasBasicasRepository;

    @GetMapping("/consultasbasicas")
    public String consultasbasicas() {

        return "consultasbasicas";

    }

    @GetMapping("/req2Form")
    public String openReq2Page() {
        return "req2Form";
    }

    @PostMapping("/req2")
    public String openReq2(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
            Model model) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        Date parsedStartDate = format.parse(startDate);
        Date parsedEndDate = format.parse(endDate);
        List<Object[]> result = consultasBasicasRepository.findConsumoByDateRange(parsedStartDate, parsedEndDate);
        model.addAttribute("result", result);
        return "req2";
    }

}

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

import uniandes.edu.co.proyecto.repositorio.ConsultasBasicasConsumoRepository;

@Controller
public class ConsultasBasicasController {
    @Autowired
    private ConsultasBasicasConsumoRepository consultasBasicasConsumoRepository;

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
        List<Object[]> result = consultasBasicasConsumoRepository.findConsumoByDateRange(parsedStartDate,
                parsedEndDate);
        model.addAttribute("result", result);
        return "req2";
    }

    @GetMapping("/req3Form")
    public String openReq3Page() {
        return "req3Form";
    }

    @PostMapping("/req3")
    public String openReq3() {
        return "req3";
    }

    @GetMapping("/req4Form")
    public String openReq4Form() {
        return "req4Form";
    }

    @PostMapping("/req4")
    public String openReq4(@RequestParam("precio") int precio, @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate, Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date parsedStartDate = null;
        Date parsedEndDate = null;
        try {
            parsedStartDate = formatter.parse(startDate);
            parsedEndDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Integer> servicioIds = consultasBasicasConsumoRepository
                .findServicioIdsByFechaAndPrecioUnitario(parsedStartDate, parsedEndDate, precio);
        model.addAttribute("servicioIds", servicioIds);
        return "req4";
    }

    @GetMapping("/req5Form")
    public String openReq5Form() {
        return "req5Form";
    }

    @PostMapping("/req5")
    public String openReq4(@RequestParam("clientId") Long clientId,
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate, Model model) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
        Date parsedStartDate = null;
        Date parsedEndDate = null;
        try {
            parsedStartDate = formatter.parse(startDate);
            parsedEndDate = formatter.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Object[]> consumos = consultasBasicasConsumoRepository.findConsumoByClienteIdAndFechaBetween(clientId,
                parsedStartDate,
                parsedEndDate);
        model.addAttribute("consumos", consumos);
        return "req5";
    }

}

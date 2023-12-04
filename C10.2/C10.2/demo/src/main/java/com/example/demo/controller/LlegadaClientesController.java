package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.Cliente;
import com.example.demo.repositorio.ClienteRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/llegadaClientes")
public class LlegadaClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public String getAllLlegadaClientes(Model model) {
        List<Cliente> clientes = clienteRepository.findAll();
        model.addAttribute("clientes", clientes);
        return "llegadaClientes";
    }

    @PostMapping("/createFecha")
    public String createFecha(@RequestParam String clienteId, @RequestParam String nuevaFecha) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);

        if (cliente != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                cliente.getFechaLlegada().add(dateFormat.parse(nuevaFecha));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            clienteRepository.save(cliente);
        }

        return "redirect:/llegadaClientes";
    }

    @PostMapping("/updateFecha")
    public String updateFecha(@RequestParam String clienteId, @RequestParam int fechaIndex,
            @RequestParam String nuevaFecha) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);

        if (cliente != null && fechaIndex >= 0 && fechaIndex < cliente.getFechaLlegada().size()) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                cliente.getFechaLlegada().set(fechaIndex, dateFormat.parse(nuevaFecha));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            clienteRepository.save(cliente);
        }

        return "redirect:/llegadaClientes";
    }

    @PostMapping("/deleteFecha")
    public String deleteFecha(@RequestParam String clienteId, @RequestParam int fechaIndex) {
        Cliente cliente = clienteRepository.findById(clienteId).orElse(null);

        if (cliente != null && fechaIndex >= 0 && fechaIndex < cliente.getFechaLlegada().size()) {
            cliente.getFechaLlegada().remove(fechaIndex);
            clienteRepository.save(cliente);
        }

        return "redirect:/llegadaClientes";
    }
}

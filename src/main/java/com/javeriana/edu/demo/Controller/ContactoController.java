package com.javeriana.edu.demo.Controller;

import com.javeriana.edu.demo.Model.Contacto;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {

    // FORMULARIO DE CONTACTO
    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contacto";
    }

}

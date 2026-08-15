package com.javeriana.edu.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.javeriana.edu.demo.Model.Contacto;

@Controller
public class ContactoController {

    @GetMapping("/contacto")
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario";
    }

    @PostMapping("/contacto")
    public String procesarFormulario(@ModelAttribute Contacto contacto, Model model) {
        model.addAttribute("contacto", contacto);
        return "confirmacion";
    }

}

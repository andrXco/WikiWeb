package com.javeriana.edu.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import com.javeriana.edu.demo.Model.WikiSeccion;
import com.javeriana.edu.demo.Repository.WikiSeccionRepository;

@Controller
public class WikiController {

    private final WikiSeccionRepository wikiSeccionRepository;

    public WikiController(WikiSeccionRepository wikiSeccionRepository) {
        this.wikiSeccionRepository = wikiSeccionRepository;
    }

    // INICIO
    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("secciones", wikiSeccionRepository.findAllByOrderByOrdenAsc());
        return "inicio";
    }

    // LISTAR SECCIONES
    @GetMapping("/wiki")
    public String listaSecciones(Model model) {
        model.addAttribute("secciones", wikiSeccionRepository.findAllByOrderByOrdenAsc());
        return "wiki-lista";
    }

    // VER UNA SECCION
    @GetMapping("/wiki/{slug}")
    public String verSeccion(@PathVariable String slug, Model model) {
        WikiSeccion seccion = wikiSeccionRepository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe la sección: " + slug));

        model.addAttribute("seccion", seccion);
        model.addAttribute("secciones", wikiSeccionRepository.findAllByOrderByOrdenAsc());
        return "wiki-detalle";
    }

}

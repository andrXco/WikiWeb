package com.javeriana.edu.demo.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import com.javeriana.edu.demo.Model.Documento;
import com.javeriana.edu.demo.Repository.DocumentoRepository;

@Controller
public class DocumentoController {

    private final DocumentoRepository documentoRepository;

    public DocumentoController(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    // LISTAR DOCUMENTOS DE LA ENTREGA
    @GetMapping("/documentos")
    public String listaDocumentos(Model model) {
        model.addAttribute("documentos", documentoRepository.findAllByOrderByOrdenAsc());
        return "documentos";
    }

    // VER UN DOCUMENTO (el PDF se muestra dentro de la página)
    @GetMapping("/documentos/{slug}")
    public String verDocumento(@PathVariable String slug, Model model) {
        Documento documento = documentoRepository.findBySlug(slug)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe el documento: " + slug));

        model.addAttribute("documento", documento);
        model.addAttribute("documentos", documentoRepository.findAllByOrderByOrdenAsc());
        return "documento-detalle";
    }
}
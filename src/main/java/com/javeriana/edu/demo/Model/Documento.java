package com.javeriana.edu.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Documento de la entrega final publicado en la wiki; el PDF está en static/docs
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 500)
    private String descripcion;

    // Nombre del archivo dentro de static/docs, por ejemplo roles-seguridad.pdf
    @Column(nullable = false)
    private String archivo;

    @Column(nullable = false)
    private Integer orden;

    public Documento(String slug, String titulo, String descripcion, String archivo, Integer orden) {
        this.slug = slug;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.archivo = archivo;
        this.orden = orden;
    }
}
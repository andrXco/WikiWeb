package com.javeriana.edu.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WikiSeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String resumen;

    @Lob
    @Column(nullable = false)
    private String contenido;

    @Column(nullable = false)
    private Integer orden;

    public WikiSeccion(String slug, String titulo, String resumen, String contenido, Integer orden) {
        this.slug = slug;
        this.titulo = titulo;
        this.resumen = resumen;
        this.contenido = contenido;
        this.orden = orden;
    }

}

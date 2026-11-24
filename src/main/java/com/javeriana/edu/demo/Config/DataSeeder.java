package com.javeriana.edu.demo.Config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javeriana.edu.demo.Model.WikiSeccion;
import com.javeriana.edu.demo.Repository.WikiSeccionRepository;
import com.javeriana.edu.demo.Model.Documento;
import com.javeriana.edu.demo.Repository.DocumentoRepository;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner datosIniciales(WikiSeccionRepository wikiSeccionRepository) {
        return args -> {
            if (wikiSeccionRepository.count() > 0) {
                return;
            }

            wikiSeccionRepository.save(new WikiSeccion(
                    "descripcion-general",
                    "Descripción General",
                    "Qué es el Editor de Procesos y qué problema resuelve.",
                    "El proyecto semestral consiste en desarrollar un visor y editor de procesos "
                            + "empresariales que permite la visualización y edición de procesos asociados "
                            + "a empresas, garantizando el aislamiento de información entre organizaciones. "
                            + "Cada empresa opera de forma independiente, sin que sus datos se mezclen con "
                            + "los de otras empresas registradas en el sistema.",
                    1));

            wikiSeccionRepository.save(new WikiSeccion(
                    "objetivo",
                    "Objetivo Principal",
                    "El enfoque del sistema: gestión de procesos, no ejecución.",
                    "El objetivo principal es crear un sistema donde cada empresa tenga sus propios "
                            + "usuarios y procesos exclusivos. El sistema está enfocado únicamente en la "
                            + "gestión de procesos (consulta, creación y modificación), sin incluir la "
                            + "ejecución automática de flujos de trabajo.",
                    2));

            wikiSeccionRepository.save(new WikiSeccion(
                    "entidades",
                    "Entidades Principales",
                    "Los tres conceptos centrales del modelo de dominio.",
                    "El modelo de dominio del sistema gira en torno a tres entidades principales: "
                            + "Empresas, que representan las organizaciones registradas; Usuarios, que están "
                            + "siempre asociados a una empresa específica; y Procesos, que son los elementos "
                            + "de negocio que cada empresa puede consultar, crear y modificar.",
                    3));

            wikiSeccionRepository.save(new WikiSeccion(
                    "arquitectura-entregas",
                    "Arquitectura y Entregas",
                    "Cómo se construye el proyecto de forma incremental.",
                    "El desarrollo del proyecto es incremental y se divide en tres entregas. La primera "
                            + "(14/09/2026) es una aplicación web server-side con Spring Boot, Thymeleaf y JPA, "
                            + "enfocada en el modelado de dominio, la persistencia de datos y las vistas "
                            + "dinámicas. La segunda (21/10/2026) convierte el backend en una API REST con "
                            + "Spring Boot y agrega un frontend en Angular. La entrega final (25/11/2026) "
                            + "integra seguridad con Spring Security, pruebas automatizadas y despliegue en "
                            + "Docker.",
                    4));

            wikiSeccionRepository.save(new WikiSeccion(
                    "criterios-tecnicos",
                    "Criterios Técnicos",
                    "Los lineamientos de diseño que debe cumplir el sistema.",
                    "El proyecto exige una separación clara de responsabilidades siguiendo el patrón MVC "
                            + "y una arquitectura en capas. También se requiere validación de datos, manejo "
                            + "centralizado de excepciones y control de acceso basado en la relación entre "
                            + "empresa y usuario, de forma que cada usuario solo pueda ver y modificar la "
                            + "información de su propia empresa.",
                    5));
        };
    }

    // Documentos de la entrega final; los PDF están en static/docs
    @Bean
    CommandLineRunner documentosIniciales(DocumentoRepository documentoRepository) {
        return args -> {
            if (documentoRepository.count() > 0) {
                return;
            }

            documentoRepository.save(new Documento(
                    "arquitectura-c4",
                    "Arquitectura C4",
                    "Arquitectura de la plataforma con el modelo C4: contexto, contenedores, componentes de la "
                            + "API y de la SPA, despliegue con Docker Compose y decisiones arquitectónicas.",
                    "arquitectura-c4.pdf",
                    2));

            documentoRepository.save(new Documento(
                    "pruebas-funcionales",
                    "Pruebas funcionales",
                    "Casos funcionales del frontend y del backend por historia de usuario, con su resultado, "
                            + "los defectos encontrados y las capturas de la ejecución.",
                    "pruebas-funcionales.pdf",
                    5));

            documentoRepository.save(new Documento(
                    "pruebas-unitarias-sonarqube",
                    "Pruebas unitarias y SonarQube",
                    "Pruebas unitarias y de integración del backend y del frontend, cobertura con JaCoCo y "
                            + "análisis de calidad con SonarQube (Quality Gate).",
                    "pruebas-unitarias-sonarqube.pdf",
                    6));

            documentoRepository.save(new Documento(
                    "roles-seguridad",
                    "Roles y seguridad",
                    "Roles de la aplicación, matriz de permisos, autenticación con JWT, autorización en el "
                            + "backend y en el frontend, riesgos y pruebas de seguridad.",
                    "roles-seguridad.pdf",
                    8));
        };
    }

}

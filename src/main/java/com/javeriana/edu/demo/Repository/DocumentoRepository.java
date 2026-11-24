package com.javeriana.edu.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeriana.edu.demo.Model.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    List<Documento> findAllByOrderByOrdenAsc();

    Optional<Documento> findBySlug(String slug);

}
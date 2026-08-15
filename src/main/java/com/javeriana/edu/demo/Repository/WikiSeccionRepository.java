package com.javeriana.edu.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javeriana.edu.demo.Model.WikiSeccion;

public interface WikiSeccionRepository extends JpaRepository<WikiSeccion, Long> {

    List<WikiSeccion> findAllByOrderByOrdenAsc();

    Optional<WikiSeccion> findBySlug(String slug);

}

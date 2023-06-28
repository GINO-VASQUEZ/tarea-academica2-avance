package com.example.backendmentoria.repositories;

import com.example.backendmentoria.models.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SesionRepository extends JpaRepository<Sesion, Long> {
}

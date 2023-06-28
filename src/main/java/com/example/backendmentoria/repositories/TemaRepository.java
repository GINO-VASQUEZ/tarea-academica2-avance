package com.example.backendmentoria.repositories;

import com.example.backendmentoria.models.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
}

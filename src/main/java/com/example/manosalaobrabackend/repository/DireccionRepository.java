package com.example.manosalaobrabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.manosalaobrabackend.model.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long> {
// Más adelante se harán consultas desde aquí
}

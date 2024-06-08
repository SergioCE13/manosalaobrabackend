package com.example.manosalaobrabackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.manosalaobrabackend.model.Favorito;
import com.example.manosalaobrabackend.model.FavoritoId;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, FavoritoId> {

	
}

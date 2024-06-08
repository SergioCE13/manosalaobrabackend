package com.example.manosalaobrabackend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.model.Favorito;
import com.example.manosalaobrabackend.model.FavoritoId;
import com.example.manosalaobrabackend.repository.FavoritoRepository;

@Service
public class FavoritoService {

    @Autowired
    private FavoritoRepository favoritoRepository;

    // Método para guardar un favorito
    public Favorito saveFavorito(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }

    // Método para obtener todos los favoritos
    public List<Favorito> getAllFavoritos() {
        return favoritoRepository.findAll();
    }

    // Método para obtener un favorito por su ID
    public Optional<Favorito> getFavoritoById(FavoritoId id) {
        return favoritoRepository.findById(id);
    }

    // Método para eliminar un favorito por su ID
    public void deleteFavoritoById(FavoritoId id) {
        favoritoRepository.deleteById(id);
    }

    // Método para actualizar un favorito
    public Favorito updateFavorito(Favorito favorito) {
        return favoritoRepository.save(favorito);
    }
}
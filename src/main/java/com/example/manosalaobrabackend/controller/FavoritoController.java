package com.example.manosalaobrabackend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Favorito;
import com.example.manosalaobrabackend.model.FavoritoId;
import com.example.manosalaobrabackend.service.FavoritoService;

@RestController // Clase que maneja solicitudes HTTP entrentes y envía respuestas HTTP en una aplicación web de SPRING.
@RequestMapping("/api/mao/direccion")
public class FavoritoController {
	
	
	@Autowired
    private FavoritoService favoritoService;

    @PostMapping
    public ResponseEntity<Favorito> createFavorito(@RequestBody Favorito favorito) {
        Favorito savedFavorito = favoritoService.saveFavorito(favorito);
        return ResponseEntity.ok(savedFavorito);
    }

    @GetMapping
    public ResponseEntity<List<Favorito>> getAllFavoritos() {
        List<Favorito> favoritos = favoritoService.getAllFavoritos();
        return ResponseEntity.ok(favoritos);
    }

    @GetMapping("/{clienteFav}/{productoFav}")
    public ResponseEntity<Favorito> getFavoritoById(@PathVariable String clienteFav, @PathVariable String productoFav) {
        FavoritoId id = new FavoritoId(clienteFav, productoFav);
        Optional<Favorito> favorito = favoritoService.getFavoritoById(id);
        return favorito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{clienteFav}/{productoFav}")
    public ResponseEntity<Favorito> updateFavorito(@PathVariable String clienteFav, @PathVariable String productoFav, @RequestBody Favorito favoritoDetails) {
        FavoritoId id = new FavoritoId(clienteFav, productoFav);
        if (!favoritoService.getFavoritoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        favoritoDetails.setId(id);
        Favorito updatedFavorito = favoritoService.updateFavorito(favoritoDetails);
        return ResponseEntity.ok(updatedFavorito);
    }

    @DeleteMapping("/{clienteFav}/{productoFav}")
    public ResponseEntity<Void> deleteFavorito(@PathVariable String clienteFav, @PathVariable String productoFav) {
        FavoritoId id = new FavoritoId(clienteFav, productoFav);
        if (!favoritoService.getFavoritoById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        favoritoService.deleteFavoritoById(id);
        return ResponseEntity.noContent().build();
    }
}
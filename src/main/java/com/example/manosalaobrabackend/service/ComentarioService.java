package com.example.manosalaobrabackend.service;

import com.example.manosalaobrabackend.model.Comentario;
import com.example.manosalaobrabackend.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Optional<Comentario> getComentarioById(Integer id) {
        return comentarioRepository.findById(id);
    }

    public Comentario saveComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario updateComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public void deleteComentario(Integer id) {
        comentarioRepository.deleteById(id);
    }
}

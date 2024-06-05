package com.example.manosalaobrabackend.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.exceptions.ComentarioNotFoundException;
import com.example.manosalaobrabackend.model.Comentario;
import com.example.manosalaobrabackend.repository.ComentarioRepository;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public List<Comentario> getAllComentarios() {
        return comentarioRepository.findAll();
    }

    public Comentario postComentario(Comentario comentario) {
    	return comentarioRepository.save(comentario);
    	} 
    
  //Método delete User
  	public void deleteComentario(Long id) {
  		if(comentarioRepository.existsById(id)) {
  			comentarioRepository.deleteById(id);	
  		}else {
  			throw new ComentarioNotFoundException(id);
  		}
  	}
  	
  	public Comentario getById(Long id){
  			return comentarioRepository.findById(id)
  					.orElseThrow(() ->new ComentarioNotFoundException(id));
  	}
    
 // Este método busca un comentario por su ID y lo actualiza con los detalles proporcionados
    public Comentario patchComentario(Long id, Comentario comentarioEdit) {
        // Busca el comentario en el repositorio por su ID. Si no se encuentra, lanza una excepción UserNotFoundException
        Comentario comentario = comentarioRepository.findById(id)
            .orElseThrow(() -> new ComentarioNotFoundException(id));
        // Actualiza el cuerpo del comentario con el cuerpo proporcionado en los comentarioDetails
        comentario.setCuerpo(comentarioEdit.getCuerpo());
        // Actualiza la fecha_hora del comentario a la fecha y hora actuales
        comentario.setFecha_hora(LocalDateTime.now());
        // Guarda el comentario actualizado en el repositorio y lo devuelve
        return comentarioRepository.save(comentario);
    }
    

}

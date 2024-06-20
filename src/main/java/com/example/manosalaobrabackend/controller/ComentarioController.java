package com.example.manosalaobrabackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.manosalaobrabackend.model.Comentario;
import com.example.manosalaobrabackend.service.ComentarioService;

@RestController
@RequestMapping("/api/mao/comentario")
public class ComentarioController {

	
    @Autowired
    private ComentarioService comentarioService;

    
    @GetMapping
    public List<Comentario> getAllComentarios() {
        return comentarioService.getAllComentarios();
    }
    
    @GetMapping("/{id}")
    public Comentario getComentario(@PathVariable(name = "id") Long id){
    	return comentarioService.getById(id);
    }
    
    @PostMapping
    public Comentario newComentario(@RequestBody Comentario comentario) {
        return comentarioService.postComentario(comentario);
    }
    
	@DeleteMapping("/{id}") // localhost:8081/api/pandevs/user/5 <-- llaves hacen que el path sea variable
	public void dropComentario(@PathVariable(name = "id") Long id) { //pathvariable ayuda a que se reciba cualquier tipo de dato que compagine con id
		comentarioService.deleteComentario(id);
	}

    @PatchMapping("/{id}") // Anotación para indicar que este método maneja solicitudes PATCH en la URL específica
    // Este método maneja las solicitudes PATCH enviadas a la URL /{id}, donde {id} es el identificador del comentario a actualizar
    public Comentario patchComentario(@PathVariable Long id, @RequestBody Comentario comentarioDetails) {
        // Retorna el resultado de la llamada al método patchComentario del servicio comentarioService
        return comentarioService.patchComentario(id, comentarioDetails);
        // Se pasa el id del comentario y los detalles del comentario recibidos en la solicitud al método del servicio para su procesamiento
    }
    
    


}

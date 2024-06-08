package com.example.manosalaobrabackend.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.manosalaobrabackend.exceptions.UserNotFoundException;
import com.example.manosalaobrabackend.model.Vendedor;
import com.example.manosalaobrabackend.repository.VendedorRepository;

@Service
public class VendedorService {
	private VendedorRepository vendedorRepository;

	@Autowired
	public VendedorService(VendedorRepository vendedorRepository) {
		this.vendedorRepository = vendedorRepository;
	}
	
	public List<Vendedor> getAll(){
		return vendedorRepository.findAll();
	}
	
	public String postVendedor(String correo, String nombre, String apellidoPaterno, String apellidoMaterno, String genero, Long telefono, String fechaNacimiento, String password, MultipartFile file) {
		try {
			// Convertir el archivo a un array de bytes
			byte [] foto = file.getBytes();
			
			// Crear un nuevo objeto Registro con los datos recibidos
			Vendedor vendedor = new Vendedor();
			vendedor.setCorreo(correo);
			vendedor.setNombre(nombre);
			vendedor.setApellidoPaterno(apellidoPaterno);
			vendedor.setApellidoMaterno(apellidoMaterno);
			vendedor.setGenero(genero);
			vendedor.setTelefono(telefono);
			vendedor.setFechaNacimiento(fechaNacimiento);
			vendedor.setPassword(password);
			vendedor.setFoto(foto); // Guardar el archivo como un array de bytes en la entidad Registro
			
			// Guardar el registro en la base de datos utilizando el método save del repositorio
			vendedorRepository.save(vendedor);
			
			return "¡Registro guardado correctamente!";
		} catch (IOException e) {
			// Manejo de excepciones si ocurre un error al leer el archivo
			return "Error al leer el archivo: " + e.getMessage();
		} catch (Exception e) {
			// Manejo de excepciones si ocurre un error al guardar el registro en la base de datos
			return "Error al guardar el registro: " + e.getMessage();
		}
	}
	
	public Vendedor getById(String correo) {
		return vendedorRepository.findById(correo)
				.orElseThrow(() -> new UserNotFoundException(correo));
	}
	
	public Vendedor updateVendedor(Vendedor vendedor, String id) {
		return vendedorRepository.findById(id)
				.map(vendedorMap -> {
					vendedorMap.setNombre(vendedor.getNombre());
					vendedorMap.setApellidoPaterno(vendedor.getApellidoPaterno());
					vendedorMap.setApellidoMaterno(vendedor.getApellidoMaterno());
					vendedorMap.setGenero(vendedor.getGenero());
					vendedorMap.setTelefono(vendedor.getTelefono());
					vendedorMap.setFechaNacimiento(vendedor.getFechaNacimiento());
					vendedorMap.setPassword(vendedor.getPassword());
					return vendedorRepository.save(vendedorMap);
				})
				.orElseThrow(() -> new UserNotFoundException(id));
	}
}

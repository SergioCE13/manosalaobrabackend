package com.example.manosalaobrabackend.service;

import java.io.IOException;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;

import com.example.manosalaobrabackend.exceptions.ProductoNotFoundException;

import com.example.manosalaobrabackend.model.Producto;
import com.example.manosalaobrabackend.repository.ProductoRepository;


@Service // Anotación que indica que esta clase es un servicio en la arquitectura Spring
public class ProductoService {
	private ProductoRepository productoRepository;

	//Anotación que indica que este constructor se utilizará para inyectar dependencias de Spring, esto quiere decir que cuando se cree una instancia de ProductoService, se creará una instancia de ProductoRepository y la pasará al constructor de ProductoService.
	@Autowired
	public ProductoService(ProductoRepository productoRepository) { 
		//Asigna el repositorio inyectado al campo de la clase
		this.productoRepository = productoRepository;
	}
	
	//Método publico que retorna una lista de todos los productos.
	public List<Producto> getAll(){
		//Se retornan todos los productos encontrados.
		return productoRepository.findAll();
	}


	
	public String postProducto(String nombre, double precio, double medidaAlto, double medidaAncho, double medidaLargo, String categoria, String descripcion, String tecnica, int stock, String infoAdicional, MultipartFile file) {
        try {
            // Convertir el archivo a un array de bytes
            byte[] foto = file.getBytes();

            // Crear un nuevo objeto Registro con los datos recibidos
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setMedidaAlto(medidaAlto);
            producto.setMedidaAncho(medidaAncho);
            producto.setCategoria(categoria);
            producto.setDescripcion(descripcion);
            producto.setTecnica(tecnica);
            producto.setStock(stock);
            producto.setInfoAdicional(infoAdicional);
            producto.setFoto(foto); // Guardar el archivo como un array de bytes en la entidad Registro

            // Guardar el registro en la base de datos utilizando el método save del repositorio
            productoRepository.save(producto);

            return "¡Registro guardado correctamente!";
        } catch (IOException e) {
            // Manejo de excepciones si ocurre un error al leer el archivo
            return "Error al leer el archivo: " + e.getMessage();
        } catch (Exception e) {
            // Manejo de excepciones si ocurre un error al guardar el registro en la base de datos
            return "Error al guardar el registro: " + e.getMessage();
        }
    }
	
	//productos
	public  Producto getById(String id) {
		return productoRepository.findById(id)
				.orElseThrow(() -> new ProductoNotFoundException(id));
	}
	
	public Producto putProducto(String nombre, double precio, double medidaAlto, double medidaAncho, double medidaLargo, String categoria, String descripcion, String tecnica, int stock, String infoAdicional, MultipartFile file) {
		Producto productoEdit = productoRepository.findById(nombre)
				.orElseThrow(() -> new ProductoNotFoundException(nombre));
			try {
				byte[] foto = file.getBytes();
				productoEdit.setPrecio(precio);
				productoEdit.setMedidaAlto(medidaAlto);
				productoEdit.setMedidaAncho(medidaAncho);
				productoEdit.setMedidaLargo(medidaLargo);
				productoEdit.setCategoria(categoria);
				productoEdit.setDescripcion(descripcion);
				productoEdit.setTecnica(tecnica);
				productoEdit.setStock(stock);
				productoEdit.setInfoAdicional(infoAdicional);
				productoEdit.setFoto(foto);
			}catch(IOException e) {
				e.getMessage();
			}
			return productoRepository.save(productoEdit);
	}
	
	public void deleteProducto(String id) {
		productoRepository.deleteById(id);
	}
	

}


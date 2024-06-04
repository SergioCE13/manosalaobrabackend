package com.example.manosalaobrabackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.manosalaobrabackend.exceptions.TarjetaNotFoundException;
import com.example.manosalaobrabackend.model.Tarjeta;
import com.example.manosalaobrabackend.repository.TarjetaRepository;

@Service
public class TarjetaService {
	private TarjetaRepository tarjetaRepository;
	
	@Autowired
	public TarjetaService(TarjetaRepository tarjetaRepository) {
		this.tarjetaRepository = tarjetaRepository;
	}
	
	public List<Tarjeta> getAll(){
		return tarjetaRepository.findAll();
	}
	
	public Tarjeta postTarjeta(Tarjeta newTarjeta) {
		return tarjetaRepository.save(newTarjeta);
	}
	
	public Tarjeta getById(Long id) {
		return tarjetaRepository.findById(id)
				.orElseThrow(() -> new TarjetaNotFoundException(id));
	}
	
	public void deleteTarjeta(Long id) {
		if(tarjetaRepository.existsById(id)) {
			tarjetaRepository.deleteById(id);
		}else {
			throw new TarjetaNotFoundException(id);
		}
	}
	
	public Tarjeta updateTarjeta(Tarjeta tarjeta, Long id) {
		return tarjetaRepository.findById(id)
				.map(tarjetaMap -> {
					tarjetaMap.setTarjetahabiente(tarjeta.getTarjetahabiente());
					tarjetaMap.setFechaExpiracion(tarjeta.getFechaExpiracion());
					tarjetaMap.setCvv(tarjeta.getCvv());
					tarjetaMap.setBanco(tarjeta.getBanco());
					tarjetaMap.setCompania(tarjeta.getCompania());
					tarjetaMap.setCliente(tarjeta.getCliente());
					return tarjetaRepository.save(tarjetaMap);
				})
				.orElseThrow(() -> new TarjetaNotFoundException(id));
	}
	
	
	
}

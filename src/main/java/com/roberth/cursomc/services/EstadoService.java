package com.roberth.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberth.cursomc.domain.Estado;
import com.roberth.cursomc.repositories.EstadoRepository;
import com.roberth.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public Estado buscar(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()
		));
	}

}

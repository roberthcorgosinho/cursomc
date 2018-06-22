package com.roberth.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberth.cursomc.domain.Cidade;
import com.roberth.cursomc.repositories.CidadeRepository;
import com.roberth.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository repo;
	
	public Cidade buscar(Integer id) {
		Optional<Cidade> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()
		));
	}

}
